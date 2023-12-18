package com.rbs.cwe209.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class UserRepository {

    private final DataSource dataSource;

    @Autowired
    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findByUsername(String username) {
        String query = "SELECT password FROM users WHERE username='"+username+"'";
        /* WHERE username='" + username + "' AND password='" + password + "'*/
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            if(rs.next()){
              return  rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getRole(String username,String password){
        String query = "SELECT usertype FROM users WHERE username='"+username+"' and password='"+password+"'";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            if(rs.next()){
                return  rs.getString("usertype");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}