package com.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.entities.User;
import com.springboot.web.services.UserService;

@RestController
@RequestMapping("/home")
public class UserController {
	@Autowired
	private UserService uService;
	@PostMapping("/create-user")
	public User addUser(@RequestBody User user)
	{
		return this.uService.addUser(user);
	}
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return this.uService.getAllUsers();
	}

}
