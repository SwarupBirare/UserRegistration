<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.model.User" %>
<%
    User user = (User) request.getAttribute("user");

    if (user == null) {
%>
    <h3>User not found. Please <a href="login.jsp">login</a> first.</h3>
<%
    } else {
%>
<html>
<head><title>My Profile</title></head>
<body>
    <h2>My Profile</h2>
    <p><strong>Name:</strong> <%= user.getName() %></p>
    <p><strong>Email:</strong> <%= user.getEmail() %></p>
    <p><strong>Phone:</strong> <%= user.getPhone() %></p>
    <p><strong>Address:</strong> <%= user.getAddress() %></p>
    <p><strong>Age:</strong> <%= user.getAge() %></p>

    <a href="update.jsp?id=<%= user.getId() %>">Edit Profile</a> |
    <a href="index.jsp">Home</a>
</body>
</html>
<%
    }
%>
