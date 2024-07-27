package com.luciana.curso_mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciana.curso_mongodb.domain.User;
import com.luciana.curso_mongodb.repositories.UserRepository;
import com.luciana.curso_mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	// buscar todos os Users
	public List<User> findAll() {
		return repository.findAll();
	}
	
	
	// buscar User por id
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
