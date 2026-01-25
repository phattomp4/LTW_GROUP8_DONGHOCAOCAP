package com.vvp.dao;

import com.vvp.context.DBContext;
import com.vvp.model.ShopInfo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // 1. LẤY THÔNG TIN SHOP (Cho trang Home và Admin form)
    public ShopInfo getShopInfo() {
        String query = "SELECT * FROM ShopInfo WHERE ID = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                ShopInfo info = new ShopInfo();

                // --- Thông tin Giới thiệu ---
                info.setBrandName(rs.getString("BrandName"));
                info.setSubtitle(rs.getString("Subtitle"));
                info.setMainImageUrl(rs.getString("MainImageURL"));
                info.setHistory1(rs.getString("History1"));
                info.setHistory2(rs.getString("History2"));
                info.setHistory3(rs.getString("History3"));

                // --- Thông tin Footer (MỚI) ---
                info.setFooterDesc(rs.getString("FooterDesc"));
                info.setAddress(rs.getString("Address"));
                info.setHotline(rs.getString("Hotline"));
                info.setEmail(rs.getString("Email"));
                info.setCopyright(rs.getString("Copyright"));

                return info;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    // 2. LẤY DANH SÁCH ẢNH GALLERY
    public List<String> getShopGallery() {
        List<String> list = new ArrayList<>();
        String query = "SELECT ImageURL FROM ShopGallery";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("ImageURL"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    // 3. CẬP NHẬT THÔNG TIN SHOP (Dùng cho Admin)
    public void updateShopInfo(ShopInfo info) {
        // Cập nhật đủ cả phần Giới thiệu lẫn Footer
        String query = "UPDATE ShopInfo SET BrandName=?, Subtitle=?, MainImageURL=?, History1=?, History2=?, History3=?, "
                + "FooterDesc=?, Address=?, Hotline=?, Email=?, Copyright=?, FacebookURL=?, InstagramURL=?, YoutubeURL=? "
                + "WHERE ID=1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            // Set thông tin giới thiệu
            ps.setString(1, info.getBrandName());
            ps.setString(2, info.getSubtitle());
            ps.setString(3, info.getMainImageUrl());
            ps.setString(4, info.getHistory1());
            ps.setString(5, info.getHistory2());
            ps.setString(6, info.getHistory3());

            // Set thông tin Footer (MỚI)
            ps.setString(7, info.getFooterDesc());
            ps.setString(8, info.getAddress());
            ps.setString(9, info.getHotline());
            ps.setString(10, info.getEmail());
            ps.setString(11, info.getCopyright());

            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}