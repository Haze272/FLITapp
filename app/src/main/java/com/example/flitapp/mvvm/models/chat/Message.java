package com.example.flitapp.mvvm.models.chat;

import com.example.flitapp.mvvm.models.User;

import java.util.Date;

public class Message {
    private User author;
    private String text;
    private Date date;

    public Message(User author, String text) {
        this.author = author;
        this.text = text;
        this.date = new Date();
    }

    public User getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
}
