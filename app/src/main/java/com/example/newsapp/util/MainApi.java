package com.example.newsapp.util;

import com.example.newsapp.model.Model;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface MainApi {

    @GET("/v2/everything?q=keyword")
    Call<Model> getNews(@Header("Authorization")String barerToken);
}
