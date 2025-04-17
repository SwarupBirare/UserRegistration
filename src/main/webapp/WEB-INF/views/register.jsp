<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Register</title>
</head>
<body>
	<h2>User Registration</h2>
	<form action="${pageContext.request.contextPath}/saveUser"
		method="post">
		Name: <input type="text" name="name" required><br> Email:
		<input type="email" name="email" required><br> Password:
		<input type="password" name="password" required><br>
		Phone: <input type="text" name="phone" required><br>
		Address: <input type="text" name="address" required><br>
		Age: <input type="number" name="age" required><br> <input
			type="submit" value="Register">
	</form>
	<a href="${pageContext.request.contextPath}/">Back to Home</a>

</body>
</html>
