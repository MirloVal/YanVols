package com.Jonet.YanVols;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class YanVolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(YanVolsApplication.class, args);
		System.out.println("hola");
	}

}
