package com.application.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.springsecurity.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	public User findByEmail(String email);

	public User findByUsername(String username);
}
