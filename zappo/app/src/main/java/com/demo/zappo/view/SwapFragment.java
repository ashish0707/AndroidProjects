package com.demo.zappo.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.MenuItem;

import com.demo.zappo.MainActivity;


/**
 * Created by ashish on 12/1/17.
 */
public abstract class SwapFragment extends Fragment {

    MainActivity mainActivity;
    private String TAG="SwapFragment";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;


    }

    @Override
    public void onResume() {
        super.onResume();
        if(mainActivity==null) {
            return;
        }

        if (mainActivity.getSupportActionBar()==null){
            return;
        }
        mainActivity.getSupportActionBar().setTitle(getTitle());
    }

    protected void transact(Fragment fragment){
        mainActivity.transact(fragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.v(TAG,"onOptionsItemSelected");

        return super.onOptionsItemSelected(item);

    }

    protected abstract String getTitle();



}
