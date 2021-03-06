package com.certant.pokedexlite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }, scanBasePackages = { "com.certant.pokedexlite" })
public class PokedexliteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedexliteApplication.class, args);
	}

}
