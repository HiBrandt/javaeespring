package com.study.spring.spring04.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaeessm
 * @description: 结算服务 可以一次买多本书
 * @author: HiBrandt
 * @create: 2020-12-01 22:27
 **/
@Service
//@Transactional
public class CashierServiceImpl implements CashierService {


    //别死脑筋 这里一定是Dao层的接口  其他Service层实现了功能方法这里也可以写其他Service层接口
    @Autowired
    private BookService bookService;

    /**
     * @Transactional:对方法中所有的操作作为一个事务进行管理
     * 在方法上使用，只对方法有效果
     * 在类上使用，对类中所有的方法都有效果
     * @Transactional中可以设置的属性：
     *
     * propagation：A方法和B方法都有事务，当A在调用B时，会将A中的事务传播给B方法，B方法对于事务的处理方式就是事务的传播行为(A+B)
     * Propagation.REQUIRED:必须使用调用者的事务
     * Propagation.REQUIRES_NEW:将调用者的事务挂起，不使用调用者的事务，使用新的事务进行处理
     *
     * A指的是 buyBook B指的是 checkout
     *
     * isolation：事务的隔离级别，在并发的情况下，操作数据的一种规定
     * 			读未提交：脏读   1
     * 			读已提交：不可重复读   2
     * 			可重复读：幻读   4
     * 			串行化：性能低，消耗大   8
     *
     *
     * timeout:在事务强制回滚前最多可以执行（等待）的时间
     *
     * readOnly:指定当前事务中的一系列的操作是否为只读
     * 若设置为只读，不管事务中有没有写的操作，mysql都会在请求访问数据的时候，不加锁，提高性能
     * 但是如果有写操作的情况，建议一定不能设置只读。（一个事务中只有读的操作会提高性能（不加锁），但是如果有写的操作不建议设置）
     *
     * rollbackFor|rollbackForClassName|noRollbackFor|noRollbackForClassName:设置事务回滚的条件，因为什么而回滚
     */

    @Transactional //开启事务
    @Override
    public void checkout(List<String> isbns, String username) {

        for (String isbn : isbns) {
            bookService.buyBook(isbn,username);
        }
    }
}
