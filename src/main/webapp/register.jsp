<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 17/12/2025
  Time: 2:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="POST">
    <label for="username">Tên đăng nhập:</label>
    <input type="text" name="username" id="username" required>

    <label for="password">Mật khẩu:</label>
    <input type="password" name="password" id="password" required>

    <label for="confirm_password">Xác nhận Mật khẩu:</label>
    <input type="password" name="confirm_password" id="confirm_password" required>

    <button type="submit">Hoàn tất Đăng Ký</button>
</form>
</body>
</html>
