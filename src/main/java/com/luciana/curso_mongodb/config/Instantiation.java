package com.luciana.curso_mongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luciana.curso_mongodb.domain.User;
import com.luciana.curso_mongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
			
		// limpa o BD
		userRepository.deleteAll();
		
		
		// instanciando os usuarios e salvando no BD
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		
	}

}
