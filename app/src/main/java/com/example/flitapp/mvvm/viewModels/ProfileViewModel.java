package com.example.flitapp.mvvm.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.models.User;
import com.example.flitapp.mvvm.models.repositories.TagRepository;
import com.example.flitapp.mvvm.models.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfileViewModel extends ViewModel implements DisplayTasksViewModel{
    private UserRepository userRepository = UserRepository.getInstance();
    private TagRepository tagRepository = TagRepository.getInstance();

    private MutableLiveData<ArrayList<Task>> currentTask;

    public MutableLiveData<ArrayList<Task>> getDoneTasks(View v) {
        if (currentTask == null) {
            currentTask = new MutableLiveData<ArrayList<Task>>();
        }
        currentTask.setValue(userRepository.getDoneTasks(1));

        return currentTask;
    }

    public boolean isHasDoneTasks() {
        if (userRepository.getDoneTasks(1) == null) {
            return false;
        } else {
            return true;
        }
    }

    public HashMap<String, String> getTagColors() {
        return tagRepository.getTagsColors();
    }

    public User getAboutUser() {
        return userRepository.getUserById(1);
    }
}
