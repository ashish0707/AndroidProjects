package com.demo.zappo.service;

import com.demo.zappo.model.ProductWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ashishbulchandani on 01/02/17.
 */

public interface ProductService {

    @GET("Search")
    Call<ProductWrapper> getProductList(@Query("term") String search_term,@Query("key") String search_key);

}
