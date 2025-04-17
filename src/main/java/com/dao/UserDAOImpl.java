package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.model.User;
import com.utility.DBUtility;

public class UserDAOImpl implements UserDAO {

    public UserDAOImpl() {
    }

    @Override
    public int add(User user) {
        int i = 0;
        String sql = "INSERT INTO USERS (id, name, age, gender, phone, email, city) VALUES(?,?,?,?,?,?,?)";
        try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setInt(3, user.getAge());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getCity());

            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("UserDAOImpl add " + e);
        }
        return i;
    }

    @Override
    public int delete(int id) {
        int i = 0;
        String sql = "DELETE FROM USERS WHERE id=?";
        try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("UserDAOImpl delete " + e);
        }
        return i;
    }

    @Override
    public int update(User user) {
        int i = 0;
        String sql = "UPDATE USERS SET name=?, age=?, gender=?, phone=?, email=?, city=? WHERE id=?";
        try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getCity());
            ps.setInt(7, user.getId());

            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("UserDAOImpl update " + e);
        }
        return i;
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM USERS WHERE id=?";
        try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                return user;
            }
        } catch (Exception e) {
            System.out.println("UserDAOImpl getById " + e);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM USERS";
        try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(user);
            }
        } catch (Exception e) {
            System.out.println("UserDAOImpl getAll " + e);
        }
        return list;
    }

    @Override
    public List<User> searchByName(String name) {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM USERS WHERE name LIKE ?";
        try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(user);
            }
        } catch (Exception e) {
            System.out.println("UserDAOImpl searchByName " + e);
        }
        return list;
    }

    @Override
    public List<User> searchByCity(String city) {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM USERS WHERE city LIKE ?";
        try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + city + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(user);
            }
        } catch (Exception e) {
            System.out.println("UserDAOImpl searchByCity " + e);
        }
        return list;
    }

    @Override
    public List<User> sortByAge() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM USERS ORDER BY age ASC";
        try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(user);
            }
        } catch (Exception e) {
            System.out.println("UserDAOImpl sortByAge " + e);
        }
        return list;
    }

    @Override
    public List<User> sortByGender() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM USERS ORDER BY gender ASC";
        try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(user);
            }
        } catch (Exception e) {
            System.out.println("UserDAOImpl sortByGender " + e);
        }
        return list;
    }
}
