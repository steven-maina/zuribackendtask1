package com.jpaturial.jpaturorial;

import com.jpaturial.jpaturorial.Entities.User;
import com.jpaturial.jpaturorial.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaturorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaturorialApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository){
		return args -> {
			User user =new User(
					"stevenmboko",
					true,
					"Hi there , I'm Steven Maina. FullStack I’m currently working on my skills i backed using spring boot java",
					25
			);
			userRepository.save(user);
		};
}
}
