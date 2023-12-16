package com.connection.chatgpt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@SpringBootApplication
public class ChatgptApplication {

	public static void main(String[] args) {
		// Use a porta fornecida pelo ambiente do Heroku, ou 8080 se não estiver definida
		String port = System.getenv("PORT");
		if (port == null || port.isEmpty()) {
			port = "8080";
		}

		// Configuração da porta e inicialização do aplicativo
		SpringApplication app = new SpringApplication(ChatgptApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		app.run(args);
	}
}

