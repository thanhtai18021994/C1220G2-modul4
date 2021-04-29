package com.example.model;

public class User {
    private String account;
    private String password;
    private String name;
    private String email;
    private int age;

    public User() {
    }

    public User(String acount, String password, String name, String email, int age) {
        this.account = acount;
        this.password = password;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getAcount() {
        return account;
    }

    public void setAccount(String acount) {
        this.account = acount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
