package com.example.flitapp.mvvm.models.chat;

import java.util.ArrayList;
import java.util.Date;

public class Chat {
    private int id;
    private int initiatorId, receiverId;
    private Date lastUpdated;
    private ArrayList<Message> messages;

    public Chat(int id, int initiatorId, int receiverId) {
        this.id = id;
        this.initiatorId = initiatorId;
        this.receiverId = receiverId;

        this.lastUpdated = new Date();
        this.messages = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(int initiatorId) {
        this.initiatorId = initiatorId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Message getLastMessage() {
        return this.messages.get(messages.size()-1);
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}

