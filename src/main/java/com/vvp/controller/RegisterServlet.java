package com.vvp.controller;

import com.vvp.dao.UserDAO;
import com.vvp.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý tiếng Việt
        request.setCharacterEncoding("UTF-8");

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("re_pass");
        String fullName = request.getParameter("fullname"); // Lấy họ tên
        String email = request.getParameter("email");

        if (!pass.equals(re_pass)) {
            request.setAttribute("mess", "Mật khẩu không khớp!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            UserDAO dao = new UserDAO();
            User a = dao.checkUserExist(user);
            if (a == null) {
                // Gọi hàm signup mới có fullName
                dao.signup(user, pass, fullName, email);
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("mess", "Tài khoản đã tồn tại!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }
    }
}