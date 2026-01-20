package com.vvp.controller;

import com.vvp.model.CartItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        // --- XỬ LÝ CÁC HÀNH ĐỘNG (THÊM, BỚT, XÓA) ---
        String action = request.getParameter("action");
        if (action != null) {
            int pid = Integer.parseInt(request.getParameter("pid"));

            // Tìm sản phẩm trong giỏ
            CartItem target = null;
            for (CartItem item : cart) {
                if (item.getProduct().getId() == pid) {
                    target = item;
                    break;
                }
            }

            if (target != null) {
                if ("delete".equals(action)) {
                    cart.remove(target);
                } else if ("inc".equals(action)) {
                    target.setQuantity(target.getQuantity() + 1);
                } else if ("dec".equals(action)) {
                    if (target.getQuantity() > 1) {
                        target.setQuantity(target.getQuantity() - 1);
                    } else {
                        cart.remove(target); // Giảm về 0 thì xóa luôn
                    }
                }
            }

            // Cập nhật lại số lượng trên icon
            int totalCount = 0;
            for (CartItem item : cart) totalCount += item.getQuantity();
            session.setAttribute("cartCount", totalCount);

            // Chuyển hướng để tránh lỗi resubmit form
            response.sendRedirect("cart");
            return;
        }

        // --- TÍNH TOÁN TIỀN ---
        double totalMoney = 0;
        for (CartItem item : cart) {
            totalMoney += item.getTotalPrice();
        }

        // Xử lý Voucher (Giả lập)
        String voucher = request.getParameter("voucherCode");
        double discount = 0;
        if ("GIAM10".equals(voucher)) {
            discount = totalMoney * 0.1;
            request.setAttribute("voucherMessage", "Áp dụng mã GIAM10 thành công!");
        } else if (voucher != null && !voucher.isEmpty()) {
            request.setAttribute("voucherMessage", "Mã giảm giá không hợp lệ.");
        }

        // Đẩy dữ liệu sang JSP
        request.setAttribute("totalMoney", totalMoney);
        request.setAttribute("discount", discount);
        request.setAttribute("finalTotal", totalMoney - discount);

        // Lưu ý: List cart đã nằm trong Session nên JSP tự lấy được qua ${sessionScope.cart}
        request.getRequestDispatcher("user/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}