package com.example.newsapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.newsapp.base.BaseFragment;
import com.example.newsapp.databinding.FragmentUserBinding;

public class UserFragment extends BaseFragment<FragmentUserBinding> {
    @Override
    protected FragmentUserBinding inflateViewBind(LayoutInflater inflater, ViewGroup parent, boolean toAttachRoot) {
        return FragmentUserBinding.inflate(inflater, parent, toAttachRoot);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
