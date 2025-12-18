<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên mật khẩu</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/forgot-password.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body>

<div class="login-container">
    <div class="back-home">
        <a href="login.jsp" class="back-home-button">
            <i class="fa-solid fa-arrow-left"></i> Quay lại Đăng nhập
        </a>
    </div>

    <div class="login-box">
        <h2 class="login-title">Quên Mật Khẩu</h2>
        <p class="description">Nhập email của bạn để nhận mã OTP xác thực.</p>

        <form action="<c:url value='/forgot-password'/>" method="post">
            <div class="input-group">
                <label for="email">Email đăng ký</label>
                <input type="email" id="email" name="email" placeholder="example@gmail.com" required>
            </div>

            <c:if test="${not empty error}">
                <p class="error-msg">${error}</p>
            </c:if>

            <button type="submit" class="login-button">Gửi mã OTP</button>
        </form>
    </div>
</div>

</body>
</html>