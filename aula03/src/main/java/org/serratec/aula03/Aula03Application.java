package org.serratec.aula03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aula03Application {

	public static void main(String[] args) {
		// ler as classes criadas as anotadas com org.springframework.web.bind.annotation.*
		// inicializa os contextos
		// inicializa o TomCat
		// inicializa o hibernate (JPA) le as classes/metodos anotados com jakarta.persistence.*
		SpringApplication.run(Aula03Application.class, args);
	}

}
