package com.example.clear.notes.common.api;

import com.example.clear.notes.common.entity.User;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/5/8 14:36
 */
public interface UserService {
    User findByUsername(String username);
}
