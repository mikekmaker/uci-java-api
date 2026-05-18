package com.pv.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

		Person person = new Person("Orquestador", "IA CRP");
		System.out.println(person.sayHello());
	}

}      