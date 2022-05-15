package com.example.flitapp.mvvm.viewModels;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.models.repositories.TaskRepository;

import java.util.ArrayList;

public class SearchTasksViewModel extends ViewModel {
    private TaskRepository repository = TaskRepository.getInstance();

    private MutableLiveData<ArrayList<Task>> currentTask;

    public MutableLiveData<ArrayList<Task>> getActualTasks(View v) {
        if (currentTask == null) {
            currentTask = new MutableLiveData<ArrayList<Task>>();
        }
        currentTask.setValue(repository.getLatestTasks());

        return currentTask;
    }
}
