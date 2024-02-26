package com.example.newsapp.base;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.example.newsapp.util.MainApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseActivity<V extends ViewBinding> extends AppCompatActivity {

    protected V binding;

    public MainApi mainApi;

    protected abstract V inflateViewBind(LayoutInflater inflater);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = inflateViewBind(getLayoutInflater());
        setContentView(binding.getRoot());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mainApi = retrofit.create(MainApi.class);
//        String bearerToken = "Bearer a44203a370f64464b783b9d4d7ca65d8";
    }



    public String getBarerToken(){
        return new String("Bearer a44203a370f64464b783b9d4d7ca65d8");
    }

}


