package com.example.clear.notes.web.controller;

import com.example.clear.notes.common.api.UserService;
import com.example.clear.notes.common.result.Result;
import com.example.clear.notes.common.result.ResultFactory;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/5/8 11:32
 */
@RestController
public class UserController {

    @Reference(check = false)
    UserService userService;

    @GetMapping("/api/admin/user")
    public Result listUsers() {
        return ResultFactory.buildSuccessResult(userService.findByUsername("admin"));
    }


}
