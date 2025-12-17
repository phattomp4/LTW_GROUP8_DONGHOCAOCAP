package com.vvp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=WebBanDongHo;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa"; // Hoặc tài khoản SQL khác
    private static final String PASS = "123";

    // 2. Phương thức trả về đối tượng Connection
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Đăng ký JDBC Driver (Không bắt buộc từ JDBC 4.0 trở đi nhưng nên làm)
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Lấy kết nối
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            if (connection != null) {
                System.out.println("Kết nối CSDL thành công!");
            }

        } catch (SQLException e) {
            System.err.println("Lỗi kết nối CSDL:");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    // Phương thức ví dụ để đóng kết nối
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
