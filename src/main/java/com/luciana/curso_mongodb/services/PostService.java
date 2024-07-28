package com.luciana.curso_mongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciana.curso_mongodb.domain.Post;
import com.luciana.curso_mongodb.repositories.PostRepository;
import com.luciana.curso_mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	
	// busca User por id
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	// busca Posts pelo titulo
	public List<Post> findByTitle(String title) {
		return repository.searchTitle(title);
	}
	
	
	// busca Posts por varios criterios
		public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
			maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
			return repository.fullSearch(text, minDate, maxDate);
		}

	


}
