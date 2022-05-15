package com.example.flitapp.mvvm.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flitapp.R;
import com.example.flitapp.mvvm.models.Task;

import java.util.ArrayList;
import java.util.List;

public class SearchTasksAdapter extends RecyclerView.Adapter<SearchTasksAdapter.SearchTasksViewHolder> {
    private ArrayList<Task> taskList;
    Context context;

    public SearchTasksAdapter(ArrayList<Task> data, Context context) {
        this.taskList = data;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchTasksAdapter.SearchTasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_task, parent, false);
        return new SearchTasksAdapter.SearchTasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchTasksAdapter.SearchTasksViewHolder holder, int position) {
        final Task temp = taskList.get(position);

        holder.header.setText(taskList.get(position).getHeader());
        holder.price.setText(taskList.get(position).getPrice());
        holder.description.setText(taskList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class SearchTasksViewHolder extends RecyclerView.ViewHolder {
        TextView header, price, description;

        public SearchTasksViewHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.task_header);
            price = itemView.findViewById(R.id.task_price);
            description = itemView.findViewById(R.id.description);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull SearchTasksViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }
}
