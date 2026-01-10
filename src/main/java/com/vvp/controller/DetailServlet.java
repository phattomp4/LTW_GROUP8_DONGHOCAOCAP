package com.vvp.controller;

import com.vvp.dao.ProductDAO;
import com.vvp.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DetailServlet", urlPatterns = {"/detail"})
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Lấy ID từ URL (ví dụ: detail?pid=1)
            int pid = Integer.parseInt(request.getParameter("pid"));

            ProductDAO dao = new ProductDAO();
            Product p = dao.getProductById(pid); // Hàm này đã chứa đủ ảnh và specs

            if(p != null) {
                request.setAttribute("p", p);
                // Chuyển sang trang detail.jsp
                request.getRequestDispatcher("detail.jsp").forward(request, response);
            } else {
                response.sendRedirect("home"); // Không tìm thấy SP thì về trang chủ
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("home");
        }
    }
}