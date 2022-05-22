package com.example.flitapp.mvvm.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.models.repositories.TagRepository;
import com.example.flitapp.mvvm.models.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class FavoriteViewModel extends ViewModel implements DisplayTasksViewModel {
    private UserRepository userRepository = UserRepository.getInstance();
    private TagRepository tagRepository = TagRepository.getInstance();

    private MutableLiveData<ArrayList<Task>> currentTask;

    public MutableLiveData<ArrayList<Task>> getFavoriteTasks(View v) {
        if (currentTask == null) {
            currentTask = new MutableLiveData<ArrayList<Task>>();
        }
        currentTask.setValue(userRepository.getFavoriteTasks(1));

        return currentTask;
    }

    public boolean isHasFavoriteTasks() {
        if (userRepository.getFavoriteTasks(1) == null) {
            return false;
        } else {
            return true;
        }
    }

    public HashMap<String, String> getTagColors() {
        return tagRepository.getTagsColors();
    }
}
