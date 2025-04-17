package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.User;

public class GetIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetIdServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			UserDAO dao = new UserDAOImpl();
			User user = dao.getById(id);

			if (user != null) {
		        out.print("<head>");
				out.print("<link rel='stylesheet' href='./CSS/Form.css'>");
				out.print("</head>");
		        out.println("<html><body>");
				out.print("<h1>User Found</h1>");
				out.print("<h3>ID: " + user.getId() + "</h3>");
				out.print("<h3>Name: " + user.getName() + "</h3>");
				out.print("<h3>Age: " + user.getAge() + "</h3>");
				out.print("<h3>Gender: " + user.getGender() + "</h3>");
				out.print("<h3>Phone: " + user.getPhone() + "</h3>");
				out.print("<h3>Email: " + user.getEmail() + "</h3>");
				out.print("<h3>City: " + user.getCity() + "</h3>");
				out.print("<br><a href='user.html'><button>Back</button></a>");
		        out.println("</body></html>");
			} else {
				out.print("<h1>User Not Found</h1>");
			}
		} catch (Exception e) {
			out.print("<h1>Error: GetByIdServlet: </h1>" + e.getMessage());
			e.printStackTrace();
		}
	}
}
