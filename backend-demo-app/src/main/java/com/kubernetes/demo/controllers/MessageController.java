package com.kubernetes.demo.controllers;

import com.kubernetes.demo.models.Message;
import com.kubernetes.demo.services.MessageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(value = "/message/send")
    public ResponseEntity<Message> sendMessage(@Valid @RequestBody Message message){
        return ResponseEntity.ok(messageService.sendMessage(message));
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages(){
        return ResponseEntity.ok(messageService.getAllMessages());
    }

}
