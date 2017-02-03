package com.demo.zappo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public abstract class BindingRecyclerAdapter<T> extends RecyclerView.Adapter<BindingViewHolder> {

    private int layout;


    public BindingRecyclerAdapter(int layout) {
        this.layout = layout;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding dataBinding = DataBindingUtil.inflate(inflater, layout, parent, false);
        return new BindingViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        T binding = (T) holder.getBinding();
        setBinding(binding,position);

    }


    public abstract void setBinding(T binding, int position);




}
