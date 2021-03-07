package com.study.spring.spring04.book.service;

import java.util.List;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-12-01 22:26
 **/
public interface CashierService {

    /**
     * 购买多本书
     */
    void checkout(List<String> isbns, String username);
}
