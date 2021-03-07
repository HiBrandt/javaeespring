package com.study.spring.spring04.book.controller;

import com.study.spring.spring04.book.service.BookService;
import com.study.spring.spring04.book.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaeessm
 * @description: controller层 接收参数调用业务逻辑方法 这里的参数是写死了
 * @author: HiBrandt
 * @create: 2020-11-26 21:56
 **/
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CashierService cashierService;

    public void buyBook() {
        bookService.buyBook("ISBN-005", "Tom");
    }

    public void checkoutBook() {
        List<String> list = new ArrayList<>();
        list.add("ISBN-004");
        list.add("ISBN-005");
        cashierService.checkout(list, "Tom");
    }


}
