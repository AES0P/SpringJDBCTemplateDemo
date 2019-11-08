package com.hzero.demo.spring.jdbctemplate.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "customer")
public class Customer {

    @Value("17876")
    private int id;

    @Value("Aesop")
    private String name;

    @Value("18")
    private String age;

    public Customer() {
    }

    public Customer(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int cust_id) {
        this.id = cust_id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer [" +
                "cust_id=" + this.getId() +
                ", name=" + this.getName() +
                ", age=" + this.getAge() +
                "]";
    }

}
