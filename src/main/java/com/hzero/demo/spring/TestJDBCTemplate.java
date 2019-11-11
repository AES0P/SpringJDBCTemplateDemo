package com.hzero.demo.spring;

import com.hzero.demo.spring.jdbctemplate.bo.impl.CustomerBOImpl;
import com.hzero.demo.spring.jdbctemplate.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 本类用于测试JDBC -- 在MySQL数据库中的CRUD操作
 */
public class TestJDBCTemplate {

    @org.junit.jupiter.api.Test
    public void test() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerBOImpl customerService = (CustomerBOImpl) applicationContext.getBean("customerService");

        //待添加的客户集
        List<Customer> customers = new ArrayList<Customer>();

        //这里获取到的bean是有初始值的 17876 aesop 18
        Customer customer = (Customer) applicationContext.getBean("customer");

        customers.add(new Customer(17877, "cust 1", "21"));
        customers.add(new Customer(17878, "cust 2", "22"));
        customers.add(new Customer(17879, "cust 3", "23"));

        //单个添加
        customerService.addCustomer(customer);
        //批量添加
        customerService.insertBatch(customers);

        customerService.findAll();

        //批量处理
        customerService.insertBatchSQL("UPDATE CUSTOMER SET NAME ='BATCH DATA' WHERE CUST_ID > 17876");
        customerService.findAll();


    }


}
