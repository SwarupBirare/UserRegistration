package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.User;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String city = request.getParameter("city");

			User user = new User(id, name, age, gender, phone, email, city);
			UserDAO dao = new UserDAOImpl();

			int res = dao.update(user);
			if (res > 0) {
				out.print("<h1>UPDATE SUCCESSFUL</h1>");
			} else {
				out.print("<h1>UPDATE FAILED</h1>");
			}
			RequestDispatcher rd = request.getRequestDispatcher("read");
			rd.include(request, response);
		} catch (Exception e) {
			out.print("<h1>Error: UpdateServlet: </h1>" + e);
			e.printStackTrace();
		}
	}
}
