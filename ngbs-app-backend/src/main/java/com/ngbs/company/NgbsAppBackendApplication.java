package com.ngbs.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NgbsAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgbsAppBackendApplication.class, args);
		System.out.println("server is working on 8080");

	}

}
