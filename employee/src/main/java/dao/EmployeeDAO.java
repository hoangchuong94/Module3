package dao;
import java.sql.Connection;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/company_management?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "581549";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO company-management" + "  " +
            "(firstName, lastName, birthDate, sex, salary, superId, branchId) VALUES "
            + " (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_VALUE_SQL = "SELECT emp_id, first_name, last_name, birth_day, sex, salary FROM company_management.employee";



    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employeesList = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VALUE_SQL);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();


        while (rs.next()) {
            int id = rs.getInt("emp_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            Date birthDate = rs.getDate("birth_day");
            String sex = rs.getString("sex");
            int salary = rs.getInt("salary");

            employeesList.add((new Employee(id, firstName,lastName ,birthDate, sex, salary)));
        }
        return employeesList;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public Employee finById(int id) {
        return null;
    }

    @Override
    public void update(int id, Employee employee) {

    }

    @Override
    public void remove(int id) {

    }
}
