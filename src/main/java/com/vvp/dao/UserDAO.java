package com.vvp.dao;

import com.vvp.context.DBContext;
import com.vvp.model.User;
import com.vvp.model.UserAddress;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // 1. ĐĂNG NHẬP (Sửa lại tên bảng và tên cột)
    public User login(String user, String pass) {
        // Dùng bảng Users, cột Username
        String query = "SELECT * FROM Users WHERE Username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Lấy mật khẩu mã hóa từ cột PasswordHash
                String dbPass = rs.getString("PasswordHash");

                // So sánh mật khẩu (Dùng BCrypt)
                if (BCrypt.checkpw(pass, dbPass)) {
                    User u = new User();
                    u.setId(rs.getInt("UserID")); // Khớp UserID
                    u.setUsername(rs.getString("Username")); // Khớp Username
                    u.setPassword(rs.getString("PasswordHash"));
                    u.setFullName(rs.getString("FullName"));
                    u.setEmail(rs.getString("Email"));

                    // Cột Role (String) thay vì isAdmin (int)
                    u.setRole(rs.getString("Role"));

                    // Lấy thêm thông tin mới
                    u.setPhone(rs.getString("Phone"));
                    u.setGender(rs.getString("Gender"));
                    u.setAddress(rs.getString("Address"));

                    return u;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Giữ nguyên hàm signup cũ của bạn
    public void signup(String user, String pass, String fullName, String email) {
        String query = "INSERT INTO Users(Username, PasswordHash, FullName, Email, Role) VALUES(?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, BCrypt.hashpw(pass, BCrypt.gensalt(12)));
            ps.setString(3, fullName);
            ps.setString(4, email);
            ps.setString(5, "User");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Giữ nguyên checkUserExist
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
                        rs.getString("FullName"),
                        rs.getString("Email"),
                        rs.getString("Role")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 2. CẬP NHẬT HỒ SƠ (Sửa lại tên bảng Users)
    // SỬA LẠI: Dùng đúng bảng 'Users' và cột 'UserID'
    public void updateAccountProfile(User a) {
        // 1. Câu lệnh SQL phải trỏ vào bảng Users
        String query = "UPDATE Users SET Email=?, FullName=?, Phone=?, Gender=?, Address=? WHERE UserID=?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            // 2. Gán dữ liệu
            ps.setString(1, a.getEmail());
            ps.setString(2, a.getFullName()); // Đảm bảo hỗ trợ tiếng Việt
            ps.setString(3, a.getPhone());
            ps.setString(4, a.getGender());
            ps.setString(5, a.getAddress());
            ps.setInt(6, a.getId()); // Điều kiện WHERE UserID = ...

            // 3. Thực thi và kiểm tra
            int rowCount = ps.executeUpdate();

            // In ra console để kiểm tra xem có dòng nào được update không
            if (rowCount > 0) {
                System.out.println("Update thành công cho UserID: " + a.getId());
            } else {
                System.out.println("Update THẤT BẠI. Không tìm thấy UserID: " + a.getId());
            }

        } catch (Exception e) {
            System.out.println("LỖI UPDATE SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<UserAddress> getAddresses(int userId) {
        List<UserAddress> listAddress = new ArrayList<>();
        // Lấy hết các cột, bao gồm cả City
        String query = "SELECT * FROM Addresses WHERE UserID = ? ORDER BY IsDefault DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                listAddress.add(new UserAddress(
                        rs.getInt("AddressID"),
                        rs.getInt("UserID"),
                        rs.getString("ReceiverName"), // Cột ReceiverName
                        rs.getString("Phone"),        // Cột Phone
                        rs.getString("Street"),       // Cột Street
                        rs.getString("City"),         // Cột City (Lấy luôn cho đủ, dù Null cũng ko sao)
                        rs.getBoolean("IsDefault")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAddress;
    }

    // 2. THÊM ĐỊA CHỈ MỚI (Sửa tên bảng và cột)
    public void addAddress(int userId, String name, String phone, String address) {
        // Lưu ý: Lưu địa chỉ vào cột 'Street'
        String query = "INSERT INTO Addresses (UserID, ReceiverName, Phone, Street, IsDefault) VALUES (?,?,?,?,0)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, address); // Gán địa chỉ vào cột Street
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 1. XÓA ĐỊA CHỈ
    public void deleteAddress(int addressId) {
        String query = "DELETE FROM Addresses WHERE AddressID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, addressId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. CẬP NHẬT ĐỊA CHỈ
    public void updateUserAddress(int addressId, String name, String phone, String street) {
        String query = "UPDATE Addresses SET ReceiverName=?, Phone=?, Street=? WHERE AddressID=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, street);
            ps.setInt(4, addressId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}