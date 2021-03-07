package com.study.spring.spring02;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-08-17 22:17
 **/
public class AfterHandle implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {

        Person person = (Person) o;
        if(person.getSex().equals("男")){
            person.setName("张无忌");
        }else {
            person.setName("周芷若");
        }

        return person;
    }

    //这里必须返回 bean 默认是返回null的
    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
