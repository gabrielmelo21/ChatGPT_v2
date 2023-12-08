package com.connection.chatgpt.controllers;


import com.connection.chatgpt.services.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gpt")
public class ChatGPTController {

    @Autowired
    ChatGPTService chatGPTService;


    @PostMapping
    public String requestToGpt(@RequestBody String prompt){
        return chatGPTService.gptConnection(prompt);
    }

}
