package com.vvp.controller;

import com.vvp.dao.UserDAO;
import com.vvp.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CheckoutAddressServlet", urlPatterns = {"/checkout-address"})
public class CheckoutAddressServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User acc = (User) session.getAttribute("acc");

        if (acc == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            // 1. Nhận dữ liệu từ Form Modal
            String name = request.getParameter("new_name");
            String phone = request.getParameter("new_phone");
            String address = request.getParameter("new_address");
            // String city = request.getParameter("new_city"); // Nếu có

            // 2. Lưu vào Database
            UserDAO dao = new UserDAO();
            // Hàm này bạn đã có trong UserDAO (giống bên Profile)
            dao.addAddress(acc.getId(), name, phone, address);

            // 3. (QUAN TRỌNG) Lấy ID địa chỉ vừa thêm để set làm mặc định luôn (Tùy chọn)
            // Hoặc đơn giản là load lại trang checkout, địa chỉ mới sẽ hiện ra.

            // Quay lại trang Checkout để mua tiếp
            response.sendRedirect("checkout");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("checkout?error=1");
        }
    }
}