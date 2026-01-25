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

        request.setAttribute("listOrders", listOrders);
        request.getRequestDispatcher("user/order-history.jsp").forward(request, response);
    }
}