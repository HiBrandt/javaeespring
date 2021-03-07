package com.study.spring.spring03.proxy;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-10-16 15:37
 **/
public class MathImpl implements MathI {

    @Override
    public int add(int i , int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i , int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int mul(int i , int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int div(int i , int j) {
        int result = i + j;
        return result;
    }
}
