<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 17/12/2025
  Time: 11:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <form action="<c:url value="/verifyOTP"/>" method="post">
        <h3>Verify OTP</h3>
        <p>${message}</p>
        <input type="text" name="otp" placeholder="6-Digit Code" required>
        <button type="submit">Verify</button>
        <p style="color:red;">${error}</p>
    </form>
</head>
<body>

</body>
</html>
