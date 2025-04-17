<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.model.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<html>
<head><title>Update User</title></head>
<body>
    <h2>Update User Details</h2>
    <form action="${pageContext.request.contextPath}/saveUser" method="post">
        <input type="hidden" name="id" value="<%= user.getId() %>">
        Name: <input type="text" name="name" value="<%= user.getName() %>" required><br>
        Email: <input type="email" name="email" value="<%= user.getEmail() %>" required><br>
        Password: <input type="password" name="password" value="<%= user.getPassword() %>" required><br>
        Phone: <input type="text" name="phone" value="<%= user.getPhone() %>" required><br>
        Address: <input type="text" name="address" value="<%= user.getAddress() %>" required><br>
        Age: <input type="number" name="age" value="<%= user.getAge() %>" required><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
