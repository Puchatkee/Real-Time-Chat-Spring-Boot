package com.puchatkee.chat.controller;

import com.puchatkee.chat.model.ChatMessage;
import com.puchatkee.chat.repository.ChatMessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageRestController {

    private final ChatMessageRepository repo;

    public MessageRestController(ChatMessageRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<ChatMessage> getAll() {
        return repo.findAll();
    }
}
