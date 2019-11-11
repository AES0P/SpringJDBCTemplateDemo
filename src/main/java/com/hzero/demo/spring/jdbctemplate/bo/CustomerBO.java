package com.hzero.demo.spring.jdbctemplate.bo;

import com.hzero.demo.spring.jdbctemplate.model.Customer;

import java.util.List;

/**
 * 定义当前业务具有哪些功能
 */
public interface CustomerBO {

    void addCustomer(Customer customer);

    void deleteCustomer(int id);

    void updateCustomer(Customer customer);

    void searchCustomer(int id);

    void findAll();

    void insertBatch(List<Customer> customers);

    void insertBatchSQL(final String sql);

}
