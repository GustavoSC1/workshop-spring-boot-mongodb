package com.gustavo.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gustavo.workshopmongo.domain.User;
import com.gustavo.workshopmongo.repository.UserRepository;

@Configuration
//Executa partes específicas de código quando um aplicativo é iniciado. CommandLineRunner é uma interface usada para indicar que 
//um bean deve ser executado quando estiver contido em um SpringApplication.  
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	// O CommandLineRunner requer a implementação de um método (run) que recebe por parâmetro uma matriz de String.
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		
	}

}
