package com.example.mdbspringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mdbspringboot.model.Message;

public interface MessageRepository extends MongoRepository<Message, String> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}
