package com.example.flitapp.mvvm.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.example.flitapp.mvvm.models.Task;

import java.util.ArrayList;
import java.util.HashMap;

public interface DisplayTasksViewModel {
    public HashMap<String, String> getTagColors();
}
