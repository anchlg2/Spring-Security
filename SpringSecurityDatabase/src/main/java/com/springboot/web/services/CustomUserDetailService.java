package com.springboot.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.web.dao.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailsService{
	@Autowired
private UserRepository uRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //this will get username from userDetails
		// TODO Auto-generated method stub
		return this.uRepo.findByEmail(username);
	}
	//use of userDetailService is to load users by username ,so in SpringSecuritydatabase ,UserDetailsService will load users using userrepo in spring security
//loadUserByUsername method is used to fetch users in spring security by username , so it will load users using UserRepo
}
