package com.example.newsapp.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

public abstract class BaseViewHolder<V extends ViewBinding> extends RecyclerView.ViewHolder {

    protected V binding;

    public BaseViewHolder(V binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    protected abstract void onBind(int position);
}
