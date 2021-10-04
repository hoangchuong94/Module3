package dao.product;

import dao.connection.ConnectionJdbc;
import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    private final ConnectionJdbc connection = new ConnectionJdbc();
    private final String SELECT_ALL_PRODUCT = "SELECT * FROM product;";
    private final String SELECT_CATEGORY_ID = "SELECT (name) FROM category WHERE id = ? ;";


    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        connection.getConnectionJDBC();

        PreparedStatement preparedStatement = connection.getConnectionJDBC().prepareStatement(SELECT_ALL_PRODUCT);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();


        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            String color = rs.getString("color");
            String description = rs.getString("description");
            int categoryId = rs.getInt("categoryId");
            products.add((new Product(id, name,price ,quantity, color, description, categoryId)));
        }
        return products;

    }

    @Override
    public Category findCategoryId(int id) throws SQLException {

        Category category = null;
        PreparedStatement preparedStatement = connection.getConnectionJDBC().prepareStatement(SELECT_CATEGORY_ID);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int idC = resultSet.getInt("id");
            String name = resultSet.getString("name");

            category = new Category(idC, name);
            return category;

        }
        return null;
    }

    @Override
    public void insert(Product product) throws SQLException {
        String ADD_PRODUCT ="insert into product(name, price, quantity, color, description, categoryId) values (?, ?, ?, ?, ?,?)";
        connection.getConnectionJDBC();
        PreparedStatement preparedStatement = connection.getConnectionJDBC().prepareStatement(ADD_PRODUCT);
        preparedStatement.setString(1,product.getName());
        preparedStatement.setDouble(2,product.getPrice());
        preparedStatement.setInt(3,product.getQuantity());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setString(5,product.getDescription());
        preparedStatement.setInt(6,product.getCategoryId());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean update(int id, Product product) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
