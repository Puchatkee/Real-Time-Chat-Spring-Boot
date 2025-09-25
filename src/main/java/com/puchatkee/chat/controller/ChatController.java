package com.puchatkee.chat.controller;

import com.puchatkee.chat.model.ChatMessage;
import com.puchatkee.chat.repository.ChatMessageRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class ChatController {
    private final ChatMessageRepository repo;


    public ChatController(ChatMessageRepository repo) {
        this.repo = repo;
    }


    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        message.setTimestamp(LocalDateTime.now());
        return repo.save(message);
    }
    @GetMapping("chat")
    public String chat() {
        return "chat";
    }
}
