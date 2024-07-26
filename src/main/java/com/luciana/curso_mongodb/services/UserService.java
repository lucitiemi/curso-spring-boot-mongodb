package com.luciana.curso_mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciana.curso_mongodb.domain.User;
import com.luciana.curso_mongodb.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	// buscar todos os Users
	public List<User> findAll() {
		return repository.findAll();
	}
	
	

}
