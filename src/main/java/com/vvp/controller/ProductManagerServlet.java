package com.vvp.controller;

import com.vvp.dao.AdminDAO;
import com.vvp.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// QUAN TRỌNG: Dòng này định nghĩa đường dẫn cho trang quản lý sản phẩm
@WebServlet(name = "ProductManagerServlet", urlPatterns = {"/admin/product-manager"})
public class ProductManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDAO dao = new AdminDAO();
        List<Product> list;

        // 1. Nhận từ khóa tìm kiếm từ URL (name="keyword")
        String keyword = request.getParameter("keyword");

        // 2. Kiểm tra logic
        if (keyword != null && !keyword.trim().isEmpty()) {
            // Nếu có từ khóa -> Tìm kiếm
            list = dao.searchProductsByName(keyword.trim());
        } else {
            // Nếu không -> Lấy tất cả
            list = dao.getAllProducts();
        }

        // 3. Đẩy dữ liệu sang JSP
        request.setAttribute("listProducts", list);
        // Gửi lại từ khóa để hiện lại trên ô input (giữ trạng thái)
        request.setAttribute("searchKeyword", keyword);

        request.getRequestDispatcher("/admin/product-manager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Xử lý xóa sản phẩm
        if ("delete".equals(action)) {
            try {
                int pid = Integer.parseInt(request.getParameter("pid"));
                AdminDAO dao = new AdminDAO();
                dao.deleteProduct(pid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Xóa xong thì load lại trang danh sách
            response.sendRedirect("product-manager");
        }
    }
}