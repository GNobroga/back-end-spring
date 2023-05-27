package com.gabriel.crudapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gabriel.crudapi.models.Course;
import com.gabriel.crudapi.repository.CourseRepository;

/*
 * 
 * 	Quando o Spring executar ele ira executar tambem o CommandLineRunner anotado com @Bean
 * 
 */
@SpringBootApplication
public class CrudApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApiApplication.class, args);
	}
	
	/*
	 * 
	 *  O Spring vai injetar a dependencia e executar o CommandLineRunner
	 */
	/* 
	@Bean
	public CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();
			
			Course c = new Course(null, "Engenharia Mecanica", 500D);

			courseRepository.save(c);
		};
	}
	*/

}
