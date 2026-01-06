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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddToCartServlet", urlPatterns = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1. Lấy tham số từ URL
            String pidRaw = request.getParameter("pid");

            // --- KIỂM TRA QUAN TRỌNG ĐỂ TRÁNH LỖI NULL ---
            // Nếu không có pid (người dùng vào sai link), quay về trang chủ ngay
            if (pidRaw == null || pidRaw.isEmpty()) {
                response.sendRedirect("home");
                return;
            }

            int pid = Integer.parseInt(pidRaw); // Nếu pidRaw là chữ cái, dòng này sẽ nhảy xuống catch

            // 2. Lấy giỏ hàng từ Session
            HttpSession session = request.getSession();
            Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
            if (cart == null) cart = new HashMap<>();

            // 3. Logic thêm vào giỏ
            if (cart.containsKey(pid)) {
                // Nếu sản phẩm đã có -> Tăng số lượng
                CartItem item = cart.get(pid);
                item.setQuantity(item.getQuantity() + 1);
            } else {
                // Nếu chưa có -> Lấy từ DB
                ProductDAO dao = new ProductDAO();
                Product p = dao.getProductById(pid);
                if (p != null) {
                    // Tạo CartItem từ Product, số lượng ban đầu là 1
                    CartItem item = new CartItem(p, 1);
                    cart.put(pid, item);
                }
            }

            // 4. Cập nhật lại Session
            session.setAttribute("cart", cart);
            session.setAttribute("size", cart.size()); // Cập nhật số lượng item trên icon giỏ hàng

            // Tính tổng tiền (nếu cần hiển thị ngay)
            double total = 0;
            for (CartItem ci : cart.values()) {
                total += ci.getTotalPrice();
            }
            session.setAttribute("totalMoney", total);

            // 5. Quay về trang chủ (hoặc trang người dùng vừa đứng)
            response.sendRedirect("home");

        } catch (NumberFormatException e) {
            // Nếu pid không phải số (vd: ?pid=abc) -> Quay về trang chủ
            System.out.println("Lỗi định dạng số ID sản phẩm: " + e.getMessage());
            response.sendRedirect("home");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("home");
        }
    }
}