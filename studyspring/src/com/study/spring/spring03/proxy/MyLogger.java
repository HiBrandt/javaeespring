package com.study.spring.spring03.proxy;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-10-16 16:44
 **/
public class MyLogger {

    public static void before(String methodName, String args) {
        System.out.println("method:"+methodName+",arguments:"+args);
    }

    public static void after(String methodName, Object reslut) {
        System.out.println("method:"+methodName+",reslut:"+reslut);
    }

    public static void throwing() {
        System.out.println("有异常了。。。。");
    }
}
