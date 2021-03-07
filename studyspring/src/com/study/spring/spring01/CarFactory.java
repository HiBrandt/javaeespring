package com.study.spring.spring01;

import org.springframework.beans.factory.FactoryBean;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-08-16 19:44
 **/
public class CarFactory implements FactoryBean {
    @Override
    public Object getObject() throws Exception {

        Car car = new Car();
        car.setBrand("凯迪拉克");
        car.setPrice(250000.0);
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
