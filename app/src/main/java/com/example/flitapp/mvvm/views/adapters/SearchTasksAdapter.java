package com.example.flitapp.mvvm.views.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flitapp.R;
import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.viewModels.SearchTasksViewModel;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchTasksAdapter extends RecyclerView.Adapter<SearchTasksAdapter.SearchTasksViewHolder> {
    private SearchTasksViewModel viewModel;

    private ArrayList<Task> taskList;
    Context context;

    public SearchTasksAdapter(ArrayList<Task> data, Context context, SearchTasksViewModel searchTasksViewModel) {
        this.taskList = data;
        this.context = context;
        this.viewModel = searchTasksViewModel;
    }

    @NonNull
    @Override
    public SearchTasksAdapter.SearchTasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_task, parent, false);
        return new SearchTasksAdapter.SearchTasksViewHolder(view);
    }

    public TextView setTagStyle(TextView element, String tag) {

        String tagColor = "#FFFFFF";
        for (Map.Entry<String, String> entry : viewModel.getTagColors().entrySet()) {
            if (tag.equals(entry.getKey())) {
                tagColor = entry.getValue();
            }
        }
        element.setBackgroundColor(Color.parseColor(tagColor));

        element.setText(normalizeTag(tag));

        element.setTextAppearance(R.style.TagsStyling);
        float scale = context.getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (10*scale + 0.5f);
        element.setPadding(dpAsPixels, 0, dpAsPixels, 0);

        return element;
    }

    public String normalizeTag(String tag) {
        String result = "";

        switch (tag) {
            case "html":
                result = "HTML";
                break;
            case "css":
                result = "CSS";
                break;
            case "javascript":
                result = "JavaScript";
                break;
            case "csharp":
                result = "C#";
                break;
            case "cpp":
                result = "C++";
                break;
            case "jupyter_notebook":
                result = "Jupyter Notebook";
                break;
            case "matlab":
                result = "MATLAB";
                break;
            case "objectivec":
                result = "Objective-C";
                break;
            case "php":
                result = "PHP";
                break;
            case "typescript":
                result = "TypeScript";
                break;
            case "vba":
                result = "VBA";
                break;
            case "webassembly":
                result = "WebAssembly";
                break;
            case "onec":
                result = "1C";
                break;
            case "asp_dotnet":
                result = "ASP.NET";
                break;
            case "csv":
                result = "CSV";
                break;
            case "glsl":
                result = "GLSL";
                break;
            case "angularjs":
                result = "AngularJS";
                break;
            case "nodejs":
                result = "NodeJS";
                break;
            case "ruby_on_rails":
                result = "Ruby On Rails";
                break;
            case "gatsby":
                result = "GatsbyJS";
                break;
            case "mysql":
                result = "MySQL";
                break;
            case "postgresql":
                result = "PostgreSQL";
                break;
            case "microsoft_sql_server":
                result = "Microsoft SQL Server";
                break;
            case "oracle_database":
                result = "Oracle Database";
                break;
            case "sql":
                result = "SQL";
                break;
            case "mongodb":
                result = "MongoDB";
                break;
            case "modx":
                result = "MODX";
                break;
            case "wordpress":
                result = "WordPress";
                break;
            case "bitrix":
                result = "Bitrix24";
                break;
            case "opencart":
                result = "OpenCart";
                break;
            case "http":
                result = "HTTP";
                break;
            case "svg":
                result = "SVG";
                break;
            default:
                result = Character.toUpperCase(tag.charAt(0)) + tag.substring(1).toLowerCase();
                break;
        }

        return result;
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchTasksAdapter.SearchTasksViewHolder holder, int position) {
        final Task tempTask = taskList.get(position);

        holder.header.setText(tempTask.getHeader());
        holder.price.setText(tempTask.getPrice());
        holder.description.setText(tempTask.getDescription());

        for(String tag : tempTask.getTags()) {
            TextView txtItem = new TextView(context);

            holder.tagsList.addView(setTagStyle(txtItem, tag));
        }
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class SearchTasksViewHolder extends RecyclerView.ViewHolder {
        TextView header, price, description;
        FlexboxLayout tagsList;

        public SearchTasksViewHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.task_header);
            price = itemView.findViewById(R.id.task_price);
            description = itemView.findViewById(R.id.description);
            tagsList = itemView.findViewById(R.id.tags_list);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull SearchTasksViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }
}
