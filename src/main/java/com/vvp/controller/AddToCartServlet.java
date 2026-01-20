package com.vvp.controller;

import com.vvp.dao.ProductDAO;
import com.vvp.model.CartItem;
import com.vvp.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddToCartServlet", urlPatterns = {"/add-to-cart"})
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1. Lấy tham số và kiểm tra kỹ
            String pidRaw = request.getParameter("pid");
            String quantityRaw = request.getParameter("quantity");

            // Nếu pid rỗng -> Lỗi ngay (tránh 500)
            if (pidRaw == null || pidRaw.trim().isEmpty()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing Product ID");
                return;
            }

            int productId = Integer.parseInt(pidRaw);
            int quantity = 1;
            try {
                if (quantityRaw != null && !quantityRaw.isEmpty()) {
                    quantity = Integer.parseInt(quantityRaw);
                }
            } catch (NumberFormatException e) { }

            HttpSession session = request.getSession();

            // 2. Lấy giỏ hàng từ Session (Dùng List như bạn đã chọn trước đó)
            // Lưu ý: Nếu bạn dùng Map thì sửa lại Logic Map, ở đây mình viết theo List để đồng bộ với CartServlet cũ
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
            }

            // 3. Logic thêm/cộng dồn
            boolean found = false;
            for (CartItem item : cart) {
                if (item.getProduct().getId() == productId) {
                    item.setQuantity(item.getQuantity() + quantity);
                    found = true;
                    break;
                }
            }
            if (!found) {
                ProductDAO dao = new ProductDAO();
                Product product = dao.getProductById(productId);
                if (product != null) {
                    cart.add(new CartItem(product, quantity));
                }
            }

            // 4. Lưu lại Session
            session.setAttribute("cart", cart);

            // Tính tổng số lượng
            int totalCount = 0;
            for (CartItem item : cart) totalCount += item.getQuantity();
            session.setAttribute("cartCount", totalCount);

            // --- XỬ LÝ ĐIỀU HƯỚNG ---
            String ajax = request.getParameter("ajax");
            String action = request.getParameter("action");

            // TRƯỜNG HỢP 1: AJAX (Nút "Thêm vào giỏ")
            if ("true".equals(ajax)) {
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(String.valueOf(totalCount)); // Trả về số lượng mới
                return; // DỪNG LẠI, KHÔNG REDIRECT
            }

            // TRƯỜNG HỢP 2: MUA NGAY
            else if ("buynow".equals(action)) {
                response.sendRedirect("user/checkout.jsp");
            }

            // TRƯỜNG HỢP 3: FALLBACK
            else {
                String referer = request.getHeader("Referer");
                response.sendRedirect(referer != null ? referer : "home");
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Nếu lỗi AJAX -> Trả về lỗi 500 để JS bắt được
            if ("true".equals(request.getParameter("ajax"))) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server Error: " + e.getMessage());
            } else {
                response.sendRedirect("home");
            }
        }
    }
}