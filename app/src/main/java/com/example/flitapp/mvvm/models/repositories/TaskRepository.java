package com.example.flitapp.mvvm.models.repositories;

import android.os.Build;

import com.example.flitapp.mvvm.models.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static TaskRepository instance;

    public List<Task> tasks = new ArrayList<>();

    public TaskRepository() {}

    public static TaskRepository getInstance() {
        if (instance == null) {
            instance = new TaskRepository();
        }
        return instance;
    }

    public Task getTaskByHeader(String header){
        Task result = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            result = tasks.stream().filter(user -> user.getHeader().equals(header)).findFirst().get();
        }
        return result;
    }
}
