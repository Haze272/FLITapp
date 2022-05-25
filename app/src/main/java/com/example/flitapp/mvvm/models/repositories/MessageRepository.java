package com.example.flitapp.mvvm.models.repositories;

import com.example.flitapp.mvvm.models.chat.Message;

import java.util.ArrayList;

public class MessageRepository {
    private static MessageRepository instance;
    private int messageId = 22800000;

    public ArrayList<Message> messages = new ArrayList<>();

    public MessageRepository() {
        fillConversationWithStartMessage();
    }

    public static MessageRepository getInstance() {
        if (instance == null) {
            instance = new MessageRepository();
        }
        return instance;
    }


    public void addMessage(String text, int authorId, int receiverId) {
        messages.add(new Message(messageId, text, authorId, receiverId));
        this.messageId++;
    }

    public ArrayList<Message> getConversationByUserId(int userId) {
        ArrayList<Message> conversation = new ArrayList<>();

        for (Message message : messages) {
            if (message.getAuthorId() == userId || message.getReceiverId() == userId) {
                conversation.add(message);
            }
        }

        return conversation;
    }

    private void fillConversationWithStartMessage() {
        addMessage("Дарова! Мне очень понравился твой проект!", 12, 1);
    }
}
