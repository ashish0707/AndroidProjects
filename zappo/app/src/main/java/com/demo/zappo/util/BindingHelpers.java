package com.demo.zappo.util;

import android.databinding.BindingAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

//import com.squareup.picasso.Picasso;

/**
 * Created by ashish on 30/1/17.
 */
public class BindingHelpers {

    private static String TAG = "BindingHelpers";

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView image, String url) {
//        Picasso.with(image.getContext()).load(url).fit().centerInside().into(image);
    }

    @BindingAdapter("bind:imageUrlCrop")
    public static void loadImageInside(ImageView image, String url) {
//        Picasso.with(image.getContext()).load(url).fit().centerCrop().into(image);
    }



    @BindingAdapter("bind:hAdapter")
    public static void horizontalAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }


    @BindingAdapter("bind:vAdapter")
    public static void verticalAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    @BindingAdapter({"bind:ghAdapter","bind:count"})
    public static void gridHorizontalAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter, int count){

        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(),count);
        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }


    @BindingAdapter({"bind:gvAdapter","bind:count"})
    public static void gridVerticalAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter, int count){

        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(),count);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }


}
