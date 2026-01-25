package com.vvp.dao;

import com.vvp.context.DBContext;
import com.vvp.model.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    // Lấy danh sách đơn hàng của 1 User
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Orders WHERE UserID = ? ORDER BY OrderDate DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderId(rs.getInt("OrderID"));
                o.setUserId(rs.getInt("UserID"));
                o.setOrderDate(rs.getTimestamp("OrderDate"));
                o.setTotalAmount(rs.getDouble("TotalAmount"));
                o.setStatus(rs.getString("Status")); // Quan trọng: Trạng thái đơn
                o.setPaymentMethod(rs.getString("PaymentMethod"));
                o.setPaymentStatus(rs.getString("PaymentStatus"));
                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy chi tiết sản phẩm của 1 đơn hàng (Để xem chi tiết nếu cần)
    // Lưu ý: Bạn cần Class OrderDetail có chứa Product bên trong (hoặc join bảng)
    // Ở đây mình làm đơn giản lấy số lượng SP trước
    public int countProductsInOrder(int orderId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT COUNT(*) FROM OrderDetails WHERE OrderID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 1. Lấy thông tin cơ bản của 1 đơn hàng
    public Order getOrderById(int orderId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Orders WHERE OrderID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            if (rs.next()) {
                com.vvp.model.Order o = new com.vvp.model.Order();
                o.setOrderId(rs.getInt("OrderID"));
                o.setUserId(rs.getInt("UserID"));
                o.setShippingAddressId(rs.getInt("ShippingAddressID"));
                o.setOrderDate(rs.getTimestamp("OrderDate"));
                o.setTotalAmount(rs.getDouble("TotalAmount"));
                o.setDiscountAmount(rs.getDouble("DiscountAmount"));
                o.setStatus(rs.getString("Status"));
                o.setPaymentMethod(rs.getString("PaymentMethod"));
                return o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 2. Lấy danh sách sản phẩm trong đơn hàng (Kèm thông tin Product)
    // Lấy danh sách chi tiết đơn hàng (Kèm thông tin Tên & Ảnh sản phẩm)
    public List<OrderDetail> getOrderDetails(int orderId) {
        List<OrderDetail> list = new ArrayList<>();

        // SỬA: p.ProductName -> p.Name
        String query = "SELECT od.*, p.Name, " +
                "(SELECT ImageURL FROM ProductImages WHERE ProductID = p.ProductID LIMIT 1) AS ImageURL " +
                "FROM OrderDetails od " +
                "JOIN Products p ON od.ProductID = p.ProductID " +
                "WHERE od.OrderID = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail od = new OrderDetail();
                od.setOrderDetailId(rs.getInt("OrderDetailID"));
                od.setOrderId(rs.getInt("OrderID"));
                od.setProductId(rs.getInt("ProductID"));
                od.setQuantity(rs.getInt("Quantity"));
                od.setPriceAtPurchase(rs.getDouble("PriceAtPurchase"));

                Product p = new Product();
                p.setId(rs.getInt("ProductID"));

                // SỬA: Lấy dữ liệu từ cột "Name"
                p.setName(rs.getString("Name"));

                String img = rs.getString("ImageURL");
                if (img == null) img = "https://via.placeholder.com/150";
                p.setImageUrl(img);

                od.setProduct(p);
                list.add(od);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ... (Giữ nguyên phần đóng kết nối của bạn)
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}