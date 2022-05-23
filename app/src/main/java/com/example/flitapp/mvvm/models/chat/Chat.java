package com.example.flitapp.mvvm.models.chat;

import com.example.flitapp.mvvm.models.User;

import java.util.ArrayList;

public class Chat {
    private User firstPerson;
    private User secondPerson;
    private ArrayList<Message> messages;

    public Chat(User firstPerson, User secondPerson) {
        this.firstPerson = firstPerson;
        this.secondPerson = secondPerson;
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public User getFirstPerson() {
        return firstPerson;
    }

    public User getSecondPerson() {
        return secondPerson;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
