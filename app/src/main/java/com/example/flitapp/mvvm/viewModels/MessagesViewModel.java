package com.example.flitapp.mvvm.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.flitapp.mvvm.models.chat.Chat;
import com.example.flitapp.mvvm.models.chat.Message;
import com.example.flitapp.mvvm.models.repositories.MessageRepository;

import java.util.ArrayList;

public class MessagesViewModel extends ViewModel {
    private MessageRepository repository = MessageRepository.getInstance();

    private MutableLiveData<ArrayList<Chat>> currentChats;
    private MutableLiveData<ArrayList<Message>> currentConversation;

    public MutableLiveData<ArrayList<Chat>> getChats(View view) {
        if (currentChats == null) {
            currentChats = new MutableLiveData<ArrayList<Chat>>();
        }
        currentChats.setValue(repository.getChatsByUserId(1));

        return currentChats;
    }
}
