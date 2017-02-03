package com.demo.zappo.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.demo.zappo.MainActivity;
import com.demo.zappo.view.HomeFragment;

import java.io.Serializable;


/**
 * Created by ashishbulchandani on 12/01/17.
 */

public class MainViewModel extends BaseObservable implements Serializable {


    private final Context context;

    public MainViewModel(Context context){
        this.context = context;

    }



    public void showHome(){
        MainActivity.instance.transact(HomeFragment.newInstance());

    }

}
