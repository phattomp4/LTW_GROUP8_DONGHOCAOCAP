package com.vvp.controller;

import com.vvp.dao.OrderDAO;
import com.vvp.dao.UserDAO;
import com.vvp.model.CartItem;
import com.vvp.model.User;
import com.vvp.model.UserAddress;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckoutServlet", urlPatterns = {"/checkout"})
public class CheckoutServlet extends HttpServlet {

    // GET: Hiển thị trang Checkout
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User acc = (User) session.getAttribute("acc");
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        // 1. Kiểm tra đăng nhập
        if (acc == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // 2. Kiểm tra giỏ hàng
        if (cart == null || cart.isEmpty()) {
            response.sendRedirect("cart"); // Giỏ trống thì về trang giỏ hàng
            return;
        }

        // 3. Lấy danh sách địa chỉ từ Database
        UserDAO userDAO = new UserDAO();
        List<UserAddress> listAddress = userDAO.getAddresses(acc.getId());
        request.setAttribute("listAddress", listAddress);

        // 4. TÍNH TOÁN TỔNG TIỀN
        double totalMoney = 0;
        for (CartItem item : cart) {
            totalMoney += item.getTotalPrice();
        }

        // Đẩy biến tiền sang JSP để hiển thị
        request.setAttribute("totalMoney", totalMoney);
        request.setAttribute("finalTotal", totalMoney); // Sau này có voucher thì trừ ở đây

        request.getRequestDispatcher("user/checkout.jsp").forward(request, response);
    }

    // POST: Xử lý nút "Đặt hàng"
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User acc = (User) session.getAttribute("acc");
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (acc == null || cart == null) {
            response.sendRedirect("home");
            return;
        }

        // Lấy thông tin từ Form
        String addressIdRaw = request.getParameter("addressId");
        String paymentMethod = request.getParameter("paymentMethod");

        // Tính lại tổng tiền (Backend phải tự tính, không tin tưởng số liệu từ Frontend gửi lên)
        double totalMoney = 0;
        for (CartItem item : cart) {
            totalMoney += item.getTotalPrice();
        }
        double discount = 0; // Xử lý logic Voucher sau nếu cần

        try {
            int addressId = Integer.parseInt(addressIdRaw);

            OrderDAO orderDAO = new OrderDAO();
            boolean result = orderDAO.insertOrder(acc, cart, addressId, paymentMethod, totalMoney - discount, discount);

            if (result) {
                // Đặt hàng thành công
                session.removeAttribute("cart");      // Xóa giỏ hàng
                session.removeAttribute("cartCount"); // Reset số lượng icon

                // Chuyển sang trang thông báo thành công (hoặc trang lịch sử đơn hàng)
                response.sendRedirect("profile"); // Hoặc order-success.jsp
            } else {
                // Thất bại
                request.setAttribute("error", "Đặt hàng thất bại. Vui lòng thử lại!");
                doGet(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}