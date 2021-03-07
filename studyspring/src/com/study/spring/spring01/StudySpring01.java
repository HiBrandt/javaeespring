package com.study.spring.spring01;

import com.study.spring.spring01.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: javaeessm
 * @description: Spring笔记01
 * @author: HiBrandt
 * @create: 2020-08-15 15:56
 *
 * Spring是通过反射创建对象的。
 *
 * IOC: 把之前程序员手动管理对象这件事交由程序本身，由Spring进行管理控制
 *      传统方式:   我想吃饭    我需要买菜做饭
        反转控制:   我想吃饭    饭来张口
   DI:  依赖注入  DI是IOC的一种具体实现方式 。 依赖：就是对象属性之间的依赖关系  注入：就是给对象的属性赋值
   xml文件：
    普通bean：
      <bean/> 就是spring管理的一个对象  id 是唯一表示(可有可无)  class 是 包名+类名
      属性赋值：
        --> property赋值  通过set方法  （最常用）
          -->value元素只能给字面量 以及 null值 赋值 不能给属性是其他自定义类型的属性赋值
          -->可以用ref（引用）元素给属性是自定义类的属性赋值  （也可以通过内部bean来达到相同的目的，但是不推荐）
          --> 给属性赋值为null  --> <null/>元素
          --> 给集合属性赋值 <list>标签 <array/>标签 <<map/>标签
             -->使用起来给集合赋值 同样是 value、ref、内部bean的方式给集合元素赋值
             -->也可以将集合bean的配置拿到外面，供其他bean引用,需要用到 </util:list> 标签 该标签下也是用 value或者ref
        --> <constructor-arg/>  通过构造器   （如果出现赋值的属性混乱问题，可以用index元素以及type元素锁定是哪一个属性）
        --> p名称空间的方式
      工厂bean：
      Spring中有两种类型的bean，一种是普通bean，另一种是工厂bean，即FactoryBean。
      必须实现  FactoryBean 接口
      工厂bean和普通bean不同其返回的是该工厂bean的  getObject方法  所返回的对象


   使用此方法获取对象时，要求spring所管理的此类型的对象只能有一个（反射）--> Person person = ac.getBean(Person.class);
   推荐使用这种方式（id+反射）：Person person = ac.getBean("personTwo", Person.class);
 *
 *
 **/

public class StudySpring01 {


    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("/com/study/spring/spring01/conf/applicationContext.xml");
        //  也可以   ac还有close方法
        //  ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/com/study/spring/spring01/conf/applicationContext.xml");

        HelloWorld hw = (HelloWorld) ac.getBean("helloWorld");
        System.out.println(hw);

        //工厂bean
        Object carfactory = ac.getBean("carfactory");
        System.out.println(carfactory);

    }
}
