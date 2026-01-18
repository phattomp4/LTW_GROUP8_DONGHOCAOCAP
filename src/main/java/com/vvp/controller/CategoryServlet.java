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

        String type = request.getParameter("type"); // price hoặc search

        if ("price".equals(type)) {
            // Lấy khoảng giá
            double min = Double.parseDouble(request.getParameter("min"));
            double max = Double.parseDouble(request.getParameter("max"));
            list = dao.getProductsByPriceRange(min, max);

            if (max == -1) title = "Giá trên " + (long)min + " đ";
            else title = "Giá từ " + (long)min + " đ - " + (long)max + " đ";

        } else if ("search".equals(type)) {
            // Lấy từ khóa (Brand, Style...)
            String keyword = request.getParameter("keyword");
            list = dao.searchProducts(keyword);
            title = "Kết quả cho: " + keyword;
        }

        // Đẩy dữ liệu sang JSP
        request.setAttribute("listProduct", list);
        request.setAttribute("pageTitle", title);
        request.getRequestDispatcher("product-list.jsp").forward(request, response);
    }
}