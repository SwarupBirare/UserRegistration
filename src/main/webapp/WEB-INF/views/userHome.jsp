<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.model.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<html>
<head><title>User Home</title></head>
<body>
    <h2>Welcome, <%= user.getName() %>!</h2>
    <p>Email: <%= user.getEmail() %></p>
    <p>Phone: <%= user.getPhone() %></p>
    <p>Address: <%= user.getAddress() %></p>
    <p>Age: <%= user.getAge() %></p>

    <a href="${pageContext.request.contextPath}/editUser?id=<%= user.getId() %>">Update Profile</a> |
    <a href="${pageContext.request.contextPath}/deleteUser?id=<%= user.getId() %>">Delete Account</a>
</body>
</html>
