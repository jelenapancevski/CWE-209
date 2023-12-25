package com.rbs.cwe209.repository;

import com.rbs.cwe209.model.Product;
import com.rbs.cwe209.model.Promotion;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PromotionRepository {
    private DataSource dataSource;
    public PromotionRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Promotion> getAll() {
        List<Promotion> products = new ArrayList<>();
        String sqlQuery = "SELECT * FROM promotions";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sqlQuery)) {
            while (rs.next()) {
                products.add(createPromotion(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    private Promotion createPromotion(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        String name = rs.getString(2);
        String description = rs.getString(3);
        String image = rs.getString(4);
        return new Promotion(id, name,description,image);
    }
    public Promotion getPromotion(Long id) {
        String sqlQuery = "SELECT * FROM promotions WHERE id="+id;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sqlQuery)) {
            rs.next();
            return (createPromotion(rs));

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
}
