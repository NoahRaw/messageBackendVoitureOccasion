package com.example.mdbspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mdbspringboot.model.ChatRoom;
import com.example.mdbspringboot.repository.ChatRoomRepository;

import java.util.List;

@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    @Autowired
    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    public List<ChatRoom> getAllChatRooms() {
        return chatRoomRepository.findAll();
    }

    public ChatRoom getChatRoomById(String id) {
        return chatRoomRepository.findById(id).orElse(null);
    }

    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }

    public void deleteChatRoomById(String id) {
        chatRoomRepository.deleteById(id);
    }

    public List<ChatRoom> getChatRoomsByUserIds(List<Integer> userIds) {
        return chatRoomRepository.findByUsersIn(userIds);
    }
}