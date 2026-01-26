package com.vvp.dao;

import com.vvp.context.DBContext;
import com.vvp.model.Category; // Bạn tự tạo model Category (id, name, parentId)
import com.vvp.model.PriceRange;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // 1. LẤY DANH MỤC THEO NHÓM CHA (Dùng để hiển thị lên Menu Header)
    public List<Category> getCategoriesByParent(int parentId) {
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM categories WHERE ParentCategoryID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, parentId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(
                        rs.getInt("CategoryID"),
                        rs.getString("Name"),
                        rs.getInt("ParentCategoryID")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    // 2. LẤY TẤT CẢ DANH MỤC (Cho Admin quản lý)
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM categories ORDER BY ParentCategoryID, CategoryID";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt("CategoryID"), rs.getString("Name"), rs.getInt("ParentCategoryID")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    // 3. THÊM DANH MỤC (Admin)
    public void addCategory(String name, int parentId) {
        String query = "INSERT INTO categories (Name, ParentCategoryID) VALUES (?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, parentId);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    // 4. XÓA DANH MỤC (Admin)
    public void deleteCategory(int id) {
        String query = "DELETE FROM categories WHERE CategoryID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    // 1. LẤY DANH SÁCH KHOẢNG GIÁ
    public List<PriceRange> getAllPriceRanges() {
        List<PriceRange> list = new ArrayList<>();
        String query = "SELECT * FROM PriceRanges ORDER BY SortOrder ASC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new PriceRange(
                        rs.getInt("ID"),
                        rs.getString("Label"),
                        rs.getDouble("MinPrice"),
                        rs.getDouble("MaxPrice")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    // 2. THÊM KHOẢNG GIÁ (Cho Admin)
    public void addPriceRange(String label, double min, double max) {
        String query = "INSERT INTO PriceRanges (Label, MinPrice, MaxPrice) VALUES (?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, label);
            ps.setDouble(2, min);
            ps.setDouble(3, max);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    // 3. XÓA KHOẢNG GIÁ
    public void deletePriceRange(int id) {
        String query = "DELETE FROM PriceRanges WHERE ID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    // 4. CẬP NHẬT KHOẢNG GIÁ (MỚI)
    public void updatePriceRange(int id, String label, double min, double max) {
        String query = "UPDATE PriceRanges SET Label = ?, MinPrice = ?, MaxPrice = ? WHERE ID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, label);
            ps.setDouble(2, min);
            ps.setDouble(3, max);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    // 6. CẬP NHẬT DANH MỤC
    public void updateCategory(int id, String name, int parentId) {
        String query = "UPDATE categories SET Name = ?, ParentCategoryID = ? WHERE CategoryID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, parentId);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

}