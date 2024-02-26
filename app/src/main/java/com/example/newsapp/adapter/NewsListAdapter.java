package com.example.newsapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

import com.bumptech.glide.Glide;
import com.example.newsapp.base.BaseRecyclerAdapter;
import com.example.newsapp.base.BaseViewHolder;
import com.example.newsapp.databinding.ItemNewsBinding;
import com.example.newsapp.model.Model;
import com.example.newsapp.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends BaseRecyclerAdapter {

    private ArrayList<News> newsArrayList;

    public NewsListAdapter(ArrayList<News> newsArrayList) {
        this.newsArrayList = newsArrayList;
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsBinding binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new NewsViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

public class NewsViewHolder extends BaseViewHolder<ItemNewsBinding> {


    public NewsViewHolder(ItemNewsBinding binding) {
        super(binding);
    }

    @Override
    protected void onBind(int position) {
        News news = newsArrayList.get(position);
        binding.newsTitle.setText(news.getTitle());
        binding.newsContent.setText(news.getDescription());
        binding.newsSource.setText(news.getAuthor());

        Glide.with(binding.imageViewNews).load(news.getImageUrl()).into(binding.imageViewNews);
    }
}
}
