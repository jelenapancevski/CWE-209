package com.rbs.cwe209.repository;

import com.rbs.cwe209.config.DatabaseAuthenticationProvider;
import com.rbs.cwe209.model.Location;
import com.rbs.cwe209.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class LocationRepository {
    private final DataSource dataSource;

    @Autowired
    public LocationRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    private static final Logger LOG = LoggerFactory.getLogger(LocationRepository.class);
    String url = "jdbc:h2:mem:cwe209"; // Change this URL according to your database configuration
    String user = "sa";
    String password = "password";

    public List<Location> findOpen() {
       List <Location> locations = new ArrayList<>();
        String query = "select id,name,phone,address,workinghours,src,open from locations where open=true";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet rs = preparedStatement.executeQuery();
                LOG.info("Executing query: "+query);
                while (rs.next()) {
                    locations.add(createLocation(rs));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return locations;
    }

    private Location createLocation(ResultSet rs) throws SQLException{
        Long id = rs.getLong(1);
        String name = rs.getString(2);
        String phone = rs.getString(3);
        String address = rs.getString(4);
        String workinghours = rs.getString(5);
        String src = rs.getString(6);
        boolean open = rs.getBoolean(7);
        return new Location(id,name,phone,address,workinghours,src,open);
    }
}
