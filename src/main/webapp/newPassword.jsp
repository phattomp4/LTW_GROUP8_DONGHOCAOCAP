<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đặt lại mật khẩu</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/newPassword.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body>

<div class="login-container">
    <div class="login-box">
        <h2 class="login-title">Đặt Lại Mật Khẩu</h2>
        <p class="description">Vui lòng nhập mật khẩu mới cho tài khoản của bạn.</p>

        <form action="<c:url value='/newPassword'/>" method="post">

            <div class="input-group">
                <label for="newPassword">Mật khẩu mới</label>
                <input type="password" id="newPassword" name="newPassword" placeholder="Nhập mật khẩu mới" required>
            </div>

            <div class="input-group">
                <label for="confirmPassword">Xác nhận mật khẩu</label>
                <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Nhập lại mật khẩu mới" required>
            </div>

            <c:if test="${not empty error}">
                <p class="error-msg">
                    <i class="fa-solid fa-triangle-exclamation"></i> ${error}
                </p>
            </c:if>

            <button type="submit" class="login-button">Cập nhật mật khẩu</button>
        </form>
    </div>
</div>

</body>
</html>