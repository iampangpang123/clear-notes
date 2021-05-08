package com.example.clear.notes.common.dto;

import com.example.clear.notes.common.dto.base.OutputConverter;
import com.example.clear.notes.common.entity.AdminRole;
import com.example.clear.notes.common.entity.User;
import lombok.Data;
import lombok.ToString;

import java.util.List;


/**
 * @author 唐涛
 * @description: UserDTO
 * @date 2021/5/8 14:36
 */
@Data
@ToString
public class UserDTO implements OutputConverter<UserDTO, User> {

    private int id;

    private String username;

    private String name;

    private String phone;

    private String email;

    private boolean enabled;

    private List<AdminRole> roles;

}
