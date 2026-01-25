<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm sản phẩm mới | Admin</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <style>
        body { font-family: 'Segoe UI', sans-serif; display: flex; margin: 0; background: #f4f6f9; }
        /* Sidebar giữ nguyên */
        .sidebar { width: 250px; background: #343a40; color: white; min-height: 100vh; position: fixed; padding-top: 20px;}
        .sidebar a { display: block; padding: 15px 20px; color: #c2c7d0; text-decoration: none; border-bottom: 1px solid #4b545c; }
        .sidebar a:hover { background: #d0011b; color: white; }

        .content { margin-left: 250px; padding: 30px; width: 100%; }
        .form-container { background: white; padding: 30px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); max-width: 900px; margin: 0 auto; }

        .form-section { margin-bottom: 30px; border-bottom: 1px dashed #ddd; padding-bottom: 20px; }
        .form-section h3 { color: #1b6e76; margin-bottom: 15px; font-size: 18px; text-transform: uppercase; }

        .form-row { display: flex; gap: 20px; margin-bottom: 15px; }
        .form-group { flex: 1; }
        .form-group label { display: block; margin-bottom: 5px; font-weight: 600; font-size: 14px; }
        .form-control { width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }

        .btn-save { background: #28a745; color: white; padding: 12px 25px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; font-weight: bold; }
        .btn-save:hover { background: #218838; }
    </style>
</head>
<body>

<div class="sidebar">
    <h2 style="text-align:center; color:#d0011b;">VVP ADMIN</h2>
    <a href="dashboard"><i class="fa-solid fa-gauge"></i> Tổng quan</a>
    <a href="product-manager" class="active"><i class="fa-solid fa-box"></i> Quản lý Sản phẩm</a>
    <a href="user-manager"><i class="fa-solid fa-users"></i> Quản lý Khách hàng</a>
</div>

<div class="content">
    <div class="form-container">
        <h2 style="margin-top: 0;">THÊM SẢN PHẨM MỚI</h2>

        <form action="product-form" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${product.id}">

            <div class="form-section">
                <h3>1. Thông tin chung</h3>
                <div class="form-group">
                    <label>Tên sản phẩm:</label>
                    <input type="text" name="name" class="form-control" value="${product.name}" required>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label>Mã SKU:</label>
                        <input type="text" name="sku" class="form-control" value="${product.sku}" required>
                    </div>
                    <div class="form-group">
                        <label>Số lượng kho:</label>
                        <input type="number" name="stock" class="form-control" value="${product.stockQuantity}" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label>Giá gốc (vnđ):</label>
                        <input type="number" name="originalPrice" class="form-control"
                               value="${empty product ? '' : Double.valueOf(product.originalPrice).longValue()}" required>
                    </div>
                    <div class="form-group">
                        <label>Giá bán (vnđ):</label>
                        <input type="number" name="price" class="form-control"
                               value="${empty product ? '' : Double.valueOf(product.currentPrice).longValue()}" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group" style="background: #fff3cd; padding: 10px; border-radius: 5px; border: 1px solid #ffeeba;">
                        <label style="color: #856404; font-weight: bold;">Tùy chọn hiển thị:</label>
                        <div style="display: flex; align-items: center; gap: 10px; margin-top: 5px;">
                            <input type="checkbox" id="isLuxury" name="isLuxury" value="true"
                                   style="width: 20px; height: 20px;"
                            ${product != null && product.isLuxury() ? 'checked' : ''}>

                            <label for="isLuxury" style="margin: 0; cursor: pointer;">
                                Đánh dấu là <strong>Sản phẩm Luxury</strong> (Hiển thị nổi bật trang chủ)
                            </label>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-section">
                <h3>2. Hình ảnh</h3>
                <div class="form-row">
                    <div class="form-group">
                        <label style="color: #d0011b;">Ảnh Đại Diện:</label>
                        <c:if test="${not empty product.imageUrl}">
                            <div style="margin-bottom: 5px;">
                                <img src="${product.imageUrl.startsWith('http') ? product.imageUrl : pageContext.request.contextPath.concat('/').concat(product.imageUrl)}"
                                     style="height: 80px; border: 1px solid #ddd; padding: 2px;">
                            </div>
                        </c:if>
                        <input type="file" name="mainImage" class="form-control" accept="image/*">
                        <small>Chỉ chọn nếu muốn thay đổi ảnh đại diện.</small>
                    </div>

                    <div class="form-group">
                        <label>5 Ảnh chi tiết:</label>
                        <c:if test="${not empty detailImages}">
                            <div style="margin-bottom: 5px; display: flex; gap: 5px; flex-wrap: wrap;">
                                <c:forEach items="${detailImages}" var="img">
                                    <img src="${img.startsWith('http') ? img : pageContext.request.contextPath.concat('/').concat(img)}"
                                         style="height: 60px; border: 1px solid #ddd;">
                                </c:forEach>
                            </div>
                        </c:if>
                        <input type="file" name="detailImages" class="form-control" accept="image/*" multiple>
                        <small>Chọn lại để thay thế toàn bộ ảnh phụ cũ.</small>
                    </div>
                </div>
            </div>

            <div class="form-section">
                <h3>3. Thông số kỹ thuật</h3>

                <div class="form-row">
                    <div class="form-group">
                        <label>Thương hiệu:</label>
                        <input type="hidden" name="specName" value="Thương hiệu">
                        <input type="text" name="specValue" class="form-control" value="${specMap['Thương hiệu']}">
                    </div>
                    <div class="form-group">
                        <label>Xuất xứ:</label>
                        <input type="hidden" name="specName" value="Xuất xứ">
                        <input type="text" name="specValue" class="form-control" value="${specMap['Xuất xứ']}">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label>Đối tượng:</label>
                        <input type="hidden" name="specName" value="Đối tượng">
                        <select name="specValue" class="form-control">
                            <option value="Nam" ${specMap['Đối tượng'] == 'Nam' ? 'selected' : ''}>Nam</option>
                            <option value="Nữ" ${specMap['Đối tượng'] == 'Nữ' ? 'selected' : ''}>Nữ</option>
                            <option value="Cặp đôi" ${specMap['Đối tượng'] == 'Cặp đôi' ? 'selected' : ''}>Cặp đôi</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Chống nước:</label>
                        <input type="hidden" name="specName" value="Chống nước">
                        <input type="text" name="specValue" class="form-control" value="${specMap['Chống nước']}">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label>Loại máy:</label>
                        <input type="hidden" name="specName" value="Loại máy">
                        <input type="text" name="specValue" class="form-control" value="${specMap['Loại máy']}">
                    </div>
                    <div class="form-group">
                        <label>Chất liệu kính:</label>
                        <input type="hidden" name="specName" value="Chất liệu kính">
                        <input type="text" name="specValue" class="form-control" value="${specMap['Chất liệu kính']}">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label>Chất liệu dây:</label>
                        <input type="hidden" name="specName" value="Chất liệu dây">
                        <input type="text" name="specValue" class="form-control" value="${specMap['Chất liệu dây']}">
                    </div>
                    <div class="form-group">
                        <label>Đường kính mặt:</label>
                        <input type="hidden" name="specName" value="Đường kính mặt">
                        <input type="text" name="specValue" class="form-control" value="${specMap['Đường kính mặt']}">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label>Size mặt:</label>
                        <input type="hidden" name="specName" value="Size mặt">
                        <input type="text" name="specValue" class="form-control" value="${specMap['Size mặt']}">
                    </div>
                    <div class="form-group">
                        <label>Độ dày:</label>
                        <input type="hidden" name="specName" value="Độ dày">
                        <input type="text" name="specValue" class="form-control" value="${specMap['Độ dày']}">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label>Mô tả chi tiết bài viết:</label>
                <textarea name="description" class="form-control" rows="5">${product.description}</textarea>
            </div>

            <div style="margin-top: 20px; text-align: right;">
                <a href="product-manager" class="btn-back">Hủy bỏ</a>
                <button type="submit" class="btn-save">
                    <i class="fa-solid fa-floppy-disk"></i> ${empty product ? 'Lưu sản phẩm' : 'Cập nhật'}
                </button>
            </div>
        </form>
    </div>
</div>

</body>
</html>