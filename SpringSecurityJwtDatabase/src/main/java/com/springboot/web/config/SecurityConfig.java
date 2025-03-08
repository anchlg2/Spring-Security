package com.springboot.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springboot.web.security.JwtAuthenticationEntryPoint;
import com.springboot.web.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {


    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;
    @Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpRequest) throws Exception {
httpRequest.csrf(csrf->csrf.disable()).
cors(cors->cors.disable()).
authorizeHttpRequests(auth->auth.requestMatchers("/home/users").
		authenticated().requestMatchers("/home/create-user").permitAll().
		requestMatchers("/auth/login").permitAll().
		anyRequest().authenticated()).exceptionHandling(ex -> ex.authenticationEntryPoint(point))
.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
httpRequest.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
return httpRequest.build();
		

    }
    @Bean 
    public DaoAuthenticationProvider daoAuthenticationProvider()
    {
    	DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
    	daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    	return daoAuthenticationProvider;
    }

}
