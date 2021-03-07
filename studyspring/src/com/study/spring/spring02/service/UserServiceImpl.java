package com.study.spring.spring02.service;

import com.study.spring.spring02.dao.UserDao;
import com.study.spring.spring02.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-08-20 21:17
 **/
@Component
public class UserServiceImpl implements UserService {


  //  private UserDao userDao = new UserDaoImpl();  旧的办法
    @Autowired
    @Qualifier(value="mybatisUserDaoImpl")
    private UserDao userDao;  // 新的办法

    @Override
    public void addUser() {
        userDao.addUser();
    }

    public UserServiceImpl() {
        System.out.println("UserServiceImpl");
    }

}
