package com.vvp.dao;

import com.vvp.context.DBContext;
import com.vvp.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Hàm hỗ trợ map dữ liệu từ ResultSet sang Object (để đỡ viết lại nhiều lần)
    private Product mapResultSetToProduct(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("ProductID"),
                rs.getInt("BrandID"),
                rs.getString("Name"),
                rs.getString("SKU"),
                rs.getString("Description"),
                rs.getDouble("OriginalPrice"),
                rs.getDouble("CurrentPrice"),
                rs.getString("ImageURL"),
                rs.getInt("StockQuantity"),
                rs.getInt("SoldQuantity"),
                rs.getBoolean("IsLuxury")
        );
    }

    public List<Product> getFeaturedProducts() {
        List<Product> list = new ArrayList<>();

        String query = "SELECT * FROM Products ORDER BY CreatedAt DESC";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getMenProducts() {
        List<Product> list = new ArrayList<>();
        // Dùng LIKE '%Nam%' để tìm sản phẩm có chứa chữ Nam
        String query = "SELECT * FROM Products WHERE Name LIKE '%Nam%' ORDER BY CreatedAt DESC";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. Hàm lấy Đồng hồ Nữ (Tìm theo tên có chữ "Nữ")
    public List<Product> getWomenProducts() {
        List<Product> list = new ArrayList<>();
        // Dùng LIKE '%Nữ%' để tìm.
        // Lưu ý: Nếu Database lỗi font, hãy thử N'%Nữ%' (cho SQL Server) hoặc đảm bảo URL kết nối có useUnicode=true
        String query = "SELECT * FROM Products WHERE Name LIKE '%Nữ%' ORDER BY CreatedAt DESC";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<Product> getLuxuryProducts() {
        List<Product> list = new ArrayList<>();
        // Chỉ lấy sản phẩm có IsLuxury = 1
        String query = "SELECT * FROM Products WHERE IsLuxury = 1 ORDER BY CreatedAt DESC";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // 2. LẤY SẢN PHẨM LUXURY
    public List<Product> getLuxuryProducts1() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Products WHERE IsLuxury = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapProduct(rs));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }


    // CẬP NHẬT HÀM getProductById (Quan trọng nhất)
    // Hàm này sẽ gọi 2 hàm trên để nạp dữ liệu đầy đủ cho Product
    public Product getProductById(int id) {
        String query = "SELECT * FROM Products WHERE ProductID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Product p = mapResultSetToProduct(rs);

                // --- ĐÂY LÀ PHẦN MỚI THÊM VÀO ---
                // Tự động lấy thêm ảnh và thông số nạp vào object p
                p.setImageList(getProductImages(id));
                p.setSpecifications(getProductSpecs(id));

                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // 1. Tìm sản phẩm theo khoảng giá (min - max)
    public List<Product> getProductsByPriceRange(double min, double max) {
        List<Product> list = new ArrayList<>();
        // Nếu max = -1 tức là tìm các sản phẩm giá > min (không giới hạn trần)
        String query;
        if (max == -1) {
            query = "SELECT * FROM Products WHERE CurrentPrice >= ?";
        } else {
            query = "SELECT * FROM Products WHERE CurrentPrice BETWEEN ? AND ?";
        }

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setDouble(1, min);
            if (max != -1) {
                ps.setDouble(2, max);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    // 1. Hàm lấy danh sách ảnh (Giả sử cột là ImageURL)
    public List<String> getProductImages(int productId) {
        List<String> list = new ArrayList<>();
        // Lưu ý: Sửa tên cột 'ImageURL' nếu trong DB bạn đặt tên khác
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

    // 2. Hàm lấy thông số kỹ thuật (Giả sử cột là SpecName và SpecValue)
    public Map<String, String> getProductSpecs(int productId) {
        Map<String, String> specs = new HashMap<>();
        // Lưu ý: Sửa tên cột 'SpecName', 'SpecValue' nếu DB bạn đặt khác
        String query = "SELECT SpecName, SpecValue FROM ProductSpecifications WHERE ProductID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                specs.put(rs.getString("SpecName"), rs.getString("SpecValue"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return specs;
    }

    public List<Product> searchProducts(String keyword) {
        List<Product> list = new ArrayList<>();
        // Tìm kiếm tương đối (LIKE) trong tên hoặc mô tả
        String query = "SELECT * FROM Products WHERE Name LIKE ? OR SKU LIKE ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            String searchPattern = "%" + keyword + "%"; // Thêm % để tìm kiếm gần đúng
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 1. LẤY SẢN PHẨM THEO TÊN THƯƠNG HIỆU
    public List<Product> getProductsByBrand(String brandName) {
        List<Product> list = new ArrayList<>();
        // Join bảng Products với Brands để tìm theo tên Brand
        String query = "SELECT p.*, b.Name as BrandName FROM Products p " +
                "JOIN Brands b ON p.BrandID = b.BrandID " +
                "WHERE b.Name LIKE ? AND p.StockQuantity > 0";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + brandName + "%"); // Tìm gần đúng
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapProduct(rs)); // Giả sử bạn có hàm mapProduct để đỡ viết lại code set thuộc tính
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }


    // 3. LẤY SẢN PHẨM THEO XUẤT XỨ (Dựa vào bảng ProductSpecifications)
    public List<Product> getProductsByOrigin(String origin) {
        List<Product> list = new ArrayList<>();
        // Tìm trong bảng thông số kỹ thuật (SpecName = 'Xuất xứ' và SpecValue chứa từ khóa)
        String query = "SELECT p.* FROM Products p " +
                "JOIN ProductSpecifications ps ON p.ProductID = ps.ProductID " +
                "WHERE ps.SpecName = N'Xuất xứ' AND ps.SpecValue LIKE ? AND p.StockQuantity > 0";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + origin + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapProduct(rs));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    // Hàm phụ để map dữ liệu
    private Product mapProduct(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setId(rs.getInt("ProductID"));
        p.setName(rs.getString("Name"));
        p.setCurrentPrice(rs.getDouble("CurrentPrice"));
        p.setOriginalPrice(rs.getDouble("OriginalPrice"));
        p.setImageUrl(rs.getString("ImageURL"));
        p.setSoldQuantity(rs.getInt("SoldQuantity"));
        return p;
    }

    public void updateStock(int productId, int quantity) {
        // Dấu + ? ở đây cho phép cộng dồn (hoặc trừ đi nếu quantity là số âm)
        String query = "UPDATE products SET StockQuantity = StockQuantity + ? WHERE ProductID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, quantity); // Số lượng hoàn lại
            ps.setInt(2, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}


