package com.wuriyanto.demo.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wuriyanto.demo.entity.User;

@Repository
@Transactional
public interface UserRepository extends IGenericRepository<User, UUID> {
    
    public User findByEmail(String email);
}
