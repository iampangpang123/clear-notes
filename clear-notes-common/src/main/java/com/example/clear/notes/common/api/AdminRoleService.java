package com.example.clear.notes.common.api;

import com.example.clear.notes.common.entity.AdminRole;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @description:
 * @author: ttao
 * @create: 2021-05-08 20:19
 **/
public interface AdminRoleService {

    List<AdminRole> list();

    AdminRole findById(int id);

    void addOrUpdate(AdminRole adminRole);

    List<AdminRole> listRolesByUser(String username);

    AdminRole updateRoleStatus(AdminRole role);

    boolean editRole(AdminRole requestRole);


}
