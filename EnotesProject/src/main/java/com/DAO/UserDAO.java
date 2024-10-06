package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.User.UserDetails;

public class UserDAO {
    
    private Connection conn;

    public UserDAO(Connection connection) {
        this.conn = connection;
    }

    // Method to add a new user
    public boolean addUser(UserDetails us) {
        boolean f = false;
        try {
            String query = "INSERT INTO user(name, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, us.getNameString());
            ps.setString(2, us.getEmailString());
            ps.setString(3, us.getPassword());
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    
    // Method to validate user login
    public UserDetails loginUser(UserDetails us) {
       UserDetails user = null;
        try {
            String query = "SELECT * FROM user WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, us.getEmailString());
            ps.setString(2, us.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               user = new UserDetails();
               user.setId(rs.getInt("id"));
               user.setNameString(rs.getString("name"));
               user.setEmailString(rs.getString("email"));
               user.setPassword("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
