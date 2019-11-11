package com.hzero.demo.spring.jdbctemplate.bo.impl;

import com.hzero.demo.spring.jdbctemplate.bo.CustomerBO;
import com.hzero.demo.spring.jdbctemplate.dao.impl.CustomerDAOImpl;
import com.hzero.demo.spring.jdbctemplate.model.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 这个类主要用于处理业务逻辑
 * <p>
 * 数据库操作(CRUD)工作不应该参与这一个类，而是通过一个DAO来做到这一点
 * <p>
 * 即这个类里面只写和业务有关的逻辑，而CRUD相关操作的实现，可由相应的DAO层去实现
 */
@Service(value = "customerService")
public class CustomerBOImpl implements CustomerBO {

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
