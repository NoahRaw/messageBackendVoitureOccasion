package com.example.mdbspringboot.model;

import java.util.Date;

public class MessageAffichage {
    private int key;
    private String image;
    private String type;
    private String msg;
    private String timestamp;

    // Constructeur par défaut nécessaire pour la désérialisation JSON
    public MessageAffichage() {}

    public MessageAffichage(int key, String image, String type, String msg) {
        this.key = key;
        this.image = image;
        this.type = type;
        this.msg = msg;
    }

    public MessageAffichage(int key, String image, String type, String msg, String timestamp) {
        this.key = key;
        this.image = image;
        this.type = type;
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
