package com.vvp.controller;

import com.vvp.dao.ProductDAO;
import com.vvp.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO(); // KHỞI TẠO DAO
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String keyword = req.getParameter("keyword");
        if (keyword == null) keyword = "";

        List<Product> list = productDAO.search(keyword);

        // Kiểm tra đây có phải là request AJAX
        String ajax = req.getHeader("X-Requested-With");

        // 🔥 Nếu là AJAX → trả HTML (dùng cho realtime search)
        if ("XMLHttpRequest".equals(ajax)) {
            resp.setContentType("text/html; charset=UTF-8");

            StringBuilder sb = new StringBuilder();
            for (Product p : list) {
                sb.append("<a href='productdetail?id=" + p.getId() + "'>");
                sb.append("<div class='search-item'>");
                sb.append("<img src='" + p.getImageUrl() + "'>");
                sb.append("<span>" + p.getName() + "</span>");
                sb.append("</div>");
                sb.append("</a>");
            }

            resp.getWriter().write(sb.toString());
            return;
        }

        // 🔥 Nếu không phải AJAX → tìm kiếm bình thường
        req.setAttribute("keyword", keyword);
        req.setAttribute("list", list);

        req.getRequestDispatcher("search.jsp").forward(req, resp);

    }
}
