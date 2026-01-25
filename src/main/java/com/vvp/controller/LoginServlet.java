package com.vvp.controller;

import com.vvp.dao.UserDAO;
import com.vvp.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Lấy dữ liệu từ form login.jsp gửi lên
        String u = request.getParameter("username");
        String p = request.getParameter("password");

        // 2. Gọi DAO để kiểm tra trong Database
        UserDAO dao = new UserDAO();
        User user = dao.login(u, p); // Hàm này đã check password hash BCrypt

        if (user == null) {
            // A. Đăng nhập thất bại
            request.setAttribute("mess", "Sai tên đăng nhập hoặc mật khẩu!");
            // Giữ nguyên thông tin user vừa nhập để họ đỡ phải gõ lại
            request.setAttribute("username", u);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            // B. Đăng nhập thành công
            HttpSession session = request.getSession();
            session.setAttribute("acc", user); // Lưu toàn bộ object User vào session
            session.setMaxInactiveInterval(60 * 60); // Phiên đăng nhập tồn tại 1 tiếng

            // --- ĐOẠN CODE MỚI: XỬ LÝ CHUYỂN HƯỚNG THÔNG MINH ---

            // Kiểm tra xem trước đó khách có đang bấm "Mua ngay" không?
            String redirectUrl = (String) session.getAttribute("redirectAfterLogin");

            if (redirectUrl != null) {
                // Nếu có (ví dụ: "checkout"), xóa nó đi để không bị lặp lại lần sau
                session.removeAttribute("redirectAfterLogin");

                // Chuyển hướng đến trang khách đang muốn vào (Trang thanh toán)
                response.sendRedirect(redirectUrl);
            } else {
                // Nếu không có yêu cầu đặc biệt nào, về trang chủ như bình thường
                response.sendRedirect("home");
            }
            // ----------------------------------------------------
        }
    }
}