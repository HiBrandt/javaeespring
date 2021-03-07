package com.study.spring.spring01;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-08-15 15:42
 **/
public class HelloWorld {

    private Integer id;

    private String name;

    public HelloWorld() {

    }

    public HelloWorld(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "HelloWorld{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
