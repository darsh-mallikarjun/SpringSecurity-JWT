package com.application.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.springsecurity.model.User;
import com.application.springsecurity.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	private BCryptPasswordEncoder Bpassword = new BCryptPasswordEncoder(12);
	
	public User register(User user) {
		user.setPassword(Bpassword.encode(user.getPassword()));
		return userRepo.save(user);
		
	}

}
