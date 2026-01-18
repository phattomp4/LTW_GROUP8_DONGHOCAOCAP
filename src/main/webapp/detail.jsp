<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${p.name} - Chi tiết sản phẩm</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/TrangChiTietSanPham.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">

    <style>
        /* CSS sửa nhanh cho ảnh không bị vỡ */
        .Main-image-container img { max-width: 100%; height: auto; }
        .Body { display: flex; gap: 30px; margin: 20px auto; max-width: 1200px; }
        @media (max-width: 768px) { .Body { flex-direction: column; } }
    </style>
</head>
<body>

<jsp:include page="WEB-INF/tags/header.jsp"></jsp:include>

<div class="product-detail-container" style="margin-top: 150px; display: flex; gap: 30px; padding: 0 10%;">

    <div class="product-images" style="width: 50%;">
        <div class="main-image" style="margin-bottom: 10px;">
            <img src="${p.imageList.size() > 0 ? p.imageList[0] : p.imageUrl}"
                 id="mainImg" alt="${p.name}" style="width: 100%; border-radius: 8px;">
        </div>

        <div class="thumbnail-list" style="display: flex; gap: 10px; overflow-x: auto;">
            <c:forEach items="${p.imageList}" var="img">
                <img src="${img}"
                     onclick="document.getElementById('mainImg').src='${img}'"
                     style="width: 80px; height: 80px; object-fit: cover; cursor: pointer; border: 1px solid #ddd; border-radius: 4px;">
            </c:forEach>
        </div>
    </div>

    <div class="product-info" style="width: 50%;">
        <h1 style="font-size: 24px; margin-bottom: 10px;">${p.name}</h1>
        <p style="color: #666;">Mã SP: <strong>${p.sku}</strong> | Tình trạng: <strong>${p.stockQuantity > 0 ? 'Còn hàng' : 'Hết hàng'}</strong></p>

        <div class="price-box" style="margin: 20px 0;">
                <span style="color: #d0011b; font-size: 28px; font-weight: bold;">
                    <fmt:formatNumber value="${p.currentPrice}" type="currency" currencySymbol="₫"/>
                </span>
            <span style="text-decoration: line-through; color: #888; margin-left: 15px;">
                    <fmt:formatNumber value="${p.originalPrice}" type="currency" currencySymbol="₫"/>
                </span>
        </div>

        <p class="desc" style="line-height: 1.6; margin-bottom: 20px;">${p.description}</p>

        <div class="actions">
            <a href="add-to-cart?pid=${p.id}" class="btn-buy"
               style="background: #d0011b; color: white; padding: 15px 40px; text-decoration: none; font-weight: bold; border-radius: 5px; display: inline-block;">
                MUA NGAY
            </a>
        </div>


        <div class="specs-table" style="margin-top: 40px;">
            <h3 style="border-bottom: 2px solid #ddd; padding-bottom: 10px;">THÔNG SỐ KỸ THUẬT</h3>
            <table style="width: 100%; border-collapse: collapse; margin-top: 15px;">
                <tr style="border-bottom: 1px solid #eee;"><td style="padding: 10px; font-weight: bold;">Thương hiệu</td><td>${p.specifications['Thương hiệu']}</td></tr>
                <tr style="border-bottom: 1px solid #eee;"><td style="padding: 10px; font-weight: bold;">Xuất xứ</td><td>${p.specifications['Xuất xứ']}</td></tr>
                <tr style="border-bottom: 1px solid #eee;"><td style="padding: 10px; font-weight: bold;">Đối tượng</td><td>${p.specifications['Đối tượng']}</td></tr>
                <tr style="border-bottom: 1px solid #eee;"><td style="padding: 10px; font-weight: bold;">Chống nước</td><td>${p.specifications['Chống nước']}</td></tr>
                <tr style="border-bottom: 1px solid #eee;"><td style="padding: 10px; font-weight: bold;">Loại máy</td><td>${p.specifications['Loại máy']}</td></tr>
                <tr style="border-bottom: 1px solid #eee;"><td style="padding: 10px; font-weight: bold;">Chất liệu kính</td><td>${p.specifications['Chất liệu kính']}</td></tr>
                <tr style="border-bottom: 1px solid #eee;"><td style="padding: 10px; font-weight: bold;">Chất liệu dây</td><td>${p.specifications['Chất liệu dây']}</td></tr>
                <tr style="border-bottom: 1px solid #eee;"><td style="padding: 10px; font-weight: bold;">Đường kính mặt</td><td>${p.specifications['Đường kính mặt']}</td></tr>
                <tr style="border-bottom: 1px solid #eee;"><td style="padding: 10px; font-weight: bold;">Size mặt</td><td>${p.specifications['Size mặt']}</td></tr>
                <tr style="border-bottom: 1px solid #eee;"><td style="padding: 10px; font-weight: bold;">Độ dày</td><td>${p.specifications['Độ dầy']}</td></tr>
            </table>
        </div>

    </div>
</div>

<jsp:include page="WEB-INF/tags/footer.jsp"></jsp:include>
</body>
</html>