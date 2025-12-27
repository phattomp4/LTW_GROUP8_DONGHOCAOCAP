package com.vvp.controller;

import com.vvp.dao.ProductDAO; // Giả sử bạn đã có ProductDAO
import com.vvp.model.CartItem;
import com.vvp.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private final ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "view";

        switch (action) {
            case "add":
                addToCart(req, resp);
                break;
            case "remove":
                removeFromCart(req, resp);
                break;
            case "view":
            default:
                req.getRequestDispatcher("user/cart.jsp").forward(req, resp);
                break;
        }
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productDAO.getProductById(id); // Cần hàm này trong ProductDAO

        if (product != null) {
            HttpSession session = req.getSession();
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
            }

            boolean exists = false;
            for (CartItem item : cart) {
                if (item.getProduct().getId() == id) {
                    item.setQuantity(item.getQuantity() + 1);
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                cart.add(new CartItem(product, 1));
            }

            session.setAttribute("cart", cart);

            // Tính tổng tiền luôn để hiển thị
            double totalPrice = 0;
            for(CartItem item : cart) totalPrice += item.getTotalPrice();
            session.setAttribute("totalCartPrice", totalPrice);
        }
        resp.sendRedirect("cart?action=view");
    }

    private void removeFromCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart != null) {
            cart.removeIf(item -> item.getProduct().getId() == id);
            session.setAttribute("cart", cart);

            // Tính lại tổng tiền
            double totalPrice = 0;
            for(CartItem item : cart) totalPrice += item.getTotalPrice();
            session.setAttribute("totalCartPrice", totalPrice);
        }
        resp.sendRedirect("cart?action=view");
    }
}