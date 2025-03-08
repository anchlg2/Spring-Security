package com.springboot.web.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.web.dao.UserRepository;
import com.springboot.web.entities.User;

@Service
public class UserService {
	@Autowired
private UserRepository uRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public User addUser(User user)
	{
		user.setUserId(UUID.randomUUID().toString());
		user.setPasswords(passwordEncoder.encode(user.getPasswords()));
		return this.uRepository.save(user);
	}
	public List<User> getAllUsers()
	{
		return this.uRepository.findAll();
	}
	
}
