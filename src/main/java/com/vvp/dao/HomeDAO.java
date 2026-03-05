package com.vvp.dao;

import com.vvp.context.DBContext;
import com.vvp.model.Banner;
import com.vvp.model.Brand;
import com.vvp.model.SmallBanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HomeDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Hàm lấy danh sách Banner nhỏ (Thương hiệu)
    public List<SmallBanner> getSmallBanners() {
        List<SmallBanner> list = new ArrayList<>();
        // Lấy tất cả banner đang hiện (IsActive=1), sắp xếp theo thứ tự (SortOrder)
        String query = "SELECT * FROM SmallBanners WHERE IsActive = 1 ORDER BY SortOrder ASC";

        try {
            // Mở kết nối Database
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                // Mapping dữ liệu từ bảng vào Object
                SmallBanner b = new SmallBanner();
                b.setId(rs.getInt("ID"));
                b.setImageUrl(rs.getString("ImageURL"));
                b.setSortOrder(rs.getInt("SortOrder"));
                b.setActive(rs.getBoolean("IsActive"));

                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối để tránh tràn bộ nhớ (Quan trọng)
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
        return list;
    }

    public List<Banner> getSlideshowBanners() {
        List<Banner> list = new ArrayList<>();
        String query = "SELECT * FROM banners WHERE IsActive = 1 ORDER BY SortOrder ASC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Banner b = new Banner();
                b.setId(rs.getInt("BannerID")); // Lưu ý: Tên cột trong DB của bạn là BannerID
                b.setImageUrl(rs.getString("ImageURL"));
                b.setSortOrder(rs.getInt("SortOrder"));
                b.setActive(rs.getBoolean("IsActive"));
                list.add(b);
            }
        } catch (Exception e) { e.printStackTrace(); }

        return list;
    }


    public List<Brand> getFeaturedBrands() {
        List<Brand> list = new ArrayList<>();

        String query = "SELECT * FROM brands WHERE IsActive = 1 ORDER BY SortOrder ASC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Brand b = new Brand();
                b.setId(rs.getInt("BrandID"));
                b.setName(rs.getString("Name"));
                b.setLogoUrl(rs.getString("LogoURL"));
                b.setSortOrder(rs.getInt("SortOrder"));
                b.setActive(rs.getBoolean("IsActive"));
                list.add(b);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}