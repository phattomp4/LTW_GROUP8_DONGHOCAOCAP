package com.vvp.dao;

import com.vvp.context.DBContext;
import com.vvp.model.Account;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
public class AccountDAO{
// Đăng nhập
    public Account findUserByUsername(String username) {
       String sql = "SELECT USERNAME, PASSWORD, ROLE FROM USERS WHERE USERNAME = ?";
       Account acc = null;

        try(Connection conn = DBContext.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1, username);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    String dbUsername = resultSet.getString("USERNAME");
                    String dbPassword = resultSet.getString("PASSWORD");
                    String dbRole = resultSet.getString("ROLE");

                    acc = new Account(dbUsername, dbPassword, dbRole);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Lỗi truy vấn CSDL khi tìm kiếm người dùng!");
        }
        return acc;
    }

    // Đăng ký
    public boolean isUsernameExists(String username) {
        String sql = "SELECT COUNT(Username) FROM Accounts WHERE Username = ?";

        // 🔥 Lấy 'conn' tại đây, sử dụng try-with-resources để tự động đóng Connection
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi CSDL (ví dụ: lỗi kết nối)
        }
        return false;
    }
    public boolean saveAccount(Account acc) {
        String sql = "INSERT INTO USERS (Username, Password, Role) VALUES (?, ?, 'USER')";

        // 🔥 Lấy 'conn' tại đây
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi CSDL
        }
        return false;
    }

    public boolean forgotPassword(String newPassword, String email) {
        String sql = "UPDATE USERS SET PASSWORD = ? WHERE EMAIL = ?";

        // 🔥 Lấy 'conn' tại đây
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newPassword);
            ps.setString(2, email);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Lỗi khi cập nhật mật khẩu mới!");
        }
        return false;
    }
}
