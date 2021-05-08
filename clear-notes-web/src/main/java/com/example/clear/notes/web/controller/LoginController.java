package com.example.clear.notes.web.controller;

import com.alibaba.nacos.common.util.Md5Utils;
import com.example.clear.notes.common.api.UserService;
import com.example.clear.notes.common.entity.User;
import com.example.clear.notes.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import sun.security.util.Password;

import java.util.Objects;

/**
 * @description:
 * @author: ttao
 * @create: 2021-05-08 21:38
 **/
@RestController
@Slf4j
@CrossOrigin
public class LoginController {


    @Reference(check = false)
    UserService userService;

    /**
     * todo 先写简单登录，去掉shiro
     *
     * @param requestUser
     * @return
     */
    @PostMapping("/api/login")
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        String md5Password = Md5Utils.getMD5(requestUser.getPassword().getBytes());

        //    Subject subject = SecurityUtils.getSubject();
        //        subject.getSession().setTimeout(10000);
        //   UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        //  usernamePasswordToken.setRememberMe(true);
        log.info(username);
        log.info(md5Password);
        try {
            //  subject.login(usernamePasswordToken);
            User user = userService.get(username, md5Password);
            if (Objects.isNull(user)) {
                return Result.buildFailResult("账号或者密码不正确");
            }
//            if (user.getEnabled()!=1) {
//                return Result.buildFailResult("该用户已被禁用");
//            }
            return Result.buildSuccessResult(username);
        } catch (IncorrectCredentialsException e) {
            return Result.buildFailResult("密码错误");
        } catch (UnknownAccountException e) {
            return Result.buildFailResult("账号不存在");
        }
    }


}
