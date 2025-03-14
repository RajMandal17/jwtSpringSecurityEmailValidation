package com.demo.jwtSpringSecurityEmailValidation;

import com.demo.jwtSpringSecurityEmailValidation.role.Role;
import com.demo.jwtSpringSecurityEmailValidation.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JwtSpringSecurityEmailValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecurityEmailValidationApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository) {
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(Role.builder().name("USER").build());
			}
		};
	}
}
