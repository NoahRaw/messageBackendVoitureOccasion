package com.example.mdbspringboot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mdbspringboot.model.ChatRoom;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    @Query("{'users': { $all: ?0 }}")
    List<ChatRoom> findByUsersIn(List<Integer> users);
}
