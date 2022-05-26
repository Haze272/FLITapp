package com.example.flitapp.mvvm.models.repositories;

import com.example.flitapp.mvvm.models.chat.Chat;
import com.example.flitapp.mvvm.models.chat.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class MessageRepository {
    private static MessageRepository instance;
    private int messageId = 22800000;
    private int chatId = 390000;

    public ArrayList<Chat> chats = new ArrayList<>();

    public MessageRepository() {
        fillMockChats();
    }

    public static MessageRepository getInstance() {
        if (instance == null) {
            instance = new MessageRepository();
        }
        return instance;
    }


    public void addMessage(String text, int authorId, int receiverId) {
        for (Chat chat : chats) {
            if ((chat.getInitiatorId() == authorId && chat.getReceiverId() == receiverId) ||
                    (chat.getInitiatorId() == receiverId && chat.getReceiverId() == authorId)) {
                Message message = new Message(messageId, text, authorId, receiverId);
                messageId++;
                chat.addMessage(message);
                return;
            }
        }
        Chat chat = new Chat(chatId, authorId, receiverId);
        chatId++;
        Message message = new Message(messageId, text, authorId, receiverId);
        messageId++;
        chat.addMessage(message);
        chats.add(chat);
    }

    public ArrayList<Chat> getChatsByUserId(int id) {
        HashSet<Chat> userChats = new HashSet<>();

        for (Chat chat : chats) {
            if (chat.getReceiverId() == 1 || chat.getInitiatorId() == 1) {
                userChats.add(chat);
            }
        }

        return new ArrayList<>(userChats);
    }

    public ArrayList<Message> getMessagesByChatId(int id) {
        ArrayList<Message> conversation = new ArrayList<>();

        for (Chat chat : chats) {
            if (chat.getId() == id) {
                conversation.addAll(chat.getMessages());
            }
        }

        return conversation;
    }

    public int getAuthorIdByChatId(int id) {
        int result = 0;

        for (Chat chat : chats) {
            if (chat.getId() == id) {
                if (chat.getInitiatorId() == 1) {
                    result = chat.getReceiverId();
                } else if (chat.getReceiverId() == 1) {
                    result = chat.getInitiatorId();
                }
            }
        }

        return result;
    }

    private void fillMockChats() {
        addMessage("Привет!", 12, 1);
        addMessage("И тебе не хворать", 1, 12);
        addMessage("Ку!",13, 1);
        addMessage("И тебе того же", 1, 13);
    }
}
