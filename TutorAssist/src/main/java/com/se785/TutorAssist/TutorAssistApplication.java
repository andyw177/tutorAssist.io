package com.se785.TutorAssist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EnableJpaRepositories("com.se785.TutorAssist.daos")
//@ComponentScan(basePackages = {"com.se785.TutorAssist.controllers", "com.se785.TutorAssist.services"})
//@EntityScan("com.se785.TutorAssist.models")  
public class TutorAssistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorAssistApplication.class, args);
	}
		
		
	

}
