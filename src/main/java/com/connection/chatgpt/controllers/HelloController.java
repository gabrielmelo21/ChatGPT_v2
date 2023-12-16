package com.connection.chatgpt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Hello Chat GPT API "; // + port;
    }
}
