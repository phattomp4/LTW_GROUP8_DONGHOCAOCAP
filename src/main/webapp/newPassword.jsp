<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reset Password</title>
</head>
<body>
<div style="text-align: center; margin-top: 50px;">
    <h2>Reset Your Password</h2>

    <%-- Display error messages if passwords don't match or update fails --%>
    <% if (request.getAttribute("error") != null) { %>
    <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>

    <form action="<c:url value="/newPassword"/>" method="post">
        <label>New Password:</label><br>
        <input type="password" name="newPassword" required><br><br>

        <label>Confirm Password:</label><br>
        <input type="password" name="confirmPassword" required><br><br>

        <button type="submit">Reset Password</button>
    </form>
</div>
</body>
</html>