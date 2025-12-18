<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/register.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <title>Đăng ký tài khoản</title>
</head>
<body>

<div class="login-container">
    <div class="back-home">
        <a href="index.jsp" class="back-home-button">
            <i class="fa-solid fa-arrow-left"></i> Quay về Trang chủ
        </a>
    </div>

    <div class="login-box">
        <h2 class="login-title">Đăng Ký Tài Khoản</h2>

        <form action="${pageContext.request.contextPath}/register" method="POST">

            <div class="input-group">
                <label for="username">Tên đăng nhập</label>
                <input type="text" id="username" name="username" placeholder="Nhập tên đăng nhập" required>
            </div>

            <div class="input-group">
                <label for="password">Mật khẩu</label>
                <input type="password" id="password" name="password" placeholder="Nhập mật khẩu" required>
            </div>

            <div class="input-group">
                <label for="confirm_password">Xác nhận mật khẩu</label>
                <input type="password" id="confirm_password" name="confirm_password" placeholder="Nhập lại mật khẩu" required>
            </div>

            <button type="submit" class="login-button" style="width: 100%; margin-top: 10px;">
                Hoàn tất Đăng Ký
            </button>
        </form>

        <p class="register-link">
            Đã có tài khoản? <a href="login.jsp">Đăng nhập ngay</a>
        </p>
    </div>
</div>
</body>
</html>