package com.controller;

import com.dao.UserDAOImpl;
import com.dao.UserDAO;
import com.model.User;
import com.util.DBConnection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Connection;
import java.util.List;

@Controller
public class UserController {
    private UserDAO userDAO;

    public UserController() {
        Connection conn = DBConnection.getConnection();
        this.userDAO = new UserDAOImpl(conn);
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // This will resolve to /WEB-INF/views/register.jsp
    }

    @GetMapping("/userList")
    public String listUsers(Model model) {
        List<User> users = userDAO.getAllUsers();
        model.addAttribute("userList", users);
        return "userList"; // This will resolve to /WEB-INF/views/userList.jsp
    }

    @GetMapping("/addUser")
    public String showAddUserPage() {
        return "addUser"; // This will resolve to /WEB-INF/views/addUser.jsp
    }

    @PostMapping("/saveUser")
    public String saveUser(User user) {
        boolean result;
        if (user.getId() == 0) {
            result = userDAO.addUser(user);
        } else {
            result = userDAO.updateUser(user);
        }
        
        if (result) {
            return "redirect:/userList"; // After saving, redirect to userList
        } else {
            return "error"; // In case of error, show error page
        }
    }

    @GetMapping("/editUser")
    public String showEditUserPage(int id, Model model) {
        User user = userDAO.getUserById(id);
        model.addAttribute("user", user);
        return "editUser"; // This will resolve to /WEB-INF/views/editUser.jsp
    }

    @GetMapping("/deleteUser")
    public String deleteUser(int id) {
        userDAO.deleteUser(id);
        return "redirect:/userList"; // After deleting, redirect to userList
    }
}
