package com.vvp.controller;

import com.vvp.dao.AdminDAO;
import com.vvp.dao.OrderDAO;     // Mới thêm
import com.vvp.dao.ProductDAO;   // Mới thêm
import com.vvp.model.Order;
import com.vvp.model.OrderDetail;// Mới thêm
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
        String action = request.getParameter("action");

        // --- 1. XỬ LÝ DUYỆT / TỪ CHỐI HỦY ĐƠN ---
        if ("approveCancel".equals(action) || "rejectCancel".equals(action)) {
            try {
                int orderId = Integer.parseInt(request.getParameter("id"));
                OrderDAO orderDao = new OrderDAO();
                AdminDAO adminDao = new AdminDAO();

                if ("approveCancel".equals(action)) {
                    // A. DUYỆT HỦY
                    // 1. Cập nhật trạng thái
                    adminDao.updateOrderStatus(orderId, "Cancelled");

                    // 2. Hoàn kho (Cộng lại số lượng sản phẩm)
                    ProductDAO productDao = new ProductDAO();
                    List<OrderDetail> details = orderDao.getOrderDetails(orderId);
                    for (OrderDetail d : details) {
                        productDao.updateStock(d.getProductId(), d.getQuantity());
                    }
                } else {
                    // B. TỪ CHỐI HỦY -> Quay về trạng thái Processing
                    adminDao.updateOrderStatus(orderId, "Processing");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Quan trọng: Load lại trang và RETURN ngay để không chạy code phía dưới
            response.sendRedirect("dashboard");
            return;
        }
        // ----------------------------------------

        // --- 2. LOAD DỮ LIỆU DASHBOARD (Mặc định) ---
        AdminDAO dao = new AdminDAO();
        double revenue = dao.getTotalRevenue();
        int totalOrders = dao.countOrders();
        int totalUsers = dao.countUsers();
        List<Order> listOrders = dao.getAllOrders();

        request.setAttribute("revenue", revenue);
        request.setAttribute("totalOrders", totalOrders);
        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("listOrders", listOrders);

        request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("update_status".equals(action)) {
            try {
                int orderId = Integer.parseInt(request.getParameter("orderId"));
                String status = request.getParameter("status");

                AdminDAO dao = new AdminDAO();
                dao.updateOrderStatus(orderId, status);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("dashboard");
        }
    }
}