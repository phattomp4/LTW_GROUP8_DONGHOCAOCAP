<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../assets/css/header.css">
    <link rel="stylesheet" href="../assets/css/footer.css">
    <link rel="stylesheet" href="../assets/css/GioHang.css">
    <!-- Linking Font Awesome-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <title>Giỏ hàng</title>
</head>

<body>

<jsp:include page="../WEB-INF/tags/header.jsp" />

    <div class="cart-container">
        <!-- Danh sách sản phẩm -->
        <div class="product-list">
            <div class="cart-header">
                <span>Sản phẩm</span>
                <span>Tổng</span>
            </div>

            <c:if test="${empty sessionScope.cart}">
                <p style="padding: 20px;">Giỏ hàng trống.</p>
            </c:if>

            <c:forEach items="${sessionScope.cart.values()}" var="i">
                <div class="product-item">
                    <div class="item-main">
                        <img src="${i.imageUrl}" alt="${i.name}">
                        <div class="item-details">
                            <a href="#" class="product-name">${i.name}</a>
                            <div class="price-info">
                                <span class="old-price"><fmt:formatNumber value="${i.originalPrice}" pattern="#,###"/> ₫</span>
                                <span class="new-price"><fmt:formatNumber value="${i.currentPrice}" pattern="#,###"/> ₫</span>
                            </div>
                        </div>
                    </div>
                    <div class="item-total">
                        <span><fmt:formatNumber value="${i.currentPrice * i.quantity}" pattern="#,###"/> ₫</span>
                    </div>
                    <div class="item-actions">
                        <div class="quantity-selector">
                            <button type="button">-</button>
                            <input type="text" value="${i.quantity}" readonly>
                            <button type="button">+</button>
                        </div>
                        <a href="../cart?action=delete&pid=${i.id}" class="remove-link">Xóa sản phẩm</a>
                    </div>
                </div>
            </c:forEach>
        </div>

        <!-- Tổng tiền giỏ hàng -->
        <div class="summary-total">
            <span>Tổng ước tính</span>
            <span class="total-price">
        <fmt:formatNumber value="${sessionScope.totalMoney}" pattern="#,###"/> ₫
    </span>
        </div>
    </div>

<jsp:include page="../WEB-INF/tags/footer.jsp" />

    <script src="../assets/js/index.js"></script>
</body>
</html>