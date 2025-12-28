package com.vvp.dao;

import com.vvp.context.DBContext;
import com.vvp.model.User;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Đăng ký: Nhận thêm tham số fullName
    public void signup(String user, String pass, String fullName, String email) {
        String query = "INSERT INTO Users(Username, PasswordHash, FullName, Email, Role) VALUES(?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, BCrypt.hashpw(pass, BCrypt.gensalt(12)));
            ps.setString(3, fullName); // Lưu FullName (có thể là tiếng Việt có dấu)
            ps.setString(4, email);
            ps.setString(5, "User");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User login(String user, String pass) {
        String query = "SELECT * FROM Users WHERE Username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (BCrypt.checkpw(pass, rs.getString("PasswordHash"))) {
                    return new User(
                            rs.getInt("UserID"),
                            rs.getString("Username"),
                            rs.getString("PasswordHash"),
                            rs.getString("FullName"), // Lấy FullName từ DB
                            rs.getString("Email"),
                            rs.getString("Role")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User checkUserExist(String user) {
        String query = "SELECT * FROM Users WHERE Username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("PasswordHash"),
                        rs.getString("FullName"), // Lấy FullName
                        rs.getString("Email"),
                        rs.getString("Role")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}