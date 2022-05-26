package com.example.flitapp.mvvm.views;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.flitapp.R;
import com.example.flitapp.databinding.ActualTasksBinding;
import com.example.flitapp.databinding.OpenedTaskBinding;
import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.viewModels.OpenedTaskViewModel;
import com.example.flitapp.mvvm.viewModels.SearchTasksViewModel;

import java.util.Map;

public class OpenedTaskFragment extends Fragment {
    private OpenedTaskViewModel viewModel;
    private OpenedTaskBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.opened_task, container, false);
        viewModel = new ViewModelProvider(this).get(OpenedTaskViewModel.class);
        binding = OpenedTaskBinding.bind(v);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        int openedId = getArguments().getInt("taskId", 0);
        Task openedTask = viewModel.getAboutTask(openedId);

        binding.openedTaskHeader.setText(openedTask.getHeader());
        binding.openedTaskPrice.setText(openedTask.getPrice());
        binding.flexboxLayout.removeAllViews();
        for(String tag : openedTask.getTags()) {
            TextView txtItem = new TextView(getContext());

            binding.flexboxLayout.addView(setTagStyle(txtItem, tag));
        }
        //binding.openedTaskDescription.setText(openedTask.getDescription());

        binding.openedAddToFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addTaskToFavourite(openedTask);
            }
        });

        binding.responseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addTaskToResponses(openedTask);
            }
        });
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
        float scale = getContext().getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (10*scale + 0.5f);
        element.setPadding(dpAsPixels, 0, dpAsPixels, 0);

        return element;
    }

    public String normalizeTag(@NonNull String tag) {
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
}
