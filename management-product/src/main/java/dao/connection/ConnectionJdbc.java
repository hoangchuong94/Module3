package dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionJdbc {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/management-product?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "581549";

    public ConnectionJdbc() {
    }

    public Connection getConnectionJDBC() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
