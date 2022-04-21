package com.example.flitapp.mvvm.repositories;

import android.os.Build;

import com.example.flitapp.mvvm.models.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    public List<Task> tasks = new ArrayList<>();

    public TaskRepository() {
        String taskHeader = "Сайт под ключ";
        String taskPrice = "30 000 руб";
        String[] taskTags = {"HTML", "CSS", "JavaScript"};
        String taskDesc = "Мужики! Нужен толковый парень для сайта автомастерской!!";
        Task task = new Task(taskHeader, taskPrice, taskTags, taskDesc);
        tasks.add(task);
    }

    public Task getTaskByHeader(String header){
        Task result = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            result = tasks.stream().filter(user -> user.getHeader().equals(header)).findFirst().get();
        }
        return result;
    }
}
