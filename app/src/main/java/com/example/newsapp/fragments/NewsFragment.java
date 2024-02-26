package com.example.newsapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.newsapp.adapter.NewsListAdapter;
import com.example.newsapp.base.BaseFragment;
import com.example.newsapp.databinding.FragmentNewsBinding;
import com.example.newsapp.model.Model;
import com.example.newsapp.model.News;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends BaseFragment<FragmentNewsBinding> {
    @Override
    protected FragmentNewsBinding inflateViewBind(LayoutInflater inflater, ViewGroup parent, boolean toAttachRoot) {
        return FragmentNewsBinding.inflate(inflater, parent, toAttachRoot);
    }

    private NewsListAdapter newsListAdapter;
    private Model model;
    private ArrayList<News>newsArrayList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      newsListAdapter = new NewsListAdapter(newsArrayList);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerNews.setAdapter(newsListAdapter);

//        Call<List> call = baseActivity.mainApi.getNews(baseActivity.getBarerToken());

        Call<Model> call = baseActivity.mainApi.getNews(baseActivity.getBarerToken());
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful()) {
                    newsArrayList.clear();
                    model = response.body();
                    newsArrayList.addAll(model.arrayList);
                    newsListAdapter.notifyDataSetChanged();
                    Log.d("News", model.arrayList.toString());
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e("Error", t.getLocalizedMessage());
            }
        });


    }
}
