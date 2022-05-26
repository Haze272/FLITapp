package com.example.flitapp.mvvm.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.flitapp.mvvm.models.chat.Chat;
import com.example.flitapp.mvvm.models.repositories.MessageRepository;
import com.example.flitapp.mvvm.models.repositories.UserRepository;

import java.util.ArrayList;

public class MessagesViewModel extends ViewModel {
    private MessageRepository messageRepository = MessageRepository.getInstance();
    private UserRepository userRepository = UserRepository.getInstance();

    private MutableLiveData<ArrayList<Chat>> currentChats;

    public MutableLiveData<ArrayList<Chat>> getChats(View view) {
        if (currentChats == null) {
            currentChats = new MutableLiveData<ArrayList<Chat>>();
        }
        currentChats.setValue(messageRepository.getChatsByUserId(1));

        return currentChats;
    }

    public String getAuthorById(int id) {
        String authorName = "";
        authorName = userRepository.getUserById(id).getFirstName();
        return authorName;
    }

}
