package com.multiple;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultipleDatabasesApplication {

	
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(MultipleDatabasesApplication.class, args);
	}

}
