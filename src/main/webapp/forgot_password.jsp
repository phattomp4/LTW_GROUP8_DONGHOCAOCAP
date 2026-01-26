<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu</title>
    <link rel="stylesheet" href="assets/css/login.css"> </head>
<body>
<div class="login-container">
    <div class="login-box">
        <h2 class="login-title">Quên Mật Khẩu</h2>

        <p style="color: ${requestScope.type == 'success' ? 'green' : 'red'}; text-align: center;">
            ${requestScope.mess}
        </p>

        <form action="forgot-password" method="POST">
            <div class="input-group">
                <label>Nhập Email đã đăng ký:</label>
                <input type="email" name="email" placeholder="example@gmail.com" required>
            </div>
            <button type="submit" class="login-button">Gửi Yêu Cầu</button>
        </form>

        <p class="register-link"><a href="login.jsp">Quay lại Đăng nhập</a></p>
    </div>
</div>
</body>
</html>