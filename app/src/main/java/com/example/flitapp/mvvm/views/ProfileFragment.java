package com.example.flitapp.mvvm.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flitapp.R;
import com.example.flitapp.databinding.ProfileBinding;
import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.models.User;
import com.example.flitapp.mvvm.viewModels.ProfileViewModel;
import com.example.flitapp.mvvm.views.adapters.DisplayTasksAdapter;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    private ProfileViewModel viewModel;
    private ProfileBinding binding;
    private RecyclerView recyclerView;
    private DisplayTasksAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile, container, false);
        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        binding = ProfileBinding.bind(v);

        User user = viewModel.getAboutUser();
        binding.fullName.setText(user.getFirstName() + " " + user.getSecondName());
        binding.tasksDoneAmount.setText(Integer.toString(user.getTasksDone()));
        binding.tasksCreatedAmount.setText(Integer.toString(user.getTasksCreated()));
        binding.ratingValue.setText(Double.toString(user.getRating()));

        final Observer<ArrayList<Task>> nameObserver = new Observer<ArrayList<Task>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<Task> order) {
                adapter = new DisplayTasksAdapter(order,requireContext(), viewModel);
                recyclerView.setAdapter(adapter);
            }
        };
        recyclerView = binding.profileTasksRecyclerView;
        if (viewModel.isHasDoneTasks()) {
            viewModel.getDoneTasks(v).observe(getViewLifecycleOwner(), nameObserver);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
            recyclerView.setLayoutManager(gridLayoutManager);
        } else {
            // TODO ХА-ХА! КОСТЫЛЬ!
        }



        return v;
    }
}
