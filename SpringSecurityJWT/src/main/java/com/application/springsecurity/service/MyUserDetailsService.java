package com.application.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.application.springsecurity.model.User;
import com.application.springsecurity.model.UserPrincipal;
import com.application.springsecurity.repo.UserRepo;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepo userrepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userrepo.findByEmail(email);
		
		if(user == null) {
			System.out.println("User Not found");
			throw new UsernameNotFoundException("user not find");
		}
		
		return new UserPrincipal(user);
	}
	


}
