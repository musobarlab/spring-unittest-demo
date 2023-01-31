package com.wuriyanto.demo.entity;

public class RegisterResponse {
    
    private String fullName;
    private String email;

    public RegisterResponse(User user) {
        this.fullName = user.getFullName();
        this.email = user.getEmail();
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }
}
