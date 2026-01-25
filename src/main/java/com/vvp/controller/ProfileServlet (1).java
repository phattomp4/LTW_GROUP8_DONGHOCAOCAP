package com.vvp.controller;

import com.vvp.dao.UserDAO;
import com.vvp.model.User;
import com.vvp.model.UserAddress; // Nhớ import class này
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {

    // 1. GET: Hiển thị trang hồ sơ và danh sách địa chỉ
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User acc = (User) session.getAttribute("acc");

        // Nếu chưa đăng nhập -> Đá về trang login
        if (acc == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Gọi DAO lấy danh sách địa chỉ nhận hàng
        UserDAO dao = new UserDAO();
        // --- XỬ LÝ XÓA ---
        String action = request.getParameter("action");
        String idRaw = request.getParameter("id");
        if ("delete".equals(action) && idRaw != null) {
            dao.deleteAddress(Integer.parseInt(idRaw));
            session.setAttribute("mess", "Đã xóa địa chỉ thành công!");
            response.sendRedirect("profile"); // Load lại trang để thấy mất địa chỉ
            return;
        }
        List<UserAddress> listAddress = dao.getAddresses(acc.getId());

        // Đẩy dữ liệu sang JSP
        request.setAttribute("listAddress", listAddress);
        request.getRequestDispatcher("user/profile.jsp").forward(request, response);
    }

    // 2. POST: Xử lý khi người dùng bấm Lưu hoặc Thêm địa chỉ
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // QUAN TRỌNG: Dòng này bắt buộc phải ở đầu tiên để không lỗi font Tiếng Việt
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        User acc = (User) session.getAttribute("acc");

        // Kiểm tra đăng nhập
        if (acc == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        UserDAO dao = new UserDAO();

        // TRƯỜNG HỢP 1: CẬP NHẬT THÔNG TIN CÁ NHÂN
        if ("updateInfo".equals(action)) {
            // Lấy dữ liệu từ form
            String fullName = request.getParameter("fullname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");
            String address = request.getParameter("address"); // Địa chỉ chính

            // Cập nhật vào đối tượng User hiện tại
            acc.setFullName(fullName);
            acc.setEmail(email);
            acc.setPhone(phone);
            acc.setGender(gender);
            acc.setAddress(address);

            // Lưu xuống Database
            dao.updateAccountProfile(acc);

            // QUAN TRỌNG: Cập nhật lại Session để giao diện tự đổi mới
            session.setAttribute("acc", acc);

            // Có thể thêm thông báo (cần xử lý bên JSP để hiển thị)
            session.setAttribute("mess", "Cập nhật hồ sơ thành công!");
        }

        // TRƯỜNG HỢP 2: THÊM ĐỊA CHỈ PHỤ (Address Cards)
        else if ("addAddress".equals(action)) {
            String name = request.getParameter("new_name");
            String phone = request.getParameter("new_phone");
            String addr = request.getParameter("new_address");

            // Gọi hàm thêm địa chỉ trong DAO
            dao.addAddress(acc.getId(), name, phone, addr);

            session.setAttribute("mess", "Thêm địa chỉ mới thành công!");
        }

        // TRƯỜNG HỢP 3: SỬA ĐỊA CHỈ
        else if ("editAddress".equals(action)) {
            try {
                int addrId = Integer.parseInt(request.getParameter("edit_id"));
                String name = request.getParameter("edit_name");
                String phone = request.getParameter("edit_phone");
                String street = request.getParameter("edit_address");

                dao.updateUserAddress(addrId, name, phone, street);
                session.setAttribute("mess", "Cập nhật địa chỉ thành công!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Load lại trang profile để thấy thay đổi (Dùng sendRedirect để tránh lỗi resubmit form)
        response.sendRedirect("profile");
    }
}