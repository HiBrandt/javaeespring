package com.study.spring.spring02.controller;

import com.study.spring.spring02.service.UserService;
import com.study.spring.spring02.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-08-20 21:18
 **/
@Controller
public class UserController {


   // private UserService userService = new UserServiceImpl();  旧的办法
    @Autowired
    private UserService userService;   //新的办法

    public void addUser(){
        userService.addUser();
    }

    public UserController() {
        System.out.println("UserController");
    }
}
