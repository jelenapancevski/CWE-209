package com.rbs.cwe209.repository;
import com.rbs.cwe209.model.Promocode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.*;

@Repository
public class PromocodeRepository {

    private final DataSource dataSource;

    @Autowired
    public PromocodeRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Promocode createPromocode(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        String name = rs.getString(2);
        int discount = rs.getInt(3);


        return new Promocode(id, name,discount);
    }
    public Promocode findPromocode(String name){
        String query = "SELECT * FROM promocode WHERE name='"+name+"'";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
                return  createPromocode(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}