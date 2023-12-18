package com.rbs.cwe209.repository;
import com.rbs.cwe209.model.Product;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository  {
    private static final String table = "products";
    private DataSource dataSource;

    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sqlQuery = "SELECT * FROM " + table;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sqlQuery)) {
            while (rs.next()) {
                products.add(createProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    private Product createProduct(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        Array ingridients = rs.getArray(2);
        String name = rs.getString(3);
        String description = rs.getString(4);
        String producttype = rs.getString(5);
        int price = rs.getInt(6);
        String image = rs.getString(7);
        return new Product(id, ingridients,name,description,producttype,price,image);
    }



}