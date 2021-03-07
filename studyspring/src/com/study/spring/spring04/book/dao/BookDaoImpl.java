package com.study.spring.spring04.book.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @program: javaeessm
 * @description: 第一次都忘记写注解了 该打
 * @author: HiBrandt
 * @create: 2020-11-26 21:55
 **/

@Repository
public class BookDaoImpl implements BookDao {

    //自动装配
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer selectPrice(String isbn) {
        String sql = "select price from book where isbn = ?";
        Integer price = jdbcTemplate.queryForObject(sql, new Object[]{isbn}, Integer.class);
        return price;
    }

    @Override
    public void updateSt(String isbn) {
        String sql = "select stock from book_stock where isbn = ?";//查询库存
        String updateSql = "update book_stock set stock=stock-1 where isbn= ?";
        Integer stock = jdbcTemplate.queryForObject(sql, new Object[]{isbn}, Integer.class);
        //判断库存是否小于0
        if(stock<=0){
            throw new RuntimeException();
        }else {
            //扣减库存
            jdbcTemplate.update(updateSql,isbn);
        }

    }

    @Override
    public void updateAccount(String username, Integer price) {

        String sql  = "select balance from account where username = ?"; //查询余额
        String updateSql = "update account set balance=balance-? where username= ?";
        Integer balance = jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);

        //判断余额是否足够
        if(balance<price){
            throw new RuntimeException();
        }else {
            jdbcTemplate.update(updateSql,price,username);
        }
    }
}
