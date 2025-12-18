package com.vvp.controller;

import com.vvp.service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private AccountService accountService = new AccountService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Nhận dữ liệu từ Form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        // 2. Xác thực (Validation)
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Xác nhận mật khẩu không khớp.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // 3. Gọi Service để thực hiện đăng ký
        boolean success = accountService.register(username, password);

        if (success) {
            // Đăng ký thành công -> Chuyển hướng tới trang đăng nhập
            response.sendRedirect(request.getContextPath() + "/login.jsp?registered=true");
        } else {
            // Đăng ký thất bại (ví dụ: Username đã tồn tại)
            request.setAttribute("errorMessage", "Tên đăng nhập đã tồn tại. Vui lòng chọn tên khác.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
