package com.codegym.model;

public class User {
    private String name;
    private String address;
    private int role;

    public User(String name, String address, int role) {
        this.name = name;
        this.address = address;
        this.role = role;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
