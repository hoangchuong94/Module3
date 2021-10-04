package dao;

import model.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDAO {
    List<Employee> findAll () throws SQLException;

    void save(Employee employee);

    Employee finById(int id);

    void update(int id, Employee employee);

    void remove(int id);

}
