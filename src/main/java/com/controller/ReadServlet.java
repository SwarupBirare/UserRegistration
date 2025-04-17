package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.model.*;

public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		UserDAO dao = new UserDAOImpl();
		List<User> list = dao.getAll();
		Iterator<User> itr = list.iterator();

		out.print("<head>");
		out.print("<link rel='stylesheet' href='./CSS/Read.css'>");
		out.print("</head>");
		out.print("<table id='customers'>");
		out.print("<tr>");
		out.print("<th>ID</th>");
		out.print("<th>Name</th>");
		out.print("<th>Age</th>");
		out.print("<th>Gender</th>");
		out.print("<th>Phone</th>");
		out.print("<th>Email</th>");
		out.print("<th>City</th>");
		out.print("<th>Update</th>");
		out.print("<th>Delete</th>");
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
			out.print("<td><a href='UserUpdateForm?id=" + user.getId() + "'>UPDATE</a></td>");
			out.print("<td><a href='delete?id=" + user.getId() + "'>DELETE</a></td>");
			out.print("</tr>");
		}

		out.print("</table>");
	}
}
