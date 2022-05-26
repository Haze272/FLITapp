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
import com.example.flitapp.databinding.ActualTasksBinding;
import com.example.flitapp.databinding.MessagesListBinding;
import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.models.chat.Chat;
import com.example.flitapp.mvvm.viewModels.MessagesViewModel;
import com.example.flitapp.mvvm.viewModels.SearchTasksViewModel;
import com.example.flitapp.mvvm.views.adapters.DisplayChatsAdapter;
import com.example.flitapp.mvvm.views.adapters.DisplayTasksAdapter;

import java.util.ArrayList;

public class MessagesListFragment extends Fragment {
    private MessagesViewModel viewModel;
    private MessagesListBinding binding;
    private RecyclerView recyclerView;
    private DisplayChatsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.messages_list, container, false);
        viewModel = new ViewModelProvider(this).get(MessagesViewModel.class);
        binding = MessagesListBinding.bind(v);

        final Observer<ArrayList<Chat>> nameObserver = new Observer<ArrayList<Chat>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<Chat> chat) {
                adapter = new DisplayChatsAdapter(chat, requireContext(), viewModel);
                recyclerView.setAdapter(adapter);
            }
        };
        recyclerView = binding.chatsRecyclerView;

        viewModel.getChats(v).observe(getViewLifecycleOwner(), nameObserver);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        return v;
    }
}
