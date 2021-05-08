package com.example.clear.notes.biz.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.clear.notes.biz.mapper.UserMapper;
import com.example.clear.notes.common.api.UserService;
import com.example.clear.notes.common.entity.User;
import jdk.nashorn.internal.runtime.options.Option;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author 唐涛
 * @description: TODO
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

}
