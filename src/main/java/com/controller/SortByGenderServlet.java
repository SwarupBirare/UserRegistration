package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.User;

public class SortByGenderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SortByGenderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		UserDAO dao = new UserDAOImpl();
		List<User> list = dao.sortByGender();

		Iterator<User> itr = list.iterator();

		out.print("<head>");
		out.print("<link rel='stylesheet' href='./CSS/Read.css'>");
		out.print("</head>");

		out.print("<h2>Users Sorted by Gender</h2>");
		out.print("<table id='customers'>");
		out.print("<tr>");
		out.print("<th>ID</th>");
		out.print("<th>Name</th>");
		out.print("<th>Age</th>");
		out.print("<th>Gender</th>");
		out.print("<th>Phone</th>");
		out.print("<th>Email</th>");
		out.print("<th>City</th>");
		out.print("</tr>");

		while (itr.hasNext()) {
			User user = itr.next();
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
		out.print("<br><a href='user.html'><button>Back</button></a>");
	}
}
