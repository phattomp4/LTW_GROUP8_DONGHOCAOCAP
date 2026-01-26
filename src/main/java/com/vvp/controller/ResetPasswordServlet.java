package com.vvp.controller;

import com.vvp.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ResetPasswordServlet", urlPatterns = {"/reset-password"})
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        request.setAttribute("token", token);
        request.getRequestDispatcher("reset_password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        String pass = request.getParameter("password");
        String rePass = request.getParameter("repassword");

        if (!pass.equals(rePass)) {
            request.setAttribute("mess", "Mật khẩu xác nhận không khớp!");
            request.setAttribute("token", token);
            request.getRequestDispatcher("reset_password.jsp").forward(request, response);
            return;
        }

        UserDAO dao = new UserDAO();
        boolean isSuccess = dao.resetPassword(token, pass);

        if (isSuccess) {
            request.setAttribute("mess", "Đặt lại mật khẩu thành công! Vui lòng đăng nhập.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("mess", "Link không hợp lệ hoặc đã hết hạn!");
            request.getRequestDispatcher("reset_password.jsp").forward(request, response);
        }
    }
}