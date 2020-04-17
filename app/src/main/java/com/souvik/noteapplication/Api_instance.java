package com.souvik.noteapplication;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

//import static com.souvik.noteapplication.UrlCall.BASE_URL;
import static com.souvik.noteapplication.UrlCall.PRODUCT_URL;

public class Api_instance {

    public static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(PRODUCT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

    }
    public static UrlCall getUserDetails(){
        return getRetrofitInstance().create(UrlCall.class);
    }
    public static UrlCall getProductrDetails(){
        return getRetrofitInstance().create(UrlCall.class);
    }
}
