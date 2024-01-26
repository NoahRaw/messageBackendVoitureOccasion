package com.example.mdbspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "chat_rooms")
public class ChatRoom {
    @Id
    private String id;
    private String name;
    private List<Integer> users; // Vous pouvez utiliser ObjectId si vous préférez.

    // Getters and setters

    public ChatRoom(String id, String name, List<Integer> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    // Constructors
    public ChatRoom() {
    }

    public ChatRoom(String name, List<Integer> users) {
        this.name = name;
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }
}
