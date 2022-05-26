package com.example.flitapp.mvvm.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.flitapp.mvvm.models.chat.Chat;
import com.example.flitapp.mvvm.models.chat.Message;
import com.example.flitapp.mvvm.models.repositories.MessageRepository;

import java.util.ArrayList;

public class OpenedChatViewModel extends ViewModel {
    private MessageRepository repository = MessageRepository.getInstance();

    private MutableLiveData<ArrayList<Message>> currentConversation;
    private int currentChatId = 0;

    public void setCurrentChatId(int id) {
        currentChatId = id;
    }

    public void sendMessage(String text) {
        repository.addMessage(text, 1, 12);
    }

    public MutableLiveData<ArrayList<Message>> getMessages(View view) {
        if (currentConversation == null) {
            currentConversation = new MutableLiveData<ArrayList<Message>>();
        }
        currentConversation.setValue(repository.getMessagesByChatId(currentChatId));

        return currentConversation;
    }
}
