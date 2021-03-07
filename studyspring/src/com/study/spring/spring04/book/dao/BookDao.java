package com.study.spring.spring04.book.dao;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-11-26 21:55
 **/
public interface BookDao {

    // 1.查询书的价格 (书的编号)
    Integer selectPrice(String isbn);

    // 2.扣减书的库存 (书的编号)
    void updateSt(String isbn);

    // 3.扣减客户账户的余额
    void updateAccount(String username,Integer price);


}
