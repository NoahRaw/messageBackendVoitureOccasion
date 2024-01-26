package com.example.mdbspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mdbspringboot.model.ChatMessage;
import com.example.mdbspringboot.repository.ChatMessageRepository;

import java.util.Date;
import java.util.List;

@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public List<ChatMessage> getAllChatMessages() {
        return chatMessageRepository.findAll();
    }

    public List<ChatMessage> getChatMessagesByRoomId(String roomId) {
        return chatMessageRepository.findByRoomIdOrderByTimestampAsc(roomId);
    }

    public ChatMessage createChatMessage(ChatMessage chatMessage) {
        chatMessage.setTimestamp(new Date());
        return chatMessageRepository.save(chatMessage);
    }

    public void deleteChatMessageById(String id) {
        chatMessageRepository.deleteById(id);
    }
}
