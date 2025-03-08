package com.springboot.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//this file is main file for spring security
@Configuration   //Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime, 
public class MyConfig {
	//inmemory user method
@Bean  // this annotation Indicates that a method produces a bean to be managed by the Spring container.
public UserDetailsService userDetailsService()
{// we store in userDetails becuase UserDetails is parent of User , so we can use UserDetails reference to store user
	UserDetails uDetails=User.builder().username("Tanya").password(passwordEncoder().encode("Tanya")).roles("Admin").build();
	UserDetails uDetails2=User.builder().username("Rihan").password(passwordEncoder().encode("Rihan")).roles("User").build();
	return new InMemoryUserDetailsManager(uDetails,uDetails2);
	//UserDetails uses loadUserbyUserName method of UserDetailsService to fetch the user
}
@Bean
public PasswordEncoder passwordEncoder()
{
	return new BCryptPasswordEncoder();
}
@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
    return builder.getAuthenticationManager();
}
}
