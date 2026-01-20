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


    public Product getProductById(int id) {
        String query = "SELECT * FROM Products WHERE ProductID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToProduct(rs);
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

    // 2. Tìm sản phẩm theo từ khóa (Tên, Thương hiệu, Mô tả)
    public List<Product> searchProducts(String keyword) {
        List<Product> list = new ArrayList<>();
        // Tìm kiếm tương đối trong cột Name hoặc Description
        String query = "SELECT * FROM Products WHERE Name LIKE ? OR Description LIKE ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            String searchPattern = "%" + keyword + "%";
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
    public List<Product> search(String keyword) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM products WHERE name LIKE ? OR sku LIKE ?";

       try {
           conn = new DBContext().getConnection();
           ps = conn.prepareStatement(query);
           ps.setString(1, "%" + keyword + "%");
           ps.setString(2, "%" + keyword + "%");
           ResultSet resultSet = ps.executeQuery();
           while(resultSet.next()){
               list.add(mapResultSetToProduct(rs));
           }
       }  catch (Exception e) {
           e.printStackTrace();
       }
       return list;
    }
}