<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/login.css">
    <!-- Linking Font Awesome-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <title>Đăng nhập</title>
</head>
<body>

<div class="login-container">
    <div class="back-home">
        <a href="index.jsp" class="back-home-button">
            <i class="fa-solid fa-arrow-left"></i> Quay về Trang chủ
        </a>
    </div>
    
    <div class="login-box">
        <h2 class="login-title">Đăng Nhập Tài Khoản</h2>
        <form action="${pageContext.request.contextPath}/login" method="POST">

            <div class="input-group">
                <label for="username">Tên đăng nhập hoặc Email</label>
                <input type="text" id="username" name="username" placeholder="Nhập tên đăng nhập hoặc email" required>
            </div>

            <div class="input-group">
                <label for="password">Mật khẩu</label>
                <input type="password" id="password" name="password" placeholder="Nhập mật khẩu" required>
            </div>

            <div class="options-group">
                <label>
                    <input type="checkbox" name="remember"> Ghi nhớ đăng nhập
                </label>
                <a href="forgot_password.html" class="forgot-password">Quên mật khẩu?</a>
            </div>



            <div class="login-button">
<%--                <a href="html_da_dang_nhap/index.jsp">Đăng Nhập</a>--%>
                <button type="submit"> Dang nhap</button>
            </div>
        </form>

        <p class="register-link">
            Chưa có tài khoản? <a href="register.jsp">Đăng ký ngay</a>
        </p>
    </div>
</div>
</body>
</html>