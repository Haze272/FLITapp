package com.example.flitapp.mvvm.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flitapp.R;
import com.example.flitapp.mvvm.viewModels.TaskViewModel;
import com.example.flitapp.databinding.FragmentTaskBinding;


public class FragmentTask extends Fragment {
    private TaskViewModel task;
    private FragmentTaskBinding binding;

    public FragmentTask() {}

    public static FragmentTask newInstance() {
        return new FragmentTask();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        task = new ViewModelProvider(this).get(TaskViewModel.class);
        task.giveTask("");

        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentTaskBinding.bind(view);

        task.getMyTask().observe(getViewLifecycleOwner(), task1 -> {
            binding.taskHeader.setText(task1.getHeader());
            binding.taskPrice1.setText(task1.getPrice());
            binding.textView13.setText(task1.getDescription());
        });
    }

}