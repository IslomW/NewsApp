package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.splashscreen.SplashScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;

import com.example.newsapp.base.BaseActivity;
import com.example.newsapp.databinding.ActivityMainBinding;
import com.example.newsapp.fragments.NewsFragment;
import com.example.newsapp.fragments.UserFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private NewsFragment newsFragment;
    private UserFragment userFragment;


    @Override
    protected ActivityMainBinding inflateViewBind(LayoutInflater inflater) {
        return ActivityMainBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        replaceFragment(R.id.nav_news);

        binding.navMenuBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                replaceFragment(item.getItemId());
                return true;
            }
        });
    }

    private void replaceFragment(int tabId) {

        if (tabId == R.id.nav_news) {

            if (newsFragment == null)
                newsFragment = new NewsFragment();



            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, newsFragment)
                    .commit();

        }else if (tabId == R.id.nav_user) {
            if (userFragment == null)
                userFragment = new UserFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, userFragment)
                    .commit();
        }
    }
}