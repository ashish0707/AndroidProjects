package com.demo.zappo.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.zappo.Constant;
import com.demo.zappo.R;
import com.demo.zappo.databinding.FragmentProductListBinding;
import com.demo.zappo.viewmodel.ProductListViewModel;


/**
 * Created by ashish on 12/01/17.
 */
public class ProductListFragment extends SwapFragment {

    private FragmentProductListBinding binding;
    private View rootView;
    private ProductListViewModel viewModel;
    private String searchText = "";


    public static ProductListFragment newInstance(Bundle b) {
        ProductListFragment fragment = new ProductListFragment();
        fragment.setArguments(b);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_list, container, false);
            rootView = binding.getRoot();
            searchText = getArguments().getString(Constant.SEARCH_PRODUCT_KEY);

        }

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel = new ProductListViewModel(getContext());
        viewModel.getProducts(searchText);
        binding.setVm(viewModel);
    }

    @Override
    protected String getTitle() {
        return getString(R.string.product_list);
    }


}
