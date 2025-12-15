package com.vvp.dao;

import com.vvp.context.DBContext;
import com.vvp.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                rs.getInt("SoldQuantity")
        );
    }

    public List<Product> getFeaturedProducts() {
        List<Product> list = new ArrayList<>();
        // Lấy 8 sản phẩm mới nhất
        String query = "SELECT * FROM Products ORDER BY CreatedAt DESC LIMIT 8";
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

    // 2. Tab Đồng hồ Nam: Lấy 8 sản phẩm có tên chứa chữ "Nam"
    public List<Product> getMenProducts() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Products WHERE Name LIKE ? LIMIT 8";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%Nam%"); // Tìm kiếm tương đối
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 3. Tab Đồng hồ Nữ: Lấy 8 sản phẩm có tên chứa chữ "Nữ"
    public List<Product> getWomenProducts() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Products WHERE Name LIKE ? LIMIT 8";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%Nữ%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 4. Phần Luxury: Lấy các sản phẩm giá > 15 triệu
    public List<Product> getLuxuryProducts() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Products WHERE CurrentPrice >= 15000000 ORDER BY CurrentPrice DESC LIMIT 8";
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
}