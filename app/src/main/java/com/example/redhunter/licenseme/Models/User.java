package com.example.redhunter.licenseme.Models;

/**
 * Created by RedHunter on 3/14/2017.
 */

public class User {
    private String username;
    private String email;

    public User(String useremail) {
        this.email=useremail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
