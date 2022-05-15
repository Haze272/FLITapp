package com.example.flitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.flitapp.databinding.MainActivityBinding;
import com.example.flitapp.mvvm.views.FavoritesFragment;
import com.example.flitapp.mvvm.views.MessagesListFragment;
import com.example.flitapp.mvvm.views.ProfileFragment;
import com.example.flitapp.mvvm.views.ResponsesFragment;
import com.example.flitapp.mvvm.views.SearchTasksFragment;


public class MainActivity extends AppCompatActivity {
    MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();

        replaceFragment(new SearchTasksFragment());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.search_page:
                    replaceFragment(new SearchTasksFragment());
                    break;
                case R.id.favorite_page:
                    replaceFragment(new FavoritesFragment());
                    break;
                case R.id.responces_page:
                    replaceFragment(new ResponsesFragment());
                    break;
                case R.id.messages_page:
                    replaceFragment(new MessagesListFragment());
                    break;
                case R.id.profile_page:
                    replaceFragment(new ProfileFragment());
                    break;
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.fragmentHolder.getId(), fragment);
        fragmentTransaction.commit();
    }
}