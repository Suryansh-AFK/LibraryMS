package com.library.Models;

public class User {
    private String name;
    private String userId;
    private String userEmail;
    private String password;

    public User(String name, String userId, String userEmail, String password) {
        this.name = name;
        this.userId = userId;
        this.userEmail = userEmail;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", UserId: " + userId);
    }
}