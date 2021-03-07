package com.study.spring.spring02;

import javax.jws.Oneway;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-08-17 22:02
 **/
public class Person {

    private Integer id;

    private String name;

    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {

        System.out.println("Two:属性赋值");
        this.sex = sex;
    }

    public Person(Integer id, String name, String sex) {

        System.out.println("One:创建对象");
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Person() {
        System.out.println("One:创建对象");
    }

    public void init(){
        System.out.println("Three:初始化方法");
    }

    public void destroy(){
        System.out.println("Five:销毁方法");
    }


    @Override
    public String toString() {
        return "Four: Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
