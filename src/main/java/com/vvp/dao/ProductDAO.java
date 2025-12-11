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

    public List<Product> getNewArrivals() {
        List<Product> list = new ArrayList<>();
        // Lấy 8 sản phẩm mới nhất
        String query = "SELECT * FROM Products ORDER BY CreatedAt DESC LIMIT 8";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("ProductID"),
                        rs.getInt("BrandID"),
                        rs.getString("Name"),
                        rs.getString("SKU"),
                        rs.getDouble("OriginalPrice"),
                        rs.getDouble("CurrentPrice"),
                        rs.getString("ImageURL"),
                        rs.getInt("SoldQuantity")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}