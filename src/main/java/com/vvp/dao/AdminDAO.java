package com.vvp.dao;

import com.vvp.context.DBContext;
import com.vvp.model.Order;
import com.vvp.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class AdminDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // 1. THỐNG KÊ DOANH THU (Chỉ tính đơn đã hoàn thành hoặc đang giao)
    public double getTotalRevenue() {
        // Chỉ tính tiền các đơn không bị Hủy
        String query = "SELECT SUM(TotalAmount) FROM Orders WHERE Status != 'Cancelled'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) return rs.getDouble(1);
        } catch (Exception e) { e.printStackTrace(); }
        return 0;
    }

    // 2. ĐẾM TỔNG SỐ ĐƠN HÀNG
    public int countOrders() {
        String query = "SELECT COUNT(*) FROM Orders";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        return 0;
    }

    // 3. ĐẾM TỔNG SỐ KHÁCH HÀNG
    public int countUsers() {
        String query = "SELECT COUNT(*) FROM Users WHERE Role != 'Admin'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        return 0;
    }

    // 4. LẤY TẤT CẢ ĐƠN HÀNG (Mới nhất lên đầu)
    public List<Order> getAllOrders() {
        List<Order> list = new ArrayList<>();
        String query = "SELECT * FROM Orders ORDER BY OrderDate DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderId(rs.getInt("OrderID"));
                o.setUserId(rs.getInt("UserID"));
                o.setOrderDate(rs.getTimestamp("OrderDate"));
                o.setTotalAmount(rs.getDouble("TotalAmount"));
                o.setStatus(rs.getString("Status"));
                o.setPaymentMethod(rs.getString("PaymentMethod"));
                list.add(o);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    // 5. CẬP NHẬT TRẠNG THÁI ĐƠN HÀNG
    public void updateOrderStatus(int orderId, String status) {
        String query = "UPDATE Orders SET Status = ? WHERE OrderID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    // 9. THÊM SẢN PHẨM MỚI (Trả về ID vừa tạo)
    public void insertProduct(com.vvp.model.Product p, String imagePath) {
        String sqlProduct = "INSERT INTO Products (ProductName, SKU, Description, OriginalPrice, CurrentPrice, StockQuantity, SoldQuantity, BrandID, CategoryID) VALUES (?, ?, ?, ?, ?, ?, 0, 1, 1)";
        // Lưu ý: BrandID và CategoryID tôi đang để cứng là 1, bạn có thể tạo combobox để chọn sau.

        try {
            conn = new DBContext().getConnection();
            conn.setAutoCommit(false); // Bắt đầu Transaction

            // 1. Insert bảng Products
            ps = conn.prepareStatement(sqlProduct, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getName());
            ps.setString(2, p.getSku());
            ps.setString(3, p.getDescription());
            ps.setDouble(4, p.getOriginalPrice());
            ps.setDouble(5, p.getCurrentPrice());
            ps.setInt(6, p.getStockQuantity());
            ps.executeUpdate();

            // Lấy ID vừa sinh ra
            rs = ps.getGeneratedKeys();
            int productId = 0;
            if (rs.next()) productId = rs.getInt(1);

            // 2. Insert bảng ProductImages (Nếu có ảnh)
            if (imagePath != null && !imagePath.isEmpty()) {
                String sqlImg = "INSERT INTO ProductImages (ProductID, ImageURL) VALUES (?, ?)";
                PreparedStatement psImg = conn.prepareStatement(sqlImg);
                psImg.setInt(1, productId);
                psImg.setString(2, imagePath);
                psImg.executeUpdate();
            }

            conn.commit(); // Lưu tất cả
        } catch (Exception e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) {}
            e.printStackTrace();
        }
    }

    // 10. CẬP NHẬT SẢN PHẨM
    public void updateProduct(com.vvp.model.Product p, String newImagePath) {
        String sql = "UPDATE Products SET ProductName=?, SKU=?, Description=?, OriginalPrice=?, CurrentPrice=?, StockQuantity=? WHERE ProductID=?";
        try {
            conn = new DBContext().getConnection();
            conn.setAutoCommit(false);

            // 1. Update thông tin cơ bản
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getSku());
            ps.setString(3, p.getDescription());
            ps.setDouble(4, p.getOriginalPrice());
            ps.setDouble(5, p.getCurrentPrice());
            ps.setInt(6, p.getStockQuantity());
            ps.setInt(7, p.getId());
            ps.executeUpdate();

            // 2. Update ảnh (Nếu user có chọn ảnh mới)
            if (newImagePath != null && !newImagePath.isEmpty()) {
                // Xóa ảnh cũ (hoặc update đè) - Ở đây tôi làm cách đơn giản là xóa hết ảnh cũ rồi thêm mới
                PreparedStatement psDel = conn.prepareStatement("DELETE FROM ProductImages WHERE ProductID=?");
                psDel.setInt(1, p.getId());
                psDel.executeUpdate();

                PreparedStatement psImg = conn.prepareStatement("INSERT INTO ProductImages (ProductID, ImageURL) VALUES (?, ?)");
                psImg.setInt(1, p.getId());
                psImg.setString(2, newImagePath);
                psImg.executeUpdate();
            }

            conn.commit();
        } catch (Exception e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) {}
            e.printStackTrace();
        }
    }

    // 11. LẤY SẢN PHẨM THEO ID (Để đổ dữ liệu vào form Sửa)
    public com.vvp.model.Product getProductById(int pid) {
        // Tận dụng lại hàm getAllProducts nhưng thêm WHERE
        // (Hoặc bạn có thể gọi ProductDAO.getProductById cũng được)
        // Để đơn giản, tôi viết nhanh query ở đây:
        String query = "SELECT p.*, (SELECT ImageURL FROM ProductImages WHERE ProductID = p.ProductID LIMIT 1) AS ImageURL FROM Products p WHERE p.ProductID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            if (rs.next()) {
                com.vvp.model.Product p = new com.vvp.model.Product();
                p.setId(rs.getInt("ProductID"));
                p.setName(rs.getString("Name"));
                p.setSku(rs.getString("SKU"));
                p.setDescription(rs.getString("Description"));
                p.setOriginalPrice(rs.getDouble("OriginalPrice"));
                p.setCurrentPrice(rs.getDouble("CurrentPrice"));
                p.setStockQuantity(rs.getInt("StockQuantity"));
                p.setImageUrl(rs.getString("ImageURL"));
                p.setLuxury(rs.getBoolean("IsLuxury"));
                return p;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    // 1. LẤY TẤT CẢ SẢN PHẨM (Kèm ảnh đại diện để hiển thị ra bảng)
    public List<com.vvp.model.Product> getAllProducts() {
        List<com.vvp.model.Product> list = new ArrayList<>();

        // Query lấy toàn bộ bảng Products
        String query = "SELECT * FROM Products ORDER BY ProductID DESC";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                com.vvp.model.Product p = new com.vvp.model.Product();
                p.setId(rs.getInt("ProductID"));

                // --- SỬA QUAN TRỌNG: Dùng "Name" thay vì "ProductName" ---
                p.setName(rs.getString("Name"));
                // --------------------------------------------------------

                p.setSku(rs.getString("SKU"));

                // Kiểm tra tên cột giá (Nếu DB là 'Price' thì sửa 'OriginalPrice' thành 'Price')
                // Ở đây tôi giữ 'OriginalPrice' theo code cũ của bạn
                p.setOriginalPrice(rs.getDouble("OriginalPrice"));
                p.setCurrentPrice(rs.getDouble("CurrentPrice"));

                p.setStockQuantity(rs.getInt("StockQuantity"));
                p.setSoldQuantity(rs.getInt("SoldQuantity"));

                // Lấy ảnh từ cột ImageURL
                String img = rs.getString("ImageURL");
                if (img == null || img.trim().isEmpty()) {
                    img = "https://via.placeholder.com/150";
                }
                p.setImageUrl(img);
                p.setLuxury(rs.getBoolean("IsLuxury"));

                list.add(p);
            }
        } catch (Exception e) {
            // In lỗi ra console để debug (Xem Output cửa sổ bên dưới nếu vẫn lỗi)
            System.out.println("Lỗi getAllProducts: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
        return list;
    }

    // 2. XÓA SẢN PHẨM (Xóa ảnh trước -> Xóa sản phẩm sau)
    public void deleteProduct(int pid) {
        try {
            conn = new DBContext().getConnection();

            // Bước 1: Xóa ảnh trong bảng ProductImages trước (vì có khóa ngoại)
            String sqlImg = "DELETE FROM ProductImages WHERE ProductID = ?";
            PreparedStatement ps1 = conn.prepareStatement(sqlImg);
            ps1.setInt(1, pid);
            ps1.executeUpdate();

            // Bước 2: Xóa sản phẩm trong bảng Products
            String sqlProd = "DELETE FROM Products WHERE ProductID = ?";
            PreparedStatement ps2 = conn.prepareStatement(sqlProd);
            ps2.setInt(1, pid);
            ps2.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {}
        }
    }

    public void insertFullProduct(com.vvp.model.Product p, List<String> detailImages, List<com.vvp.model.ProductSpecification> listSpecs) {
        // SQL: Đổi cột 'Image' thành 'ImageURL' cho khớp với Database của bạn
        String sqlProduct = "INSERT INTO Products (ProductName, SKU, Description, OriginalPrice, CurrentPrice, StockQuantity, SoldQuantity, BrandID, CategoryID, ImageURL, IsLuxury) VALUES (?, ?, ?, ?, ?, ?, 0, 1, 1, ?, ?)";

        String sqlImg = "INSERT INTO ProductImages (ProductID, ImageURL) VALUES (?, ?)";
        String sqlSpec = "INSERT INTO ProductSpecifications (ProductID, SpecName, SpecValue) VALUES (?, ?, ?)";

        try {
            conn = new DBContext().getConnection();
            conn.setAutoCommit(false); // Bắt đầu Transaction

            // 1. INSERT VÀO BẢNG PRODUCTS
            ps = conn.prepareStatement(sqlProduct, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getName());
            ps.setString(2, p.getSku());
            ps.setString(3, p.getDescription());
            ps.setDouble(4, p.getOriginalPrice());
            ps.setDouble(5, p.getCurrentPrice());
            ps.setInt(6, p.getStockQuantity());


            // Lưu đường dẫn ảnh đại diện vào cột ImageURL
            ps.setString(7, p.getImageUrl());
            ps.setBoolean(8, p.isLuxury());

            ps.executeUpdate();

            // Lấy ID vừa sinh ra
            rs = ps.getGeneratedKeys();
            int productId = 0;
            if (rs.next()) productId = rs.getInt(1);

            // 2. INSERT ẢNH CHI TIẾT (Vào bảng ProductImages)
            if (detailImages != null && !detailImages.isEmpty()) {
                PreparedStatement psImg = conn.prepareStatement(sqlImg);
                for (String imgPath : detailImages) {
                    psImg.setInt(1, productId);
                    psImg.setString(2, imgPath);
                    psImg.addBatch();
                }
                psImg.executeBatch();
            }

            // 3. INSERT 10 THÔNG SỐ (Vào bảng ProductSpecifications)
            if (listSpecs != null && !listSpecs.isEmpty()) {
                PreparedStatement psSpec = conn.prepareStatement(sqlSpec);
                for (com.vvp.model.ProductSpecification spec : listSpecs) {
                    psSpec.setInt(1, productId);
                    psSpec.setString(2, spec.getName()); // VD: Thương hiệu
                    psSpec.setString(3, spec.getValue()); // VD: Casio
                    psSpec.addBatch();
                }
                psSpec.executeBatch();
            }

            conn.commit(); // Lưu tất cả
        } catch (Exception e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) {}
            e.printStackTrace();
        } finally {
            try { if (conn != null) { conn.setAutoCommit(true); conn.close(); } } catch (SQLException e) {}
        }
    }

    // 12. LẤY DANH SÁCH ẢNH PHỤ (Trả về List đường dẫn)
    public List<String> getDetailImages(int productId) {
        List<String> list = new ArrayList<>();
        String query = "SELECT ImageURL FROM ProductImages WHERE ProductID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("ImageURL"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    // 13. LẤY THÔNG SỐ KỸ THUẬT (Trả về MAP để dễ hiển thị lên Form)
    // Key: Tên thông số (VD: "Thương hiệu"), Value: Giá trị (VD: "Casio")
    public java.util.Map<String, String> getProductSpecsMap(int productId) {
        java.util.Map<String, String> map = new java.util.HashMap<>();
        String query = "SELECT SpecName, SpecValue FROM ProductSpecifications WHERE ProductID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                map.put(rs.getString("SpecName"), rs.getString("SpecValue"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return map;
    }

    public List<com.vvp.model.Product> searchProductsByName(String keyword) {
        List<com.vvp.model.Product> list = new ArrayList<>();
        // Tìm kiếm gần đúng (LIKE) theo tên sản phẩm
        String query = "SELECT * FROM Products WHERE Name LIKE ? ORDER BY ProductID DESC";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            // Thêm dấu % vào đầu và cuối để tìm chứa chuỗi
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                com.vvp.model.Product p = new com.vvp.model.Product();
                p.setId(rs.getInt("ProductID"));
                p.setName(rs.getString("Name")); // Cột tên là Name
                p.setSku(rs.getString("SKU"));
                p.setOriginalPrice(rs.getDouble("OriginalPrice"));
                p.setCurrentPrice(rs.getDouble("CurrentPrice"));
                p.setStockQuantity(rs.getInt("StockQuantity"));
                p.setSoldQuantity(rs.getInt("SoldQuantity"));

                String img = rs.getString("ImageURL");
                if (img == null || img.trim().isEmpty()) img = "https://via.placeholder.com/150";
                p.setImageUrl(img);

                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
        return list;
    }

    // 14. LẤY TẤT CẢ KHÁCH HÀNG (Trừ Admin)
    public List<com.vvp.model.User> getAllUsers() {
        List<com.vvp.model.User> list = new ArrayList<>();

        // SQL MỚI: Lấy thêm cột DefaultStreet từ bảng addresses
        String query = "SELECT u.*, " +
                "(SELECT Street FROM addresses WHERE UserID = u.UserID AND IsDefault = 1 LIMIT 1) AS DefaultStreet " +
                "FROM Users u WHERE Role != 'Admin' ORDER BY UserID DESC";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                com.vvp.model.User u = new com.vvp.model.User();
                u.setId(rs.getInt("UserID"));
                u.setUsername(rs.getString("Username"));
                u.setFullName(rs.getString("FullName"));
                u.setEmail(rs.getString("Email"));
                u.setPhone(rs.getString("Phone"));

                // --- LẤY ĐỊA CHỈ MẶC ĐỊNH ---
                String defAddr = rs.getString("DefaultStreet");
                // Nếu khách chưa chọn mặc định, hiện thông báo
                u.setAddress(defAddr != null ? defAddr : "Chưa thiết lập");
                // -----------------------------

                list.add(u);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    // 2. CẬP NHẬT HÀM TÌM KIẾM USER (Làm tương tự)
    public List<com.vvp.model.User> searchUsers(String keyword) {
        List<com.vvp.model.User> list = new ArrayList<>();

        // SQL MỚI cho tìm kiếm
        String query = "SELECT u.*, " +
                "(SELECT Street FROM addresses WHERE UserID = u.UserID AND IsDefault = 1 LIMIT 1) AS DefaultStreet " +
                "FROM Users u " +
                "WHERE Role != 'Admin' AND (FullName LIKE ? OR Email LIKE ? OR Phone LIKE ?)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            String key = "%" + keyword + "%";
            ps.setString(1, key);
            ps.setString(2, key);
            ps.setString(3, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                com.vvp.model.User u = new com.vvp.model.User();
                u.setId(rs.getInt("UserID"));
                u.setUsername(rs.getString("Username"));
                u.setFullName(rs.getString("FullName"));
                u.setEmail(rs.getString("Email"));
                u.setPhone(rs.getString("Phone"));

                // --- LẤY ĐỊA CHỈ MẶC ĐỊNH ---
                String defAddr = rs.getString("DefaultStreet");
                u.setAddress(defAddr != null ? defAddr : "Chưa thiết lập");

                list.add(u);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}

