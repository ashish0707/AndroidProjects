package com.demo.zappo;

import com.demo.zappo.service.ProductService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ashishbulchandani on 01/02/17.
 */

public class ServiceProvider {

    private ServiceProvider(){}

    public static ProductService provideProductService(){

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.zappos.com/")
                .build();

        return retrofit.create(ProductService.class);

    }


}
