<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanh Toán | VVP Store</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ThanhToan.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body>

<jsp:include page="../WEB-INF/tags/header.jsp" />

<form action="checkout" method="POST">

    <div class="checkout-left-col">
        <div class="checkout-section">
            <h3><i class="fa-solid fa-location-dot"></i> Địa chỉ nhận hàng</h3>
            <div class="address-list">
                <c:if test="${empty listAddress}">
                    <p style="color:red; padding: 10px;">
                        Bạn chưa có địa chỉ nhận hàng.
                        <a href="profile" style="text-decoration: underline; font-weight: bold;">Thêm ngay tại đây</a>
                    </p>
                </c:if>

                <c:forEach items="${listAddress}" var="addr">
                    <div class="address-item" onclick="document.getElementById('addr_${addr.id}').checked = true;">
                        <input type="radio" name="addressId" value="${addr.id}" id="addr_${addr.id}" ${addr.isDefault ? 'checked' : ''} required>
                        <label for="addr_${addr.id}">
                            <b>${addr.name}</b> <span style="color:#666; font-size: 13px;">(${addr.phone})</span> <br>
                                ${addr.address} <c:if test="${not empty addr.city}">- ${addr.city}</c:if>
                        </label>
                    </div>
                </c:forEach>
            </div>
            <p style="margin-top: 15px; font-size: 14px;">
                <a href="profile"><i class="fa-solid fa-plus"></i> Thêm địa chỉ mới</a>
            </p>
        </div>

        <div class="payment-section">
            <h3><i class="fa-regular fa-credit-card"></i> Phương thức thanh toán</h3>
            <div>
                <input type="radio" name="paymentMethod" value="COD" id="cod" checked>
                <label for="cod">
                    <i class="fa-solid fa-truck-fast" style="color: #1b6e76; margin-right: 5px;"></i>
                    Thanh toán khi nhận hàng (COD)
                </label>
            </div>
            <div>
                <input type="radio" name="paymentMethod" value="Banking" id="banking">
                <label for="banking">
                    <i class="fa-solid fa-building-columns" style="color: #1b6e76; margin-right: 5px;"></i>
                    Chuyển khoản ngân hàng (QR Code)
                </label>
            </div>
        </div>
    </div>

    <div class="checkout-right-col">
        <div class="checkout-summary">
            <h3>Đơn hàng (${sessionScope.cart.size()} sản phẩm)</h3>

            <div class="mini-product-list">
                <c:forEach items="${sessionScope.cart}" var="item">
                    <div class="mini-item">
                        <div style="display: flex; justify-content: space-between; width: 100%;">
                            <span>
                                <b>${item.quantity}x</b> ${item.product.name}
                            </span>
                            <span style="font-weight: bold; color: #333;">
                                <fmt:formatNumber value="${item.totalPrice}" type="currency" currencySymbol="₫"/>
                            </span>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <p>Tạm tính: <span><fmt:formatNumber value="${totalMoney}" type="currency" currencySymbol="₫"/></span></p>
            <p>Phí vận chuyển: <span style="color: green;">Miễn phí</span></p>

            <p style="border-top: 1px dashed #ccc; padding-top: 10px; margin-top: 10px; font-size: 18px; font-weight: bold; color: #d0011b;">
                Tổng cộng: <span><fmt:formatNumber value="${totalMoney}" type="currency" currencySymbol="₫"/></span>
            </p>

            <button type="submit" class="btn-checkout">ĐẶT HÀNG NGAY</button>
        </div>
    </div>

</form>

<jsp:include page="../WEB-INF/tags/footer.jsp" />

</body>
</html>