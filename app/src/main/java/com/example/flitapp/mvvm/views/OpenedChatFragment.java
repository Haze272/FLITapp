package com.example.flitapp.mvvm.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flitapp.R;
import com.example.flitapp.databinding.ChatBinding;
import com.example.flitapp.mvvm.models.chat.Chat;
import com.example.flitapp.mvvm.models.chat.Message;
import com.example.flitapp.mvvm.viewModels.MessagesViewModel;
import com.example.flitapp.mvvm.viewModels.OpenedChatViewModel;
import com.example.flitapp.mvvm.views.adapters.DisplayMessagesAdapter;

import java.util.ArrayList;

public class OpenedChatFragment extends Fragment {
    private OpenedChatViewModel viewModel;
    private ChatBinding binding;
    private RecyclerView recyclerView;
    private DisplayMessagesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.chat, container, false);
        viewModel = new ViewModelProvider(this).get(OpenedChatViewModel.class);
        binding = ChatBinding.bind(v);

        int openedId = getArguments().getInt("chatId", 0);
        viewModel.setCurrentChatId(openedId);

        final Observer<ArrayList<Message>> nameObserver = new Observer<ArrayList<Message>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<Message> messages) {
                adapter = new DisplayMessagesAdapter(messages, requireContext(), viewModel);
                recyclerView.setAdapter(adapter);
            }
        };
        recyclerView = binding.messageRecyclerView;

        viewModel.getMessages(v).observe(getViewLifecycleOwner(), nameObserver);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        ImageButton sendMessageButton = binding.chatSendMessageButton;
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageText = binding.chatMessageText.getText().toString();

                viewModel.sendMessage(messageText);
                binding.chatMessageText.setText("");
                viewModel.getMessages(v).observe(getViewLifecycleOwner(), nameObserver);
            }
        });

        return v;
    }
}
