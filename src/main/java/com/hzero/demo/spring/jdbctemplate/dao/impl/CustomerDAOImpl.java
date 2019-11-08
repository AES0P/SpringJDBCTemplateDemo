package com.hzero.demo.spring.jdbctemplate.dao.impl;

import com.hzero.demo.spring.jdbctemplate.dao.ICustomerDAO;
import com.hzero.demo.spring.jdbctemplate.model.Customer;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * 实现customerdao接口里定义的方法
 */
@Repository(value = "customerDao")
public class CustomerDAOImpl implements ICustomerDAO {

    // 使用注解，拿出XML中已处理好的bean到这里
    @Resource(name = "jt")
    private JdbcTemplate jt;

    @Override
    public void addCustomer(Customer customer) {

        String sql = "insert into customer values(?,?,?)";
        //如果ID是自增，则传入null，如果不是自增，则需要赋值
        jt.update(sql, customer.getId(), customer.getName(), customer.getAge());

    }

    @Override
    public void deleteCustomer(int id) {
        String sql = "delete from customer where cust_id = ?";
        jt.update(sql, id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        String sql = "update customer set name =?,age=? where cust_id = ?";
        jt.update(sql, customer.getName(), customer.getAge(), customer.getId());
    }

    @Override
    public Customer searchCustomer(int id) {
        String sql = "select * from customer where cust_id=?";
        return jt.queryForObject(sql, new UserRowMapper(), id);
    }

    @Override
    public List<Customer> findAll() {
        String sql = "select * from customer";

//        //不想实现RowMapper<object>接口，可使用这个方法,但是获取ID时可能取不到值
//        return jt.query(sql, new BeanPropertyRowMapper(Customer.class));

        return jt.query(sql, new UserRowMapper());
    }

    @Override
    public void insertBatch(final List<Customer> customers) {

//        jt.batchUpdate(new String[]{sql});

        String sql = "INSERT INTO CUSTOMER " + "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";

        jt.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Customer customer = customers.get(i);
                ps.setLong(1, customer.getId());
                ps.setString(2, customer.getName());
                ps.setString(3, customer.getAge());
            }

            @Override
            public int getBatchSize() {
                return customers.size();
            }
        });

    }

    @Override
    public void insertBatchSQL(String sql) {
        jt.batchUpdate(sql);
    }

    /**
     *
     */
    class UserRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            //rs为返回结果集，以每行为单位封装着
            Customer user = new Customer();
            user.setId(rs.getInt("cust_id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getString("age"));
            return user;
        }
    }

}
