package com.vvp.controller;

import com.vvp.dao.ProductDAO;
import com.vvp.model.CartItem;
import com.vvp.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    // Thêm vào giỏ hàng
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new HashMap<>();

        if ("add".equals(action)) {
            int id = Integer.parseInt(request.getParameter("pid"));
            if (cart.containsKey(id)) {
                CartItem item = cart.get(id);
                item.setQuantity(item.getQuantity() + 1);
            } else {
                ProductDAO dao = new ProductDAO();
                Product p = dao.getProductById(id); // Bạn cần viết thêm hàm này trong ProductDAO
                if(p != null) {
                    CartItem item = new CartItem(p, 1);
                    cart.put(id, item);
                }
            }
        }
        else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("pid"));
            cart.remove(id);
        }

        session.setAttribute("cart", cart);

        // Tính tổng tiền lưu vào session để hiển thị
        double totalMoney = 0;
        for (CartItem item : cart.values()) {
            totalMoney += item.getTotalPrice();
        }
        session.setAttribute("totalMoney", totalMoney);

        response.sendRedirect("user/cart.jsp");
    }
}