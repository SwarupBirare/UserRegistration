package com.dao;

import java.util.List;
import com.model.User;

public interface UserDAO {
    int add(User user);
    int delete(int id);
    int update(User user);
    User getById(int id);
    List<User> getAll();
    List<User> searchByName(String name);
    List<User> searchByCity(String city);
    List<User> sortByAge();
    List<User> sortByGender();
}
