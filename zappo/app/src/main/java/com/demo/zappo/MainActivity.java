package com.demo.zappo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.demo.zappo.databinding.ActivityMainBinding;
import com.demo.zappo.viewmodel.MainViewModel;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class MainActivity extends AppCompatActivity {

    public static MainActivity instance;
    Toolbar toolbar;
    private ProgressDialog progressDialog;
    public ActivityMainBinding binding;
    private MainViewModel mainViewModel;
    private boolean productUrlReceieved = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle(R.string.toolbarTitle);
        setSupportActionBar(toolbar);
        instance = this;
        mainViewModel = new MainViewModel(this);
        handleIntent(getIntent());
        mainViewModel.showHome();
    }

    void handleIntent(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        Log.d("zappo","shared text is " +sharedText);
        if (sharedText != null) {
            productUrlReceieved = true;

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(productUrlReceieved){
            Toast.makeText(this,R.string.failure_message,Toast.LENGTH_LONG).show();
            productUrlReceieved = false;
        }
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>1)
            super.onBackPressed();
        else
            showAlert(getString(R.string.quit_message));
    }

    public void replace(Fragment fragment) {
        transact(fragment, false);
    }

    public void transact(Fragment fragment) {
        transact(fragment, true);
    }

    public void swapFragment(Fragment fragment) {

        getSupportFragmentManager().popBackStack();
        transact(fragment, true);

    }

    private void transact(Fragment fragment, boolean addToStack) {


            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction().replace(R.id.container, fragment);
            if (addToStack) {
                transaction.addToBackStack(null).commit();
            } else {
                transaction.commit();
            }
//        dismissLoading();


    }

    public void showDialogLoading() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.show();

    }

    public void dismissDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();

    }

    public void showLoading() {

        binding.loading.setVisibility(View.VISIBLE);
        binding.container.setVisibility(View.INVISIBLE);

    }

    public void dismissLoading() {
        binding.loading.setVisibility(View.GONE);
        binding.container.setVisibility(View.VISIBLE);
    }

    public void showError(String message) {
        Snackbar.make(binding.container, message, Snackbar.LENGTH_LONG).show();

    }

    public void showAlert(String message){

        final AlertDialog alertDialog = new AlertDialog.Builder(this)

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                }).setMessage(message)
                .show();

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
