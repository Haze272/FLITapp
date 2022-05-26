package com.example.flitapp.mvvm.views.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flitapp.R;
import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.models.chat.Chat;
import com.example.flitapp.mvvm.viewModels.DisplayTasksViewModel;
import com.example.flitapp.mvvm.viewModels.MessagesViewModel;
import com.example.flitapp.mvvm.views.OpenedChatFragment;
import com.example.flitapp.mvvm.views.OpenedTaskFragment;

import java.util.ArrayList;
import java.util.List;

public class DisplayChatsAdapter extends RecyclerView.Adapter<DisplayChatsAdapter.DisplayChatsViewHolder> {
    private MessagesViewModel viewModel;

    private ArrayList<Chat> chatList;
    Context context;

    public DisplayChatsAdapter(ArrayList<Chat> data, Context context, MessagesViewModel messagesViewModel) {
        this.chatList = data;
        this.context = context;
        this.viewModel = messagesViewModel;
    }

    @NonNull
    @Override
    public DisplayChatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.chat_tile, parent, false);
        return new DisplayChatsAdapter.DisplayChatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayChatsViewHolder holder, int position) {
        final Chat tempChat = chatList.get(position);

        holder.chatId = tempChat.getId();

        holder.name.setText(Integer.toString(tempChat.getInitiatorId()));
        holder.lastMessage.setText(tempChat.getLastMessage().getTextMessage());
    }

    @Override
    public void onBindViewHolder(
            @NonNull DisplayChatsAdapter.DisplayChatsViewHolder holder,
            int position,
            @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);

        holder.chatTile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment myFragment = new OpenedChatFragment();
                Bundle args = new Bundle();
                args.putInt("chatId", holder.chatId);
                myFragment.setArguments(args);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHolder, myFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }


    public static class DisplayChatsViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout chatTile;
        TextView name, lastMessage;
        int chatId;

        public DisplayChatsViewHolder(@NonNull View itemView) {
            super(itemView);
            chatTile = itemView.findViewById(R.id.chat_tile);
            name = itemView.findViewById(R.id.chat_tile_name);
            lastMessage = itemView.findViewById(R.id.chat_tile_last_message);
        }
    }
}
