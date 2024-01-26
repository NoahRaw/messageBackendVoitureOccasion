package com.example.mdbspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mdbspringboot.model.Message;
import com.example.mdbspringboot.repository.MessageRepository;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public void saveMessage(Message message) {
        message.setTimestamp(new Date());
        messageRepository.save(message);
    }
}
