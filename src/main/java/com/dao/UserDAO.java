package com.dao;

import com.model.User;
import java.util.List;

public interface UserDAO {
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
    User getUserById(int id);
    List<User> getAllUsers();
}
