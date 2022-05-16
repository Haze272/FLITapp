package com.example.flitapp.mvvm.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flitapp.R;
import com.example.flitapp.databinding.ActualTasksBinding;
import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.viewModels.SearchTasksViewModel;
import com.example.flitapp.mvvm.views.adapters.SearchTasksAdapter;

import java.util.ArrayList;

public class SearchTasksFragment extends Fragment {
    private SearchTasksViewModel viewModel;
    private ActualTasksBinding binding;
    private RecyclerView recyclerView;
    private SearchTasksAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.actual_tasks, container, false);
        viewModel = new ViewModelProvider(this).get(SearchTasksViewModel.class);
        binding = ActualTasksBinding.bind(v);

        final Observer<ArrayList<Task>> nameObserver = new Observer<ArrayList<Task>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<Task> order) {
                adapter = new SearchTasksAdapter(order,requireContext(), viewModel);
                recyclerView.setAdapter(adapter);
            }
        };
        recyclerView = binding.actualTasksRecyclerView;

        viewModel.getActualTasks(v).observe(getViewLifecycleOwner(), nameObserver);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        return v;
    }
}
