package com.demo.zappo.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.zappo.R;
import com.demo.zappo.databinding.HomefragmentBinding;
import com.demo.zappo.viewmodel.HomeViewModel;


/**
 * Created by ashish on 12/01/17.
 */
public class HomeFragment extends SwapFragment {

    private HomefragmentBinding binding;
    private View rootView;


    public static HomeFragment newInstance() {

        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.homefragment, container, false);
            rootView = binding.getRoot();
            binding.setHvm(new HomeViewModel(getActivity()));
        }

        return rootView;
    }




    @Override
    protected String getTitle() {
        return getString(R.string.toolbarTitle);
    }


}
