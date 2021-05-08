package com.example.clear.notes.biz.service.impl;

import com.example.clear.notes.biz.mapper.AdminRoleMapper;
import com.example.clear.notes.common.api.AdminRoleService;
import com.example.clear.notes.common.entity.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:
 * @author: ttao
 * @create: 2021-05-08 20:19
 **/
public class AdminRoleServiceImpl implements AdminRoleService {
    @Autowired
    private AdminRoleMapper adminRoleMapper;


    @Override
    public List<AdminRole> list() {
        return null;
    }

    @Override
    public AdminRole findById(int id) {
        return null;
    }

    @Override
    public void addOrUpdate(AdminRole adminRole) {

    }

    @Override
    public List<AdminRole> listRolesByUser(String username) {
        return null;
    }

    @Override
    public AdminRole updateRoleStatus(AdminRole role) {
        return null;
    }

    @Override
    public boolean editRole(AdminRole requestRole) {
        return false;
    }
}
