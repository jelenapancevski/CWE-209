//package com.rbs.cwe209.repository;
//
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//@Repository
//public class CouponRepository {
//    private static final String table = "promocodes";
//    private DataSource dataSource;
//
//    public CouponRepository(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//
//    public int getCouponDiscount(String name) {
//        String sqlQuery = "SELECT discount FROM " + table + " WHERE name='" + name+"'";
//        try (Connection connection = dataSource.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet rs = statement.executeQuery(sqlQuery)) {
//            if (rs.next()) {
//                return (rs.getInt(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//}
