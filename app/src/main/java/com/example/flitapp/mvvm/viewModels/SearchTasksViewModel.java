package com.example.flitapp.mvvm.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.models.repositories.TagRepository;
import com.example.flitapp.mvvm.models.repositories.TaskRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchTasksViewModel extends ViewModel {
    private TaskRepository taskRepository = TaskRepository.getInstance();
    private TagRepository tagRepository = TagRepository.getInstance();

    private MutableLiveData<ArrayList<Task>> currentTask;

    public MutableLiveData<ArrayList<Task>> getActualTasks(View v) {
        if (currentTask == null) {
            currentTask = new MutableLiveData<ArrayList<Task>>();
        }
        currentTask.setValue(taskRepository.getLatestTasks());

        return currentTask;
    }

    public HashMap<String, String> getTagColors() {
        return tagRepository.getTagsColors();
    }
}
