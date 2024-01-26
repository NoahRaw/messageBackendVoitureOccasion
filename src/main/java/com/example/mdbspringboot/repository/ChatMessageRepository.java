package com.example.mdbspringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mdbspringboot.model.ChatMessage;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findByRoomId(String roomId);

    List<ChatMessage> findByUserId(String roomId);

    List<ChatMessage> findByRoomIdOrderByTimestampAsc(String roomId);
}