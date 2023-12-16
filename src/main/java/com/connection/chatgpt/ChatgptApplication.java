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
		SpringApplication.run(ChatgptApplication.class, args);
	}
}