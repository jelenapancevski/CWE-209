package com.rbs.cwe209.repository;
import com.rbs.cwe209.model.Product;
import com.rbs.cwe209.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    private User createUser(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        String username = rs.getString(2);
        String password = rs.getString(3);
        String usertype = rs.getString(4);
        String firstname = rs.getString(5);
        String lastname = rs.getString(6);
        String address = rs.getString(7);
        return new User(id, username,password,usertype,firstname,lastname,address);
    }
    public User findUser(String username){
        String query = "SELECT * FROM users WHERE username='"+username+"'";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            if(rs.next()){
                return  createUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getUsers() {
        List<User>users = new ArrayList<>();
        String query = "SELECT * FROM users WHERE usertype='user'";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

           while(rs.next()){
               users.add(createUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}