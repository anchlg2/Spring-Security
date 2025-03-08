package com.springboot.web.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.entities.User;
import com.springboot.web.services.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	

	@Autowired
	private UserService uService;
	@GetMapping("/users")
public List<User> getUser()
{return this.uService.getAllUsers();
}
	@GetMapping("/currentUser")
	public String getLoggedInUser(Principal principal)
	{
		return principal.getName();
	}
}
