<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css">
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

        <c:if test="${not empty success}">
            <div class="success-msg">
                <i class="fa-solid fa-circle-check"></i> ${success}
            </div>
        </c:if>

        <c:if test="${not empty errorMessage}">
            <div class="error-msg">
                <i class="fa-solid fa-circle-exclamation"></i> ${errorMessage}
            </div>
        </c:if> <br>

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
                <a href="javascript:void(0);" onclick="checkUsernameBeforeReset()" class="forgot-password">Quên mật khẩu?</a>            </div>



            <button type="submit" class="login-button">Đăng Nhập</button>
        </form>


        <form action="${pageContext.request.contextPath}/register" method="POST">

        <p class="register-link">
            Chưa có tài khoản? <a href="register.jsp">Đăng ký ngay</a>
        </p>
        </form>

    </div>
</div>
<script>
        function checkUsernameBeforeReset() {
        // Lấy giá trị trong ô input username
        var userField = document.getElementById("username");
        var username = userField.value.trim();

        if (username === "") {
        // Nếu trống thì báo lỗi và không cho đi tiếp
        alert("Vui lòng nhập Tên đăng nhập để chúng tôi xác định tài khoản cần khôi phục!");
        userField.style.borderColor = "red"; // Làm nổi bật ô lỗi
        userField.focus();
    } else {
        // Nếu đã nhập, chuyển hướng sang trang forgot-password và đính kèm username lên URL
        window.location.href = "${pageContext.request.contextPath}/forgot-password?username=" + encodeURIComponent(username);
    }
    }
</script>
</body>
</html>