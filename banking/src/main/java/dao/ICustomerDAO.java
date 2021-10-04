package dao;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {
    List<Customer> selectAllCustomer();

    void insert(Customer customer) throws SQLException;

    boolean edit(Customer customer) throws SQLException;

    boolean remove(int id) throws SQLException;

    Customer selectCustomer(int id) throws SQLException;

    boolean sendMoney(int id, double money) throws SQLException;

    boolean withdraw(int id, double money) throws SQLException;





}
