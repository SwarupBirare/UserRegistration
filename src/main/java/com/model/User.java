package com.model;

public class User {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String email;
    private String city;

    // Default constructor
    public User() {}

    // Parameterized constructor
    public User(int id, String name, int age, String gender, String phone, String email, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.city = city;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // toString method (optional, for debugging)
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender
                + ", phone=" + phone + ", email=" + email + ", city=" + city + "]";
    }
}
