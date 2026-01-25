package com.vvp.controller;

import com.vvp.dao.AdminDAO;
import com.vvp.model.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminDashboardServlet", urlPatterns = {"/admin/dashboard"})
public class AdminDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDAO dao = new AdminDAO();

        // Lấy số liệu thống kê
        double revenue = dao.getTotalRevenue();
        int totalOrders = dao.countOrders();
        int totalUsers = dao.countUsers();

        // Lấy danh sách đơn hàng (để quản lý luôn ở trang chính hoặc trang riêng)
        List<Order> listOrders = dao.getAllOrders();

        request.setAttribute("revenue", revenue);
        request.setAttribute("totalOrders", totalOrders);
        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("listOrders", listOrders);

        request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
    }

    // Xử lý cập nhật trạng thái đơn hàng ngay tại Dashboard (hoặc tách ra Servlet riêng)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("update_status".equals(action)) {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            String status = request.getParameter("status");

            AdminDAO dao = new AdminDAO();
            dao.updateOrderStatus(orderId, status);

            // Cập nhật xong thì load lại trang
            response.sendRedirect("dashboard");
        }
    }
}