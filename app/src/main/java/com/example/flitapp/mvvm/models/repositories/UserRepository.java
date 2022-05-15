package com.example.flitapp.mvvm.models.repositories;

import com.example.flitapp.mvvm.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static UserRepository instance;

    public List<User> users = new ArrayList<>();

    public UserRepository() {}

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }
}
