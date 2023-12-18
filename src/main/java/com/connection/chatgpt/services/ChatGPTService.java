package com.connection.chatgpt.services;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
@AllArgsConstructor
public class ChatGPTService {

    public String gptConnection(String prompt) {

        String openaiApiKey = "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";
        String openaiEndpoint = "https://api.openai.com/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + openaiApiKey);

        List<Map<String, String>> messages = new ArrayList<>();
        messages.add(createMessage("system", "You are a chatbot."));
        messages.add(createMessage("user", prompt));

        Map<String, Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("messages", messages);
        requestBodyMap.put("model", "gpt-3.5-turbo");

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBodyMap, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(openaiEndpoint, HttpMethod.POST, requestEntity, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            String responseBody = responseEntity.getBody();

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);
                String content = jsonNode.path("choices").get(0).path("message").path("content").asText();

                return content;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Erro na chamada da API OpenAI. Código de status: " + responseEntity.getStatusCodeValue());
            return "Error";
        }
        return "";
    }

    private Map<String, String> createMessage(String role, String content) {
        Map<String, String> message = new HashMap<>();
        message.put("role", role);
        message.put("content", content);
        return message;
    }
}