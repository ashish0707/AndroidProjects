package com.demo.zappo.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.demo.zappo.Constant;
import com.demo.zappo.MainActivity;
import com.demo.zappo.view.ProductListFragment;

import java.io.Serializable;

/**
 * Created by ashishbulchandani on 12/01/17.
 */

public class ProductDetailViewModel extends BaseObservable implements Serializable {


    private final Context context;

    public ProductDetailViewModel(Context context){
        this.context = context;

    }


    public void share(View v, EditText searchET){
        Bundle b = new Bundle();
        b.putString(Constant.SEARCH_PRODUCT_KEY,searchET.getText().toString());
        MainActivity.instance.transact(ProductListFragment.newInstance(b));

    }




}
