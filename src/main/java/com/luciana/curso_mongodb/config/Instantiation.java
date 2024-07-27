package com.luciana.curso_mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luciana.curso_mongodb.domain.Post;
import com.luciana.curso_mongodb.domain.User;
import com.luciana.curso_mongodb.dto.AuthorDTO;
import com.luciana.curso_mongodb.dto.CommentDTO;
import com.luciana.curso_mongodb.repositories.PostRepository;
import com.luciana.curso_mongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
			
		// configurando data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		// limpa o BD
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		
		// instanciando os usuarios e salvando no BD
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		
		// instanciando os posts e salvando no bd
		Post post1 = new Post(null, sdf.parse("21/03/2024"), "Partiu viagem!", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2024"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		
		// referenciando os post nos usuarios
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		
		// instanciando os comentarios
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2024"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2024"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um otimo dia!", sdf.parse("23/03/2024"), new AuthorDTO(alex));
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
