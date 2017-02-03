package com.demo.zappo.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.demo.zappo.BindingRecyclerAdapter;
import com.demo.zappo.Constant;
import com.demo.zappo.MainActivity;
import com.demo.zappo.R;
import com.demo.zappo.ServiceProvider;
import com.demo.zappo.databinding.ProductListItemBinding;
import com.demo.zappo.model.Product;
import com.demo.zappo.model.ProductWrapper;
import com.demo.zappo.view.ProductDetailFragment;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by ashishbulchandani on 12/01/17.
 */

public class ProductListViewModel extends BaseObservable implements Serializable, Callback<ProductWrapper>, View.OnClickListener {


    private final Context context;
    private String searchText;

    public ProductListViewModel(Context context) {
        this.context = context;
        setUpAdapter();
    }


    private ArrayList<Product> productArrayList = new ArrayList<>();


    public ObservableField<BindingRecyclerAdapter> bindingAdapter = new ObservableField<>();


    private void setUpAdapter() {

        bindingAdapter.set(new BindingRecyclerAdapter<ProductListItemBinding>(R.layout.product_list_item) {
            @Override
            public void setBinding(ProductListItemBinding binding, int position) {

                Product product = productArrayList.get(position);
                binding.infoHolder.setOnClickListener(new ProductDetailListener(position));
                binding.price.setText(product.getPrice());
                binding.productName.setText(product.getProductName());
                String url = product.getThumbnailImageUrl().replace("\\", "");
                Log.d("zappo"," urls is " + url);
                Picasso.with(context).load(url).placeholder(R.mipmap.ic_launcher).into(binding.productImage);
            }

            @Override
            public int getItemCount() {
                Log.d("dictionary", "Item Count Requested  => " + productArrayList.size());
                return productArrayList.size();
            }
        });

    }


    public void getProducts(String search_term) {
        Call<ProductWrapper> pw = ServiceProvider.provideProductService().getProductList(search_term, Constant.API_KEY);
        pw.enqueue(this);
        bindingAdapter.get().notifyDataSetChanged();
    }


    @Override
    public void onResponse(Call<ProductWrapper> pc, Response<ProductWrapper> response) {

        productArrayList.addAll(response.body().getResults());
        bindingAdapter.get().notifyDataSetChanged();

    }

    @Override
    public void onFailure(Call<ProductWrapper> call, Throwable t) {
        t.printStackTrace();

    }

    @Override
    public void onClick(View v) {


    }

    private class ProductDetailListener implements View.OnClickListener {
        int position;
        public ProductDetailListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            Bundle b = new Bundle();
            Product p = productArrayList.get(position);
            b.putString(Constant.PRICE,p.getPrice());
            b.putString(Constant.PRODUCT_NAME,p.getProductName());
            b.putString(Constant.PRODUCT_URL,p.getProductUrl().replace("\\", ""));
            b.putString(Constant.PRODUCT_THUMBHNAIL_URL,p.getThumbnailImageUrl().replace("\\", ""));
            MainActivity.instance.transact(ProductDetailFragment.newInstance(b));
        }
    }
}
