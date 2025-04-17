package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.*;
import com.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			int id = Integer.parseInt(request.getParameter("id"));

			UserDAO dao = new UserDAOImpl();
			int res = dao.delete(id);

			if (res > 0) {
				out.print("<h1>SUCCESS DELETE!!!</h1>");
			} else {
				out.print("<h1>FAILED TO DELETE!!!</h1>");
			}

			RequestDispatcher rd = request.getRequestDispatcher("read");
			rd.include(request, response);

		} catch (Exception e) {
			out.print("<h1>Error: DeleteServlet: </h1>" + e);
			e.printStackTrace();
		}
	}
}
