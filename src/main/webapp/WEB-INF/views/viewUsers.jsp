<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*, com.model.User"%>
<%
List<User> userList = (List<User>) request.getAttribute("users");
%>
<html>
<head>
<title>All Users</title>
</head>
<body>
	<h2>User List</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Age</th>
			<th>Action</th>
		</tr>
		<%
		for (User u : userList) {
		%>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getName()%></td>
			<td><%=u.getEmail()%></td>
			<td><%=u.getPhone()%></td>
			<td><%=u.getAge()%></td>
			<td><a href="${pageContext.request.contextPath}/editUser?id=${user.id}">Edit</a>
				<a href="${pageContext.request.contextPath}/deleteUser?id=${user.id}">Delete</a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
