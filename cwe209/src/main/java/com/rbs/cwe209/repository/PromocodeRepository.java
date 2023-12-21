package com.rbs.cwe209.repository;

import com.rbs.cwe209.config.DatabaseAuthenticationProvider;
import com.rbs.cwe209.model.Promocode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class PromocodeRepository {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseAuthenticationProvider.class);
    private final DataSource dataSource;


    public PromocodeRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Promocode createPromocode(ResultSet rs) throws SQLException {
        int numColumns = rs.getMetaData().getColumnCount();
        Long id = 0L;
        String name = "";
        int discount = 0;
        while (rs.next()) {
            id = rs.getLong("id");
            name = rs.getString("name");
            discount = rs.getInt("discount");
        }
        Promocode retPromo = null;
        if(id!= 0){
            retPromo = new Promocode(id, name, discount);
        }
        return retPromo;
    }

    public Promocode findPromocode(String name) {
        String test = "SELECT * FROM promocodes WHERE name='" + name + "'";
        String query = "SELECT * FROM promocodes WHERE name ='" + name + "'";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            return createPromocode(rs);

        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());

            LOG.error(e.getSQLState());
            System.out.println("ULAZI");
        }
        return null;
    }

}