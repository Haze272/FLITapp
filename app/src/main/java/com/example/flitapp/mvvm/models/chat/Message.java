package com.example.flitapp.mvvm.models.chat;

import java.util.Date;

public class Message {
    private int id;
    private String textMessage;
    private Date date;
    private int authorId, receiverId;

    public Message(int id, String textMessage, int authorId, int receiverId) {
        this.id = id;
        this.textMessage = textMessage;
        this.authorId = authorId;
        this.receiverId = receiverId;

        this.date = new Date();
    }

    public String getTextMessage() {
        return textMessage;
    }

    public Date getDate() {
        return date;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReceiverId() {
        return receiverId;
    }
}
