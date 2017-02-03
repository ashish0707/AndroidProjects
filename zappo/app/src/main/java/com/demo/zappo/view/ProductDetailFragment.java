package com.demo.zappo.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.zappo.Constant;
import com.demo.zappo.R;
import com.demo.zappo.databinding.FragmentProductDetailBinding;
import com.demo.zappo.databinding.FragmentProductListBinding;
import com.demo.zappo.viewmodel.ProductDetailViewModel;
import com.demo.zappo.viewmodel.ProductListViewModel;
import com.squareup.picasso.Picasso;


/**
 * Created by ashish on 12/01/17.
 */
public class ProductDetailFragment extends SwapFragment {

    private FragmentProductDetailBinding binding;
    private View rootView;
    private ProductDetailViewModel viewModel;
    private String url = "";
    private String name = "";
    private String price = "";
    private boolean isPurchased = false;
    private String zappo_product_url = "";


    public static ProductDetailFragment newInstance(Bundle b) {
        ProductDetailFragment fragment = new ProductDetailFragment();
        fragment.setArguments(b);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false);
            rootView = binding.getRoot();
            url = getArguments().getString(Constant.PRODUCT_THUMBHNAIL_URL);
            price = getArguments().getString(Constant.PRICE);
            name = getArguments().getString(Constant.PRODUCT_NAME);
            zappo_product_url = getArguments().getString(Constant.PRODUCT_URL);
            binding.productName.setText(name);
            binding.price.setText(price);
            Picasso.with(getContext()).load(url).placeholder(R.mipmap.ic_launcher).into(binding.productImage);
            binding.fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!isPurchased){

                        binding.fab.setImageResource(R.mipmap.done);
                        isPurchased = true;

                    }else{

                        binding.fab.setImageResource(R.mipmap.cart);
                        isPurchased = false;

                    }


                }
            });
            binding.share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT,zappo_product_url);
                    startActivity(Intent.createChooser(sharingIntent, "Share via"));
                }
            });

        }

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel = new ProductDetailViewModel(getContext());
        binding.setVm(viewModel);
    }

    @Override
    protected String getTitle() {
        return getString(R.string.product_detail);
    }


}
