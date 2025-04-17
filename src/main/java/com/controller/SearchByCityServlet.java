package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.User;

public class SearchByCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchByCityServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String city = request.getParameter("city");

		UserDAO dao = new UserDAOImpl();
		List<User> users = dao.searchByCity(city); // You’ll create this method

		out.print("<h1>Search Results for City: " + city + "</h1>");

		if (users != null && !users.isEmpty()) {
			out.print("<head>");
			out.print("<link rel='stylesheet' href='./CSS/Read.css'>");
			out.print("</head>");
			out.print("<table id='customers' border='1'>");
			out.print("<tr><th>ID</th><th>Name</th><th>Age</th><th>Gender</th><th>Phone</th><th>Email</th><th>City</th></tr>");

			for (User user : users) {
				out.print("<tr>");
				out.print("<td>" + user.getId() + "</td>");
				out.print("<td>" + user.getName() + "</td>");
				out.print("<td>" + user.getAge() + "</td>");
				out.print("<td>" + user.getGender() + "</td>");
				out.print("<td>" + user.getPhone() + "</td>");
				out.print("<td>" + user.getEmail() + "</td>");
				out.print("<td>" + user.getCity() + "</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		} else {
			out.print("<h2>No users found in city: " + city + "</h2>");
		}

		out.print("<br><a href='user.html'><button>Back</button></a>");
	}
}
