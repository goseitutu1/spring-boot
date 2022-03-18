package com.example.testApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = "com.example.testApp.student")
@ComponentScan(basePackages = "com.example.testApp")
@SpringBootApplication
public class TestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAppApplication.class, args);
	}

}
