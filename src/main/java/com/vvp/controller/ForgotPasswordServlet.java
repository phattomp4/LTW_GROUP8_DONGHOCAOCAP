package com.vvp.controller;

import com.vvp.dao.UserDAO;
import com.vvp.model.User;
import com.vvp.utils.EmailUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "ForgotPasswordServlet", urlPatterns = {"/forgot-password"})
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("forgot_password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        UserDAO dao = new UserDAO();
        User user = dao.checkEmailExist(email);

        if (user == null) {
            request.setAttribute("mess", "Email không tồn tại trong hệ thống!");
            request.getRequestDispatcher("forgot_password.jsp").forward(request, response);
        } else {
            // 1. Tạo Token ngẫu nhiên
            String token = UUID.randomUUID().toString();

            // 2. Lưu token vào DB
            dao.updateResetToken(email, token);

            // 3. Tạo link reset
            // Lưu ý: Sửa localhost:8080 thành domain thật khi deploy
            String resetLink = "http://localhost:8080" + request.getContextPath() + "/reset-password?token=" + token;

            // 4. Gửi email
            String subject = "Yêu cầu đặt lại mật khẩu - VVP Watch";
            String content = "Chào " + user.getUsername() + ",\n\n"
                    + "Bạn vừa yêu cầu đặt lại mật khẩu. Vui lòng nhấn vào link dưới đây để đổi mật khẩu:\n"
                    + resetLink + "\n\nLink này sẽ hết hạn sau 15 phút.";

            // Chạy gửi mail trong luồng riêng để không bị đơ trang web
            new Thread(() -> EmailUtils.sendEmail(email, subject, content)).start();

            request.setAttribute("mess", "Link đặt lại mật khẩu đã được gửi vào email của bạn!");
            request.setAttribute("type", "success"); // Để tô màu xanh thông báo
            request.getRequestDispatcher("forgot_password.jsp").forward(request, response);
        }
    }
}