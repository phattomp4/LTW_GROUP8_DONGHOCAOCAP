package com.vvp.controller;

import com.vvp.dao.OrderDAO;
import com.vvp.model.Order;
import com.vvp.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderHistoryServlet", urlPatterns = {"/order-history"})
public class OrderHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User acc = (User) session.getAttribute("acc");

        // Bắt buộc đăng nhập
        if (acc == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Lấy danh sách đơn hàng
        OrderDAO dao = new OrderDAO();
        List<Order> listOrders = dao.getOrdersByUserId(acc.getId());
// --- PHẦN MỚI THÊM: XỬ LÝ YÊU CẦU HỦY ĐƠN ---
        String action = request.getParameter("action");
        if ("requestCancel".equals(action)) {
            try {
                int orderId = Integer.parseInt(request.getParameter("id"));
                Order order = dao.getOrderById(orderId);

                // Kiểm tra bảo mật: Chỉ hủy đơn của chính mình và đúng trạng thái
                if (order != null && order.getUserId() == acc.getId()) {
                    if ("Pending".equals(order.getStatus()) || "Processing".equals(order.getStatus())) {
                        dao.updateOrderStatus(orderId, "Request Cancel");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Load lại trang để thấy trạng thái mới
            response.sendRedirect("order-history");
            return;
        }
        request.setAttribute("listOrders", listOrders);
        request.getRequestDispatcher("user/order-history.jsp").forward(request, response);
    }
}