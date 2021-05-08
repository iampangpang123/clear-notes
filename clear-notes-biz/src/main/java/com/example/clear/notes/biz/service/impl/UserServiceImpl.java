package com.example.clear.notes.biz.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.example.clear.notes.biz.mapper.UserMapper;
import com.example.clear.notes.common.api.UserService;
import com.example.clear.notes.common.dto.UserDTO;
import com.example.clear.notes.common.entity.User;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.HtmlUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;

/**
 * @author 唐涛
 * @description: UserServiceImpl
 * @date 2021/5/8 14:37
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        List<User> users = userMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(users)) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<UserDTO> list() {
        List<User> users = userMapper.selectAll();
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return JSON.parseArray(JSON.toJSONString(users), UserDTO.class);
    }

    @Override
    public boolean isExist(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        int i = userMapper.selectCountByExample(example);
        return i > 0;
    }

    @Override
    public User get(String username, String password) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        criteria.andEqualTo("password", password);
        return userMapper.selectOneByExample(example);
    }

    @Override
    public int register(User user) {
        String username = user.getUsername();
        String name = user.getName();
        String phone = user.getPhone();
        String email = user.getEmail();
        String password = user.getPassword();

        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        phone = HtmlUtils.htmlEscape(phone);
        user.setPhone(phone);
        email = HtmlUtils.htmlEscape(email);
        user.setEmail(email);
        user.setEnabled(true);

        if (username.equals("") || password.equals("")) {
            return 0;
        }

        boolean exist = isExist(username);

        if (exist) {
            return 2;
        }

        // 默认生成 16 位盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();

        user.setSalt(salt);
        user.setPassword(encodedPassword);
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public void updateUserStatus(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", user.getUsername());
        User userInDB = userMapper.selectOneByExample(example);
        Optional.ofNullable(userInDB).ifPresent(value -> {
            value.setEnabled(user.isEnabled());
            userMapper.insert(value);
        });
    }

    @Override
    public User resetPassword(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", user.getUsername());
        User userInDB = userMapper.selectOneByExample(example);
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        userInDB.setSalt(salt);
        String encodedPassword = new SimpleHash("md5", "123", salt, times).toString();
        userInDB.setPassword(encodedPassword);
        userMapper.insertSelective(userInDB);
        return userInDB;
    }

    /**
     * todo  后面需要增加权限修改
     *
     * @param user
     */
    @Override
    public void editUser(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", user.getUsername());
        User userInDB = userMapper.selectOneByExample(example);
        userInDB.setName(user.getName());
        userInDB.setPhone(user.getPhone());
        userInDB.setEmail(user.getEmail());
        userMapper.insertSelective(userInDB);
    }

    @Override
    public void deleteById(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

}
