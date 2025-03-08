package com.springboot.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.entities.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, String> {
public User  findByEmail(String email);
}
