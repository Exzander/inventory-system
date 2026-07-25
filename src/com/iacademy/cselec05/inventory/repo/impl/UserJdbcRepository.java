package com.iacademy.cselec05.inventory.repo.impl;

import com.iacademy.cselec05.inventory.model.User;
import com.iacademy.cselec05.inventory.repo.UserRepository;
import com.iacademy.cselec05.inventory.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserJdbcRepository implements UserRepository {
    @Override
    public User findByCredentials(String username, String password) {

        String sql = "SELECT id, username, password, role FROM user WHERE username = ? AND password = ?";

        // Auto closes JDBC resources
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(rs.getString("role"));

                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
