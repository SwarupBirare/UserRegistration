<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h2>User Login</h2>
	<form action="${pageContext.request.contextPath}/loginUser"
		method="post">

		Email: <input type="email" name="email" required><br>
		Password: <input type="password" name="password" required><br>
		<input type="submit" value="Login">
	</form>
	<a href="index.jsp">Back to Home</a>
</body>
</html>
