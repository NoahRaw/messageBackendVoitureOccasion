package com.example.mdbspringboot.model;

public class Conversation {
    private String image;
    private int userId;
    private String name;
    private boolean active;
    private boolean isOnline;
    private String email;

    // Constructeur par défaut
    public Conversation() {
    }

    // Constructeur avec paramètres
    public Conversation(String image, int userId, String name, boolean active, boolean isOnline) {
        this.image = image;
        this.userId = userId;
        this.name = name;
        this.active = active;
        this.isOnline = isOnline;
    }

    public Conversation(String image, int userId, String name, boolean active, boolean isOnline, String email) {
        this.image = image;
        this.userId = userId;
        this.name = name;
        this.active = active;
        this.isOnline = isOnline;
        this.email = email;
    }

    // Getters et Setters
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "image='" + image + '\'' +
                ", id=" + userId +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", isOnline=" + isOnline +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

