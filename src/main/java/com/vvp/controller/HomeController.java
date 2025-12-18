package com.vvp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.vvp.model.Account; // Giả sử Account model nằm ở đây
import java.io.IOException;

@WebServlet("/home") // <-- Cấu hình để bắt các URL /home/bất_kỳ_thứ_gì
public class HomeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // Không tạo session mới nếu chưa có

        if (session == null || session.getAttribute("user") == null) {
            // Nếu chưa đăng nhập, chuyển hướng về trang đăng nhập
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // Lấy thông tin user từ session
        Account user = (Account) session.getAttribute("user");

        // Lấy phần cuối của URL (ví dụ: /home/vu -> lấy ra 'vu')
        String pathInfo = request.getPathInfo(); // Sẽ trả về /vu

        // Kiểm tra xem phần cuối URL có khớp với username không
        if (pathInfo != null && pathInfo.length() > 1) {
            String urlUsername = pathInfo.substring(1); // Bỏ dấu '/' đầu tiên

            if (urlUsername.equals(user.getUsername())) {
                // Tên người dùng trong URL khớp với người dùng đang đăng nhập
                // Chuyển tiếp tới trang chủ (ví dụ: index.jsp)
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
        }

        // Nếu URL không khớp hoặc có lỗi, chuyển hướng về trang chủ mặc định (hoặc lỗi 404)
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
