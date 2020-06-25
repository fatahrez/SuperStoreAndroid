package com.moringaschool.asuper.models;

public class User {

    private int id;
    private String email, password, username, first_name, last_name;

    public User(int id, String email, String password, String username, String first_name, String last_name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
