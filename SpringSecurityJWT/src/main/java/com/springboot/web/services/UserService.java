package com.springboot.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.web.entities.User;
@Service
public class UserService {
	private List<User> users=new ArrayList<>();
public UserService()
{
	users.add(new User("123","Anchal","avaish123@gmail.com"));
	users.add(new User("456","Tara","tara123@gmail.com"));
	users.add(new User("789","Ria","ria123@gmail.com"));
	users.add(new User("098","Sia","Sia123@gmail.com"));
}
public List<User> getAllUsers()
{
	return users;
}
}
