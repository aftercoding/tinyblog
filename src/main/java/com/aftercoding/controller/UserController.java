package com.aftercoding.controller;


import com.aftercoding.common.lang.Result;
import com.aftercoding.entity.User;
import com.aftercoding.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author anonymous
 * @since 2022-09-08
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequiresAuthentication
    @GetMapping("/index")
    public Result index(){
//    public Object index(){
        User user = userService.getById(1L);
//        return userService.getById(1);
        return Result.succ(user);
//        return Result.succ(200, "operation success", user);
    }
}
