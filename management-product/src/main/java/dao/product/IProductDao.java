package dao.product;

import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDao {
    List<Product> findAll() throws SQLException;

    Category findCategoryId (int id) throws SQLException;
    void insert(Product product) throws SQLException;

    void save(Product product);

    Product findById(int id);

    boolean update(int id, Product product);

    boolean remove(int id);
}
