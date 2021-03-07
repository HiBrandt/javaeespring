package com.study.spring.spring02.dao;

import org.springframework.stereotype.Repository;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-08-20 22:32
 **/
@Repository
public class MybatisUserDaoImpl implements UserDao {


    @Override
    public void addUser() {
        System.out.println("MybatisUserDaoImpl");
    }
}
