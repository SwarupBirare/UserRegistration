package com.controller;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUpdateForm extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        UserDAO dao = new UserDAOImpl();
        User user = dao.getById(id);

        out.print("<head>");
		out.print("<link rel='stylesheet' href='./CSS/Form.css'>");
		out.print("</head>");
        out.println("<html><body>");
        out.println("<h1>Update User</h1>");
        out.println("<form action='update' method='get'>");
        out.println("ID: <input type='text' name='id' value='" + user.getId() + "' readonly><br>");
        out.println("Name: <input type='text' name='name' value='" + user.getName() + "'><br>");
        out.println("Age: <input type='text' name='age' value='" + user.getAge() + "'><br>");
        out.println("Gender: <input type='text' name='gender' value='" + user.getGender() + "'><br>");
        out.println("Phone: <input type='text' name='phone' value='" + user.getPhone() + "'><br>");
        out.println("Email: <input type='text' name='email' value='" + user.getEmail() + "'><br>");
        out.println("City: <input type='text' name='city' value='" + user.getCity() + "'><br>");
        out.println("<input type='submit' value='Update'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
