package controller;

import dao.CustomerDAO;
import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {

    CustomerDAO customerDAO = new CustomerDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null){
            action = "";
        }

        switch (action) {
            case "create" :
                showNewForm(request,response);
                break;
            case "edit":
                try {
                    showEdit(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "remove":
                try {
                    removeCustomer(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "send":
                try {
                    showSendMoney(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "withdraw":
                showWithdraw(request,response);
                break;
            case "transfer":
                showTransfer(request,response);
                break;
            default:
                listCustomer(request,response);
                break;

        }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null){
            action = "";
        }

        switch (action) {
            case "create" :
                try {
                    insertCustomer(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editCustomer(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "send":
                try {
                    sendMoneyCustomer(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "withdraw":
                try {
                    withdrawCustomer(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                listCustomer(request,response);
                break;

        }
    }



    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showEdit (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerDAO.selectCustomer(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer",customer);
        requestDispatcher.forward(request,response);
    }

    private void showSendMoney(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/sendMoney.jsp");
        requestDispatcher.forward(request,response);

    }

    private void showWithdraw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/showWithdraw.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showTransfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerDAO.selectCustomer(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/transfer.jsp");
        request.setAttribute("customer",customer);
        requestDispatcher.forward(request,response);
    }


    private void removeCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerDAO.remove(id);
        listCustomer(request,response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<Customer> customerList = customerDAO.selectAllCustomer();
            request.setAttribute("customerList", customerList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
            requestDispatcher.forward(request,response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        Customer customer = new Customer(fullName, phoneNumber, email);
        customerDAO.insert(customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("message", "New customer was created");
        requestDispatcher.forward(request,response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("fullName");
        String phone = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        double balance = Double.parseDouble(request.getParameter("balance"));
        Customer customer = new Customer(id, name, phone, email, balance);
        customerDAO.edit(customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("message","success");
        requestDispatcher.forward(request,response);
    }

    private void sendMoneyCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        double sendMoney = Double.parseDouble(request.getParameter("sendMoney"));
        if(sendMoney > 0){
            customerDAO.sendMoney(id, sendMoney);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/sendMoney.jsp");
            request.setAttribute("message", "success");
            requestDispatcher.forward(request,response);
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/sendMoney.jsp");
            request.setAttribute("no message", "no success");
            requestDispatcher.forward(request,response);
        }
    }

    private void withdrawCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        double money = Double.parseDouble(request.getParameter("showWithdraw"));
        if(money > customerDAO.selectCustomer(id).getBalance() && money > 0 ){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/showWithdraw.jsp");
            request.setAttribute("no message", "no success");
            requestDispatcher.forward(request, response);
        }else {
            try{
                customerDAO.getConnectionJDBC().setAutoCommit(false);
                customerDAO.withdraw(id,money);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/showWithdraw.jsp");
                request.setAttribute("message", "success");
                requestDispatcher.forward(request, response);
                customerDAO.getConnectionJDBC().commit();
            }catch (SQLException e){
                System.out.println(e.getMessage());
                customerDAO.getConnectionJDBC().rollback();
            }

        }


    }







}
