package com.example.mdbspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.mdbspringboot.model.ChatMessage;
import com.example.mdbspringboot.model.ChatRoom;
import com.example.mdbspringboot.service.ChatRoomService;

import java.util.List;

@RestController
@RequestMapping("/api/chat-rooms")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @Autowired
    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @GetMapping
    public List<ChatRoom> getChatRoomsByUserIds(@RequestParam List<Integer> userIds) {
        return chatRoomService.getChatRoomsByUserIds(userIds);
    }

    @PostMapping
    public ChatRoom createChatRoom(@RequestBody ChatRoom chatRoom) {
        return chatRoomService.createChatRoom(chatRoom);
    }
}
