package com.study.spring.spring04.book.test;

import com.study.spring.spring04.book.controller.BookController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-11-26 22:07
 **/
public class Test {

    // 第一次整体忘记写注解了  该打
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("/com/study/spring/spring04/conf/book.xml");

        //接收客户端传来的参数还是Controller
        BookController bookController = ac.getBean("bookController", BookController.class);
       // bookController.buyBook();
        bookController.checkoutBook();

    }


}
