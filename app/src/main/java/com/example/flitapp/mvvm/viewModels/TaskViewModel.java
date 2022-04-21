package com.example.flitapp.mvvm.viewModels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.repositories.TaskRepository;

public class TaskViewModel extends ViewModel {

    private MutableLiveData<Task> myTask = new MutableLiveData<>();
    private TaskRepository repo;

    public void giveTask(String header) {
        myTask.setValue(repo.getTaskByHeader(header));
    }

    public MutableLiveData<Task> getMyTask() {
        return myTask;
    }
}