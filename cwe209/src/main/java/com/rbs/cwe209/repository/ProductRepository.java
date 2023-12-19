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
        Array ingredientsArray = rs.getArray(2);
        List<String> ingredients = new ArrayList<>();
        if (ingredientsArray != null) {
            Object[] ingredientObjects = (Object[]) ingredientsArray.getArray();
            for (Object ingredientObject : ingredientObjects) {
                if (ingredientObject instanceof String) {
                    ingredients.add((String) ingredientObject);
                }
            }
        }
        String name = rs.getString(3);
        String description = rs.getString(4);
        String producttype = rs.getString(5);
        int price = rs.getInt(6);
        String image = rs.getString(7);
        return new Product(id, ingredients,name,description,producttype,price,image);
    }


    public Product getProduct(Long id) {
        String sqlQuery = "SELECT * FROM " + table+" WHERE id="+id;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sqlQuery)) {
            while (rs.next()) {
                return (createProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getProductsWithIngredient(String ingredient) {
        List<String> productNames = new ArrayList<>();
        String sqlQuery = "SELECT name FROM products where ingredients LIKE '%" + ingredient+"%'";
        System.out.println(sqlQuery);
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sqlQuery)) {
            while (rs.next()) {
                productNames.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  productNames;
    }

}