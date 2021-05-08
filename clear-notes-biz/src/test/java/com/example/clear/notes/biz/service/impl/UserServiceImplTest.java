package com.example.clear.notes.biz.service.impl;

import com.example.clear.notes.common.api.UserService;
import com.example.clear.notes.common.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/5/8 14:58
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void findByUsername() {
        User admin = userService.findByUsername("admin");
        System.out.println(admin.toString());
    }
}
