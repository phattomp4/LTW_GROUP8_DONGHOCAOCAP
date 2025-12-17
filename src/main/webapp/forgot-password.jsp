<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 17/12/2025
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <form action="<c:url value="/forgot-password"/>" method="post">
        <h3>Forgot Password</h3>
        <input type="email" name="email" placeholder="Enter Email" required>
        <button type="submit">Send OTP</button>
    </form>
</head>
<body>

</body>
</html>
