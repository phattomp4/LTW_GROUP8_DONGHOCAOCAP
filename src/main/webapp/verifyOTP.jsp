<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xác thực OTP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/verifyOTP.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body>

<div class="login-container">
    <div class="back-home">
        <a href="forgot-password.jsp" class="back-home-button">
            <i class="fa-solid fa-arrow-left"></i> Quay lại
        </a>
    </div>

    <div class="login-box">
        <h2 class="login-title">Xác Thực OTP</h2>
        <p class="description">Mã xác thực đã được gửi đến Email của bạn.</p>

        <form action="<c:url value='/verifyOTP'/>" method="post">

            <c:if test="${not empty message}">
                <div class="info-msg">${message}</div>
            </c:if>

            <div class="input-group">
                <label for="otp">Nhập mã 6 chữ số</label>
                <input type="text" id="otp" name="otp"
                       placeholder="______" maxlength="6"
                       pattern="\d{6}" title="Vui lòng nhập đúng 6 chữ số" required>
            </div>

            <c:if test="${not empty error}">
                <p class="error-msg"><i class="fa-solid fa-circle-exclamation"></i> ${error}</p>
            </c:if>

            <button type="submit" class="login-button">Xác nhận mã</button>
        </form>

        <p class="resend-text">
            Không nhận được mã? <a href="forgot-password.jsp">Gửi lại ngay</a>
        </p>
    </div>
</div>

</body>
</html>
