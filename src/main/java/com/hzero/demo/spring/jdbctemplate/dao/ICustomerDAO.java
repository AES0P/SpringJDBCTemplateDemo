package com.hzero.demo.spring.jdbctemplate.dao;

import com.hzero.demo.spring.jdbctemplate.model.Customer;

import java.util.List;

/**
 * DAO接口，定义能对customer数据库做的所有操作
 */
public interface ICustomerDAO {

    void addCustomer(Customer customer);

    void deleteCustomer(int id);

    void updateCustomer(Customer Customer);

    Customer searchCustomer(int id);

    List<Customer> findAll();

    void insertBatch(List<Customer> customers);

    void insertBatchSQL(String sql);

}
