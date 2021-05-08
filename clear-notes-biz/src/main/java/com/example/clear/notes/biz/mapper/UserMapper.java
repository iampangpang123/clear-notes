package com.example.clear.notes.biz.mapper;

import com.example.clear.notes.common.entity.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/5/8 14:34
 */
public interface UserMapper  extends Mapper<User> {
    User findByUsername(String username);
    User getByUsernameAndPassword(String username,String password);
}
