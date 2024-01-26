package com.example.mdbspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.mdbspringboot.model.ChatMessage;
import com.example.mdbspringboot.model.ChatRoom;
import com.example.mdbspringboot.model.MyToken;
import com.example.mdbspringboot.service.ChatMessageService;
import com.example.mdbspringboot.service.ChatRoomService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/chat")
public class ChatMessageController {

    private final ChatMessageService chatMessageService;
    private final ChatRoomService chatRoomService;
    private final RestTemplate restTemplate;

    @Autowired
    public ChatMessageController(ChatMessageService chatMessageService,ChatRoomService chatRoomService,RestTemplate restTemplate) {
        this.chatMessageService = chatMessageService;
        this.chatRoomService= chatRoomService;
        this.restTemplate= restTemplate;
    }

    @GetMapping
    public ResponseEntity<List<ChatMessage>> getChatMessagesByRoomId(@RequestParam List<Integer> otherUserId, HttpServletRequest request) {
        MyToken myToken=getToken(request);
        if (myToken!=null) {
            otherUserId.add(myToken.getIdutilisateur());

            List<ChatRoom> listChatRooms = chatRoomService.getChatRoomsByUserIds(otherUserId);
            System.out.println("taille=" + listChatRooms.size());

            String chatName = "chat";
            for (Integer i : otherUserId) {
                chatName = chatName + " user-" + i;
            }

            if (listChatRooms.size() > 0) {
                return ResponseEntity.ok(chatMessageService.getChatMessagesByRoomId(listChatRooms.get(0).getId()));
            }

            ChatRoom cr = chatRoomService.createChatRoom(new ChatRoom("", chatName, otherUserId));
            return ResponseEntity.ok(chatMessageService.getChatMessagesByRoomId(cr.getId()));
        }

        // Retourner une réponse avec un statut non autorisé (401) en cas de token non valide
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
    
    public MyToken getToken(HttpServletRequest request) {
        // Remplacez l'URL par l'URL réelle de votre service web
        String urlAutreService = "https://voitureoccasion-production.up.railway.app/Utilisateurs/getToken";
        
        // Remplacez "VOTRE_BEARER_TOKEN" par votre véritable jeton d'accès
        String authHeader = request.getHeader("Authorization");
        String token=null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7); // Extrait le token
            // Utilisez le token
        }

        System.out.println("token:"+token);
        
        // Créer les en-têtes de la requête
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        // Créer l'objet de demande avec les en-têtes
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Envoyer la requête avec les en-têtes et obtenir la réponse
        ResponseEntity<String> response = restTemplate.exchange(
            urlAutreService, 
            HttpMethod.GET, 
            entity, 
            String.class
        );

        // Traiter la réponse comme nécessaire
        String resultat = response.getBody();

        if (resultat==null) {
            return null;
        }

        // Convertissez le String en VotreObjet en utilisant un convertisseur (par exemple, Jackson ObjectMapper)
        MyToken myToken = convertirStringEnObjet(resultat, MyToken.class);

        return myToken;
    }

    // Méthode pour convertir un String en objet avec Jackson ObjectMapper
    private <T> T convertirStringEnObjet(String jsonString, Class<T> classe) {
        // Utilisez votre bibliothèque de sérialisation/désérialisation JSON préférée ici
        // Par exemple, avec Jackson ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonString, classe);
        } catch (IOException e) {
            // Gérer l'exception (conversion en erreur ou autre)
            throw new RuntimeException("Erreur lors de la conversion du JSON en objet", e);
        }
    }

    @PostMapping
    public ResponseEntity<ChatMessage> saveMessage(@RequestBody ChatMessage message, @RequestParam List<Integer> userToSend, HttpServletRequest request) {
        MyToken myToken=getToken(request);
        if (myToken!=null) {
            userToSend.add(myToken.getIdutilisateur());

            List<ChatRoom> listChatRooms = chatRoomService.getChatRoomsByUserIds(userToSend);

            String chatName = "chat";
            for (Integer i : userToSend) {
                chatName = chatName + " user-" + i;
            }

            ChatRoom cr = null;

            if (listChatRooms.size() > 0) {
                cr=listChatRooms.get(0);
            }
            else
            {
                cr = chatRoomService.createChatRoom(new ChatRoom("", chatName, userToSend));
            }

            message.setUserId(myToken.getIdutilisateur());
            message.setRoomId(cr.getId());

            return ResponseEntity.ok(chatMessageService.createChatMessage(message));
        }

        // Retourner une réponse avec un statut non autorisé (401) en cas de token non valide
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}
