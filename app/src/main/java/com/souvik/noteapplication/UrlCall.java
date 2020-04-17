package com.souvik.noteapplication;

import com.souvik.noteapplication.model.DataModel;
import com.souvik.noteapplication.model.ProductModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface UrlCall {
    //String BASE_URL="https://jsonplaceholder.typicode.com/";
    /*https://server.mrkzevar.com/gate/b2b/catalog/api/v1/product/all/*/
    String PRODUCT_URL="https://server.mrkzevar.com/gate/b2b/catalog/api/v1/product/all/";
   /* @GET("todos/")
    Call<ArrayList<DataModel>> userInfo();*/
    @GET("3")
    Call<ProductModel> productInfo(@Header("Authorization") String authHeader);
}
