package com.wuriyanto.demo.service;

import com.wuriyanto.demo.entity.RegisterRequest;
import com.wuriyanto.demo.entity.User;

public interface IUserService {
    
    public User register(RegisterRequest userRequest);

    public User getUser(String email);
    
}
