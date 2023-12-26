package com.rbs.cwe209.repository;

import com.rbs.cwe209.model.Question;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;

public class QuestionRepository {
    private final DataSource dataSource;

    @Autowired
    public QuestionRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /* public int insert(String email,String question){
         String query = "INSERT INTO questions (email,question) VALUES ('"+email+"','"+question+"');";
         try (Connection connection = dataSource.getConnection();
              Statement statement = connection.createStatement();
              ResultSet rs = statement.executeQuery(query)) {
             if(rs.next()){
                rs.
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return null;
     }*/
    String url = "jdbc:h2:mem:cwe209"; // Change this URL according to your database configuration
    String user = "sa";
    String password = "password";

    public String insert(String email, String question) {
        String message = "";
        String query = "INSERT INTO questions (email, question) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {


            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email); // Assuming email is a variable holding the email value
                preparedStatement.setString(2, question); // Assuming question is a variable holding the question value

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    message = "Data inserted successfully!";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
            message = e.getMessage() + " QUERY: " + query;

        }
        return message;
    }
}
