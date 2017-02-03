package com.demo.zappo;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;


public class BindingViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public BindingViewHolder(ViewDataBinding layoutBinding) {
        super(layoutBinding.getRoot());
        binding = layoutBinding;
    }


    public ViewDataBinding getBinding() {
        return binding;
    }
}
