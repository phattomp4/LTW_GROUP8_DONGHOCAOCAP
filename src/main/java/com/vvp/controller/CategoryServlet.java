package com.vvp.controller;

import com.vvp.dao.ProductDAO;
import com.vvp.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = {"/category"})
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        List<Product> list = null;
        String title = "Danh sách sản phẩm";

        String type = request.getParameter("type");

        // 1. TÌM THEO GIÁ
        if ("price".equals(type)) {
            double min = Double.parseDouble(request.getParameter("min"));
            double max = Double.parseDouble(request.getParameter("max"));
            list = dao.getProductsByPriceRange(min, max);
            if (max == -1) title = "Giá trên " + (long)min + " đ";
            else title = "Giá từ " + (long)min + " đ - " + (long)max + " đ";
        }
        // 2. TÌM THEO TỪ KHÓA
        else if ("search".equals(type)) {
            String keyword = request.getParameter("keyword");
            list = dao.searchProducts(keyword);
            title = "Kết quả tìm kiếm: " + keyword;
        }
        // 3. TÌM THEO THƯƠNG HIỆU
        else if ("brand".equals(type)) {
            String brandName = request.getParameter("name");
            list = dao.getProductsByBrand(brandName);
            title = "Thương hiệu: " + brandName;
        }
        // 4. SẢN PHẨM LUXURY
        else if ("luxury".equals(type)) {
            list = dao.getLuxuryProducts1();
            title = "Bộ sưu tập Luxury";
        }
        // 5. TÌM THEO XUẤT XỨ
        else if ("origin".equals(type)) {
            String origin = request.getParameter("name"); // VD: Nhat Ban, Thuy Sy
            list = dao.getProductsByOrigin(origin);
            title = "Đồng hồ " + origin;
        }
        // 6. PHỤ KIỆN
        else if ("accessories".equals(type)) {
            // Giả sử phụ kiện có CategoryID = 2 hoặc 3 (Bạn tự check DB)
            // Hoặc tìm theo tên danh mục
            list = dao.searchProducts("Phụ kiện"); // Cách chữa cháy nếu chưa có hàm getByCategory
            title = "Phụ kiện đồng hồ";
        }

        else if ("nam".equals(type)) {
            list = dao.getMenProducts();
            title = "Đồng hồ nam";
        }

        else if ("nu".equals(type)) {
            list = dao.getWomenProducts();
            title = "Đồng hồ nữ";
        }

        request.setAttribute("listProduct", list);
        request.setAttribute("pageTitle", title);
        request.getRequestDispatcher("product-list.jsp").forward(request, response);
    }
}