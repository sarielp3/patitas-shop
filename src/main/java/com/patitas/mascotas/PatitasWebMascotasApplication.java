package com.patitas.mascotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.patitas.mascotas")
@EntityScan("com.patitas.mascotas.models")
@EnableJpaRepositories("com.patitas.mascotas.repositories")
public class PatitasWebMascotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatitasWebMascotasApplication.class, args);
	}

}
