package com.hzero.demo.spring.jdbctemplate.service;

import com.hzero.demo.spring.jdbctemplate.dao.impl.CustomerDAOImpl;
import com.hzero.demo.spring.jdbctemplate.model.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 这个类主要用于统一处理业务逻辑，避免在最终调用处去写繁琐的代码
 */
@Service(value = "customerService")
public class CustomerService {

    // 以注入方式赋值
    @Resource(name = "customerDao")
    private CustomerDAOImpl customerDAO;

    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    public void searchCustomer(int id) {
        System.out.println(customerDAO.searchCustomer(id));
    }

    public void findAll() {

        List<Customer> customerList = customerDAO.findAll();
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }

        System.out.println("Total counts:" + customerList.size());

    }

    public void insertBatch(List<Customer> customers) {
        customerDAO.insertBatch(customers);
    }

    public void insertBatchSQL(final String sql) {
        customerDAO.insertBatchSQL(sql);
    }

}
