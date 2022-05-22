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

    public List<User> users = new ArrayList<>();
    private int userCounter = 1;

    public HashMap<Integer, HashSet<Task>> favoriteTasksOfUser = new HashMap<>();

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

    public void makeMockUser() {
        User user = new User(userCounter, "Степан", "Беркунов", new Date(), 0, 0);
        users.add(user);
        userCounter++;
    }

}
