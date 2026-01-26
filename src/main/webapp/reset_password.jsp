<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đặt lại mật khẩu</title>
    <link rel="stylesheet" href="assets/css/login.css">
</head>
<body>
<div class="login-container">
    <div class="login-box">
        <h2 class="login-title">Đặt Mật Khẩu Mới</h2>
        <p style="color: red; text-align: center;">${requestScope.mess}</p>

        <form action="reset-password" method="POST">
            <input type="hidden" name="token" value="${requestScope.token}">

            <div class="input-group">
                <label>Mật khẩu mới:</label>
                <input type="password" name="password" required>
            </div>
            <div class="input-group">
                <label>Nhập lại mật khẩu:</label>
                <input type="password" name="repassword" required>
            </div>
            <button type="submit" class="login-button">Xác Nhận</button>
        </form>
    </div>
</div>
</body>
</html>