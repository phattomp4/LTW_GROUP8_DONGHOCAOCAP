package com.vvp.controller;

import com.vvp.dao.ProductDAO;
import com.vvp.model.CartItem;
import com.vvp.model.Product;
import com.vvp.model.User;
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
            // --- 2. DI CHUYỂN SESSION LÊN ĐẦU ĐỂ KIỂM TRA QUYỀN TRƯỚC ---
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("acc");

            // --- 3. LOGIC CHẶN ADMIN MUA HÀNG ---
            if (user != null && "Admin".equals(user.getRole())) {
                String ajax = request.getParameter("ajax");
                if ("true".equals(ajax)) {
                    // Nếu là Ajax (bấm nút Thêm vào giỏ), trả về lỗi 403
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("Admin không được phép mua hàng! Vui lòng dùng tài khoản Khách.");
                } else {
                    // Nếu là request thường (bấm Mua ngay), chuyển về trang quản trị
                    response.sendRedirect("admin/dashboard");
                }
                return; // Dừng xử lý ngay lập tức
            }
            // 1. Lấy tham số và kiểm tra kỹ
            String pidRaw = request.getParameter("pid");
            String quantityRaw = request.getParameter("quantity");

            // Nếu pid rỗng -> Lỗi ngay
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

            // --- ĐOẠN CODE THÊM MỚI: KIỂM TRA TỒN KHO TỪ DATABASE ---
            ProductDAO dao = new ProductDAO();
            Product pCheck = dao.getProductById(productId);

            // 1. Kiểm tra sản phẩm có tồn tại và còn hàng không
            if (pCheck == null || pCheck.getStockQuantity() <= 0) {
                if ("true".equals(request.getParameter("ajax"))) {
                    // Trả về lỗi cho AJAX (Javascript ở detail.jsp sẽ bắt được)
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().write("Sản phẩm này đã hết hàng!");
                } else {
                    // Chuyển hướng về trang chi tiết (hoặc trang lỗi)
                    response.sendRedirect("detail?pid=" + productId);
                }
                return; // DỪNG XỬ LÝ
            }

            // 2. (Tùy chọn) Kiểm tra mua quá số lượng tồn kho
            if (quantity > pCheck.getStockQuantity()) {
                if ("true".equals(request.getParameter("ajax"))) {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().write("Chỉ còn " + pCheck.getStockQuantity() + " sản phẩm trong kho!");
                    return;
                }
                // Nếu không phải ajax thì gán quantity = max stock (hoặc báo lỗi)
                quantity = pCheck.getStockQuantity();
            }
            // ---------------------------------------------------------


            // 2. Lấy giỏ hàng từ Session
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
            }

            // 3. Logic thêm/cộng dồn sản phẩm
            boolean found = false;
            for (CartItem item : cart) {
                if (item.getProduct().getId() == productId) {
                    item.setQuantity(item.getQuantity() + quantity);
                    found = true;
                    break;
                }
            }
            if (!found) {
                Product product = dao.getProductById(productId);
                if (product != null) {
                    cart.add(new CartItem(product, quantity));
                }
            }

            // 4. Lưu lại Session
            session.setAttribute("cart", cart);

            // Tính tổng số lượng để hiển thị lên icon giỏ hàng
            int totalCount = 0;
            for (CartItem item : cart) totalCount += item.getQuantity();
            session.setAttribute("cartCount", totalCount);

            // --- XỬ LÝ ĐIỀU HƯỚNG ---
            String ajax = request.getParameter("ajax");
            String action = request.getParameter("action");

            // TRƯỜNG HỢP 1: AJAX (Nút "Thêm vào giỏ" - không load lại trang)
            if ("true".equals(ajax)) {
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(String.valueOf(totalCount));
                return;
            }

            // TRƯỜNG HỢP 2: MUA NGAY (Yêu cầu Đăng nhập)
            else if ("buynow".equals(action)) {



                if (user == null) {
                    // --- MỚI: LƯU LẠI MONG MUỐN CỦA KHÁCH ---
                    // Lưu một biến vào session để LoginServlet biết đường xử lý
                    session.setAttribute("redirectAfterLogin", "checkout");

                    // Chuyển sang trang Login
                    response.sendRedirect("login.jsp");
                } else {
                    // ĐÃ ĐĂNG NHẬP -> Chuyển thẳng sang trang Thanh toán
                    response.sendRedirect("checkout");
                }
                return; // Kết thúc xử lý
            }

            // TRƯỜNG HỢP 3: Mặc định (Tải lại trang hiện tại)
            else {
                String referer = request.getHeader("Referer");
                response.sendRedirect(referer != null ? referer : "home");
            }

        } catch (Exception e) {
            e.printStackTrace();
            if ("true".equals(request.getParameter("ajax"))) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server Error: " + e.getMessage());
            } else {
                response.sendRedirect("home");
            }
        }
    }
}