package com.example.flitapp.mvvm.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.models.repositories.TagRepository;
import com.example.flitapp.mvvm.models.repositories.TaskRepository;
import com.example.flitapp.mvvm.models.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenedTaskViewModel extends ViewModel {
    private TaskRepository taskRepository = TaskRepository.getInstance();
    private TagRepository tagRepository = TagRepository.getInstance();
    private UserRepository userRepository = UserRepository.getInstance();
    private MutableLiveData<ArrayList<Task>> currentTask;

    public Task getAboutTask(int taskId) {
        return taskRepository.getTaskById(taskId);
    }

    public HashMap<String, String> getTagColors() {
        return tagRepository.getTagsColors();
    }

    public void addTaskToFavourite(Task task) {
        userRepository.putTaskToFavorite(1, task); // userId is 1 because I haven't done yet the auth
    }

    public void addTaskToResponses(Task task) {
        userRepository.putTaskToResponses(1, task);
    }
}
