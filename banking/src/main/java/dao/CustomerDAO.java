package dao;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerDAO implements ICustomerDAO{

    private final String url =  "jdbc:mysql://localhost:3306/customer-management?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "581549";
    private static final String SELECT_CUSTOMER = "SELECT * FROM customer";
    private static final String ADD_CUSTOMER = "INSERT INTO customer (full_name, phone_number, email) VALUES (?,?,?)";
    private static final String SELECT_CUSTOMER_ID = "SELECT full_name, phone_number, email, balance FROM customer WHERE id = ?";
    private static final String UPDATE_CUSTOMER = "UPDATE customer SET full_name = ?, phone_number = ?,email= ?, balance = ? WHERE id = ?";
    private static final String DELETE_CUSTOMER = "DELETE FROM customer WHERE id = ?";
    private static final String UPDATE_BALANCE_ID = "{CALL `customer-management`.send_money(?, ?)}";
    private static final String WITHDRAW_SQL = "{call `customer-management`.showWithdraw_money(?,?)}";

    public CustomerDAO() {
    }

    public Connection getConnectionJDBC() {
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, jdbcUsername, jdbcPassword);

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = getConnectionJDBC();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(preparedStatement);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullName= resultSet.getString("full_name");
                String phone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                double balance = resultSet.getDouble("balance");
                customerList.add((new Customer(id, fullName,phone,email,balance)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void insert(Customer customer) throws SQLException {
        Connection connection = getConnectionJDBC();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER);
        preparedStatement.setString(1,customer.getFullName());
        preparedStatement.setString(2,customer.getPhoneNumber());
        preparedStatement.setString(3,customer.getEmail());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean edit(Customer customer) throws SQLException {
        boolean chek ;
        Connection connection = getConnectionJDBC();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1,customer.getFullName());
            preparedStatement.setString(2,customer.getPhoneNumber());
            preparedStatement.setString(3,customer.getEmail());
            preparedStatement.setString(4,String.valueOf(customer.getBalance()));
            preparedStatement.setInt(5, customer.getId());
            chek = preparedStatement.executeUpdate() > 0;
            return chek;

    }


    @Override
    public boolean remove(int id) throws SQLException {
        boolean chek;
        Connection connection = getConnectionJDBC();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
        preparedStatement.setInt(1,id);
        chek = preparedStatement.executeUpdate() > 0;
        return chek;

    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        Connection connection = getConnectionJDBC();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_ID)) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("full_name");
                String phone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                double balance = resultSet.getDouble("balance");
                customer = new Customer(name, phone, email, balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public boolean sendMoney(int id, double money) throws SQLException {
        boolean chek;
        Connection connection = getConnectionJDBC();
        CallableStatement callableStatement = connection.prepareCall(UPDATE_BALANCE_ID);
        callableStatement.setInt(1,id);
        callableStatement.setDouble(2,money);
        chek = callableStatement.execute();
        return chek;
    }

    @Override
    public boolean withdraw(int id, double money) throws SQLException {
        boolean chek;
        Connection connection = getConnectionJDBC();
        CallableStatement callableStatement = connection.prepareCall(WITHDRAW_SQL);
        callableStatement.setInt(1, id);
        callableStatement.setDouble(2, money);
        chek = callableStatement.execute();
        return chek;


    }
}
