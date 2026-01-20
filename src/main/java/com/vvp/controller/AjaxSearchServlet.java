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

@WebServlet(name = "AjaxSearchServlet", urlPatterns = {"/ajax-search"})
public class AjaxSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 1. Lấy từ khóa từ JS gửi lên
        String txt = request.getParameter("txt");

        // 2. Gọi DAO tìm kiếm (Hàm searchProducts bạn đã viết trước đó)
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.searchProducts(txt);

        // 3. Đẩy dữ liệu sang trang JSP fragment
        request.setAttribute("listSearch", list);
        request.getRequestDispatcher("ajax-result.jsp").forward(request, response);
    }
}