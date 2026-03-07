package com.kubernetes.demo.services;

import com.kubernetes.demo.models.Message;
import com.kubernetes.demo.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message sendMessage(Message message){
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages(){
        return (List<Message>) messageRepository.findAll();
    }
}
