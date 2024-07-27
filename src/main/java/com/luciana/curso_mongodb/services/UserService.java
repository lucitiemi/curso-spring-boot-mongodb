package com.luciana.curso_mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciana.curso_mongodb.domain.User;
import com.luciana.curso_mongodb.dto.UserDTO;
import com.luciana.curso_mongodb.repositories.UserRepository;
import com.luciana.curso_mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	// busca todos os Users
	public List<User> findAll() {
		return repository.findAll();
	}
	
	
	// busca User por id
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	// insere novo User
	public User insert(User obj) {
		return repository.insert(obj);
	}

	
	// deleta um User
	public void delete(String id) {
		findById(id);					// aqui ja trata a excecao caso nao exista o id
		repository.deleteById(id);
	}
	
	
	// transforma um DTO em um User
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}


	


}
