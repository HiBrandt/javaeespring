package com.study.spring.spring02.dao;


import org.springframework.stereotype.Repository;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-08-20 21:15
 **/

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void addUser() {
        System.out.println("添加成功");
    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl");
    }


}
