package com.example.hbv4d.vinnsla;

import com.example.hbv4d.utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDAO {
    private static final String tableName = "Bookings";

    private static Booking resultMapper(ResultSet rs) throws SQLException {
        return new Booking(
                rs.getInt("tourId"),
                rs.getInt("userId"),
                rs.getString("firstName"),
                rs.getString("email")
        );
    }

    public static ArrayList<Booking> listBookingsForUser(int userId) {
        try (Connection conn = Database.connect()) {
            String sql = "SELECT * FROM Bookings WHERE userId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Booking> bookings = new ArrayList<>();
            while (rs.next()) {
                bookings.add(resultMapper(rs));
            }

            return bookings;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void addBooking(int tourId, int userId, String firstName, String email) {
        try (Connection conn = Database.connect()) {
            String sql = "INSERT INTO Bookings (tourId, userId, firstName, email ) VALUES (?,  ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, tourId);
            pstmt.setInt(2, userId);
            pstmt.setString(3, firstName);
            pstmt.setString(4, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
