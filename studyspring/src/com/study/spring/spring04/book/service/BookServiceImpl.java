package com.study.spring.spring04.book.service;

import com.study.spring.spring04.book.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: javaeessm
 * @description: Service层处理业务逻辑:买书
 * @author: HiBrandt
 * @create: 2020-11-26 21:56
 **/

@Service
public class BookServiceImpl implements BookService  {


    @Autowired
    private BookDao bookDao;  //注意直接写接口更好哦

    @Override
    //@Transactional 可以设置Transactional属性:
    //Propagation.REQUIRED:必须使用调用者的事务(A+B具有传播性)
    //Propagation.REQUIRES_NEW:将调用者的事务挂起，不使用调用者的事务，使用新的事务进行处理(A)
    //A指的是 buyBook B指的是 checkout
    @Transactional
    public void buyBook(String isbn, String username) {

        Integer price = bookDao.selectPrice(isbn);
        bookDao.updateSt(isbn);
        bookDao.updateAccount(username,price);
    }
}
