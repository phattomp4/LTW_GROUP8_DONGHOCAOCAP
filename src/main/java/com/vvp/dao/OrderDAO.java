package com.vvp.dao;

import com.vvp.context.DBContext;
import com.vvp.model.CartItem;
import com.vvp.model.User;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDAO {

    // Hàm này trả về true nếu thành công, false nếu thất bại
    public boolean insertOrder(User user, List<CartItem> cart, int addressId, String paymentMethod, double totalAmount, double discountAmount) {
        Connection conn = null;
        PreparedStatement psOrder = null;
        PreparedStatement psDetail = null;
        PreparedStatement psUpdateProduct = null;
        ResultSet rs = null;

        try {
            conn = new DBContext().getConnection();

            // 1. Tắt chế độ tự động lưu (để quản lý Transaction)
            conn.setAutoCommit(false);

            // 2. INSERT VÀO BẢNG ORDERS
            String sqlOrder = "INSERT INTO Orders (UserID, ShippingAddressID, OrderDate, TotalAmount, DiscountAmount, PaymentMethod, PaymentStatus, Status) "
                    + "VALUES (?, ?, NOW(), ?, ?, ?, ?, ?)";

            // RETURN_GENERATED_KEYS để lấy lại OrderID vừa tạo
            psOrder = conn.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
            psOrder.setInt(1, user.getId());
            psOrder.setInt(2, addressId);
            psOrder.setDouble(3, totalAmount);
            psOrder.setDouble(4, discountAmount);
            psOrder.setString(5, paymentMethod); // VD: "COD" hoặc "Banking"
            psOrder.setString(6, "Pending");     // Mặc định là Chờ thanh toán
            psOrder.setString(7, "Processing");  // Mặc định là Đang xử lý
            psOrder.executeUpdate();

            // Lấy OrderID vừa sinh ra
            rs = psOrder.getGeneratedKeys();
            int orderId = 0;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            // 3. INSERT VÀO BẢNG ORDERDETAILS VÀ UPDATE PRODUCTS
            String sqlDetail = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity, PriceAtPurchase) VALUES (?, ?, ?, ?)";
            String sqlUpdateProduct = "UPDATE Products SET StockQuantity = StockQuantity - ?, SoldQuantity = SoldQuantity + ? WHERE ProductID = ?";

            psDetail = conn.prepareStatement(sqlDetail);
            psUpdateProduct = conn.prepareStatement(sqlUpdateProduct);

            for (CartItem item : cart) {
                // Thêm chi tiết đơn hàng
                psDetail.setInt(1, orderId);
                psDetail.setInt(2, item.getProduct().getId()); // Lưu ý: model Product của bạn dùng getId() hay getProductID() thì sửa lại
                psDetail.setInt(3, item.getQuantity());
                psDetail.setDouble(4, item.getProduct().getCurrentPrice());
                psDetail.addBatch(); // Gom lệnh lại chạy 1 lần

                // Trừ tồn kho, tăng đã bán
                psUpdateProduct.setInt(1, item.getQuantity());
                psUpdateProduct.setInt(2, item.getQuantity());
                psUpdateProduct.setInt(3, item.getProduct().getId());
                psUpdateProduct.addBatch();
            }

            // Chạy các lệnh Batch
            psDetail.executeBatch();
            psUpdateProduct.executeBatch();

            // 4. CHỐT GIAO DỊCH (COMMIT)
            conn.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback(); // Gặp lỗi thì quay xe, không lưu gì cả
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            // Đóng kết nối
            try {
                if (rs != null) rs.close();
                if (psOrder != null) psOrder.close();
                if (psDetail != null) psDetail.close();
                if (psUpdateProduct != null) psUpdateProduct.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}