package com.example.mdbspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "chat_messages")
public class ChatMessage {
    @Id
    private String id;
    private String roomId;
    private Integer userId;
    private String content;
    private Date timestamp;

    // Getters and setters

    public ChatMessage(String id, String roomId, Integer userId, String content, Date timestamp) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Constructors
    public ChatMessage() {
    }

    public ChatMessage(String roomId, Integer userId, String content, Date timestamp) {
        this.roomId = roomId;
        this.userId = userId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
