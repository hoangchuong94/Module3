package controller;

import dao.EmployeeDAO;
import dao.IEmployeeDAO;
import model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/admin")
public class EmployeeServlet extends HttpServlet {
    private static IEmployeeDAO iEmployeeDAO = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "edit":
                break;
            case "remove":
                break;
            case "view" :
                break;
            default:
                try {
                    listEmployee(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
        List<Employee> listEmployee = iEmployeeDAO.findAll();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/list.jsp");
        dispatcher.forward(request, response);
    }


}
