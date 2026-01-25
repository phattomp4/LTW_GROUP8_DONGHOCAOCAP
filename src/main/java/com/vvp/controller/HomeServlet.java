package com.vvp.controller;

import com.vvp.dao.HomeDAO;
import com.vvp.dao.ProductDAO;
import com.vvp.dao.ShopDAO;
import com.vvp.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; // Đừng quên import cái này
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDao = new ProductDAO();
        HomeDAO homeDao = new HomeDAO();
        ShopDAO shopDao = new ShopDAO();

        // --- 1. XỬ LÝ THÔNG TIN SHOP (HEADER & FOOTER) ---
        // Sử dụng Session để lưu thông tin chung (dùng cho toàn bộ website)
        HttpSession session = request.getSession();

        // Kiểm tra nếu trong session chưa có thông tin shop thì mới gọi Database
        // (Giúp tối ưu tốc độ, không phải gọi DB mỗi lần load lại trang)
        if (session.getAttribute("shopInfo") == null) {
            ShopInfo info = shopDao.getShopInfo();
            session.setAttribute("shopInfo", info);

            // Lấy ảnh Gallery (Dùng cho cả Slider trang chủ và Footer Instagram)
            List<String> gallery = shopDao.getShopGallery();
            session.setAttribute("shopGallery", gallery);
        }

        // --- 2. LẤY DỮ LIỆU SẢN PHẨM & BANNER (CHO RIÊNG TRANG CHỦ) ---
        List<Product> listFeatured = productDao.getFeaturedProducts();
        List<Product> listMen = productDao.getMenProducts();
        List<Product> listWomen = productDao.getWomenProducts();
        List<Product> listLuxury = productDao.getLuxuryProducts();

        List<SmallBanner> listSmallBanners = homeDao.getSmallBanners();
        List<Banner> listSlideshow = homeDao.getSlideshowBanners();
        List<Brand> listBrands = homeDao.getFeaturedBrands();

        // Gửi dữ liệu sang JSP
        request.setAttribute("listFeatured", listFeatured);
        request.setAttribute("listMen", listMen);
        request.setAttribute("listWomen", listWomen);
        request.setAttribute("listLuxury", listLuxury);

        request.setAttribute("listSmallBanners", listSmallBanners);
        request.setAttribute("listSlideshow", listSlideshow);
        request.setAttribute("listBrands", listBrands);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}