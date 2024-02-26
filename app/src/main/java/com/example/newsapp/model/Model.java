package com.example.newsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Model {
    @SerializedName("articles")
    public ArrayList<News> arrayList = new ArrayList<>();

}
