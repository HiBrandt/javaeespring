package com.study.spring.spring03.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @program: javaeessm
 * @description: 动态代理类
 * @author: HiBrandt
 * @create: 2020-10-16 15:42
 **/
public class ProxyUtil {


    //有参构造器是为了给属性赋值，这样就能调用目标对象的方法了
    public ProxyUtil(Object mathImpl) {
        MathImpl = mathImpl;
    }

    //1.动态代理目标对象
    private Object MathImpl;


    //2.获取代理对象的方法
    public Object getProxy(){

        //4.当前类的类加载器(因为要创建代理对象，对象是根据代理类来的，代理类必须要类加载器加载)
        ClassLoader classLoader = this.getClass().getClassLoader();
        //5.目标对象所实现的接口
        Class<?>[] interfaces = MathImpl.getClass().getInterfaces();
        //6.执行处理器(匿名对象处理了)

        //3.调用JDK原生的返回代理对象的静态方法，前提是被代理的类必须实现接口
        return Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                try {
                    MyLogger.before(method.getName(), Arrays.toString(args));
                    //底层还是调用目标对象的方法
                    //执行这个目标对象的某个方法，返回的就是目标对象的方法的返回值
                    Object invoke = method.invoke(MathImpl, args);
                    MyLogger.after(method.getName(), invoke);
                    return invoke;
                } catch (IllegalAccessException e) {
                    MyLogger.throwing();
                    e.printStackTrace();
                } finally {
                    System.out.println("哪里都有我");
                }
                return null;
            }
        });
    }



}
