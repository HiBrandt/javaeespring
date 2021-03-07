package com.study.spring.spring01;

/**
 * @program: javaeessm
 * @description: 汽车演示类
 * @author: HiBrandt
 * @create: 2020-08-16 19:41
 **/
public class Car {

    private String brand;  //品牌

    private Double price;  //价格


    public Car(String brand, Double price) {
        this.brand = brand;
        this.price = price;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
