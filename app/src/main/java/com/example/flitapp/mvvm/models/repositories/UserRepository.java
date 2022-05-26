package com.example.flitapp.mvvm.models.repositories;

import android.util.SparseArray;

import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UserRepository {
    private static UserRepository instance;

    private TaskRepository taskRepository = TaskRepository.getInstance();

    public List<User> users = new ArrayList<>();
    private int userCounter = 1;

    public HashMap<Integer, HashSet<Task>> favoriteTasksOfUser = new HashMap<>();
    public HashMap<Integer, HashSet<Task>> responseTasksOfUser = new HashMap<>();
    public HashMap<Integer, HashSet<Task>> doneTasksOfUser = new HashMap<>();

    public UserRepository() {
        makeMockUser();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void putTaskToFavorite(int userId, Task task) {
        if (favoriteTasksOfUser.containsKey(userId)) {
            favoriteTasksOfUser.get(userId).add(task);
        } else {
            favoriteTasksOfUser.put(userId, new HashSet<>());
            favoriteTasksOfUser.get(userId).add(task);
        }
    }

    public ArrayList<Task> getFavoriteTasks(int userId) {
        ArrayList<Task> favoriteTasks = null;

        if (favoriteTasksOfUser.containsKey(userId)) {
            favoriteTasks = new ArrayList<>(favoriteTasksOfUser.get(userId));
        }

        return favoriteTasks;
    }

    public void putTaskToResponses(int userId, Task task) {
        if (!responseTasksOfUser.containsKey(userId)) {
            responseTasksOfUser.put(userId, new HashSet<>());
        }
        responseTasksOfUser.get(userId).add(task);
    }

    public ArrayList<Task> getResponseTasks(int userId) {
        ArrayList<Task> responseTasks = null;

        if (responseTasksOfUser.containsKey(userId)) {
            responseTasks = new ArrayList<>(responseTasksOfUser.get(userId));
        }

        return responseTasks;
    }

    public void putTaskToDone(int userId, Task task) {
        if (!doneTasksOfUser.containsKey(userId)) {
            doneTasksOfUser.put(userId, new HashSet<>());
        }
        doneTasksOfUser.get(userId).add(task);
    }

    public ArrayList<Task> getDoneTasks(int userId) {
        ArrayList<Task> doneTasks = null;

        if (doneTasksOfUser.containsKey(userId)) {
            doneTasks = new ArrayList<>(doneTasksOfUser.get(userId));
        }

        return doneTasks;
    }

    public User getUserById(int userId) {
        User requiredUser = null;

        for (User user : users) {
            if (user.getId() == userId) {
                requiredUser = user;
            }
        }

        return requiredUser;
    }

    public void makeMockUser() {
        User user = new User(userCounter, "Степан", "Беркунов", new Date(), 0, 0);
        users.add(user);
        userCounter++;

        User customer1 = new User(12, "Андрей", "Карпатченко", new Date(), 0, 4);
        users.add(customer1);
        userCounter++;

        User customer2 = new User(13, "Олег", "Губин", new Date(), 0, 110);
        users.add(customer2);
        userCounter++;

        Task task1 = new Task(3, "Скрипт регистрации", "20 000", new String[]{"javascript", "typescript"}, "Сделать front-end скрипт", new Date());
        taskRepository.tasks.add(task1);
        putTaskToDone(1, task1);
    }

}
