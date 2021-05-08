package com.example.clear.notes.common.api;

import com.example.clear.notes.common.dto.UserDTO;
import com.example.clear.notes.common.entity.User;

import java.util.List;

/**
 * @author 唐涛
 * @description: UserService
 * @date 2021/5/8 14:36
 */
public interface UserService {
    User findByUsername(String username);

    /**
     * 查询所有user信息
     *
     * @return
     */
    List<UserDTO> list();

    boolean isExist(String username);

    User get(String username, String password);

    int register(User user);

    void updateUserStatus(User user);

    User resetPassword(User user);

    void editUser(User user);

    void deleteById(int id);
}
