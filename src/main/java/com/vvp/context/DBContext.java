package com.vvp.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
<<<<<<< HEAD
    public Connection getConnection() throws Exception {
        // Thay đổi user/pass cho đúng với MySQL của bạn
        String url = "jdbc:mysql://localhost:3306/DongHoCaoCap";
        String user = "root";
        String pass = "Totanphat56po";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
=======
    private static final String DB_URL = "jdbc:mysql://localhost:3306/DongHoCaoCap";
    private static final String USER = "root"; // Hoặc tài khoản SQL khác
    private static final String PASS = "";

    // 2. Phương thức trả về đối tượng Connection
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Đăng ký JDBC Driver (Không bắt buộc từ JDBC 4.0 trở đi nhưng nên làm)
            Class.forName("com.mysql.cj.jdbc.Driver");

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
>>>>>>> 41f1e75957f2397df758542c5af00debc2273b42
    }

    // Chạy thử hàm main này để xem kết nối được chưa
    public static void main(String[] args) {
        try {
            System.out.println(new DBContext().getConnection());
            System.out.println("Kết nối thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
}
}
