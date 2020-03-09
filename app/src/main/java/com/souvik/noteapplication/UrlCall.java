package com.souvik.noteapplication;

import com.souvik.noteapplication.Model.DataModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface UrlCall {
    String BASE_URL="https://jsonplaceholder.typicode.com/";
    @GET("todos/")
    Call<ArrayList<DataModel>> userInfo();
}
