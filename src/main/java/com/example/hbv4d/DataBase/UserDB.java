package com.example.hbv4d.DataBase;

import com.example.hbv4d.vinnsla.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {

    private final static String tableName = "Users";
    private static User resultMapper(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phoneNumber")
        );
    }

    public static User getUser(String username) {
        Connection conn = Database.connect();
        if (conn == null) {
            System.out.println("Database connection is null! Cannot fetch user.");
            return null;
        }

        try {
            String sql = "SELECT * FROM " + tableName + " WHERE name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return resultMapper(rs);
            }
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e.getMessage());
        }
        return null;
    }



}
