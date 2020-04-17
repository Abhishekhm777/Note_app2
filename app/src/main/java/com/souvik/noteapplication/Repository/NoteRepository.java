package com.souvik.noteapplication.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.souvik.noteapplication.Api_instance;
import com.souvik.noteapplication.model.DataModel;
import com.souvik.noteapplication.RealmHelper;
import com.souvik.noteapplication.UrlCall;
import com.souvik.noteapplication.model.ProductModel;

import java.util.ArrayList;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoteRepository {
    private static NoteRepository instance;
    private ArrayList<DataModel> dataModels;
    private ProductModel productModel;
    //MutableLiveData<ArrayList<DataModel>> data;
    MutableLiveData<ProductModel>pdata;
    private Realm realm;
    private RealmHelper helper;


    public static NoteRepository getInstance(){
        if(instance==null){
            instance=new NoteRepository();

        }
        return instance;
    }
   /* public MutableLiveData<ArrayList<DataModel>> getUserDetails(){
        realm= Realm.getDefaultInstance();
        helper=new RealmHelper(realm);
        getUser();
        data = new MutableLiveData<>();
        data.setValue(dataModel);

        return data;
    }*/
    public MutableLiveData<ProductModel> getProductDetails(){
        realm= Realm.getDefaultInstance();
        helper=new RealmHelper(realm);
       // getUser();
        getProduct();

        pdata=new MutableLiveData<>();
        pdata.setValue(productModel);
        return pdata;
    }
    //////////////////////////////////user details////////////////////////////////
    public void getProduct() {

        UrlCall retrofitCall = Api_instance.getProductrDetails();
        Call<ProductModel> proInfo = retrofitCall.productInfo("Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODcxODMxMTAsInVzZXJfbmFtZSI6ImFiY2RAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9XSE9MRVNBTEVSIl0sImp0aSI6IjBjZGY2NmE1LTEwMzUtNGMwNy1hYWMyLTc1MmJlMDJlMjdjNCIsImNsaWVudF9pZCI6Im9yZG9meS13ZWIiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.JEyfTZcz6N40LeP_oQ241Vpv1LZ7Gop1V15IhyZxEqXWYtbuFO5e60VrCor8dvNmtH6ZPQlbAbHGkiDi96wlhqhY2NI5g5HycMibLzhEQX6sSJiBEzVWSIz-26aIAslwETTu7bYQWPpC-2uqFGCd8BPOo-3dweCvEj3idB3zw-yOL7489sbBpDy5xyEWvIWhCh0KuWNZ6CgV2Q-MYfTPt3WPro5eVbfCyK9sqDnAqZbHIbYqRRGr5JkIvhdEackbi3LYIR82bFVRtX2OmReD_8-PVI_4kAJ8_IBVwS6S4gsEfc_CNBZYkYuk35J_nrYy3wBZAtzykQgjXg8WdXDw5Q");
        proInfo.enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if (response.isSuccessful()) {

                    productModel = response.body();
                    helper.writeToDB(productModel, pdata);
                    Log.e("product..",productModel.getProducts().getContent().size()+"");
                }
            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
                Log.e("product failed..",t.getMessage());
            }

        });
    }

           /* @Override
            public void onResponse(Call<ArrayList<DataModel>> call, Response<ArrayList<DataModel>> response) {
                if(response.isSuccessful()){
                    productModel=response.body();
                    helper.writeToDB(dataModel,data);
                *//* for(DataModel dataModels:dataModel){
                     realm.beginTransaction();
                     helper.writeToDB(dataModels.getTitle(),dataModels.getUserId(),dataModels.getId(),dataModels.getCompleted());
                     realm.commitTransaction();
                 }

                 data.postValue(dataModel);*//*
                }
            }

            @Override
            public void onFailure(Call<ArrayList<DataModel>> call, Throwable t) {

            }
        });

    }*/

    /*//////////////////////////////////user details////////////////////////////////
    public void getUser(){

        UrlCall retrofitCall= Api_instance.getUserDetails();
        Call<ArrayList<DataModel>> userInfo=retrofitCall.userInfo();
        userInfo.enqueue(new Callback<ArrayList<DataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<DataModel>> call, Response<ArrayList<DataModel>> response) {
             if(response.isSuccessful()){
                 dataModel=response.body();
                 helper.writeToDB(dataModel,data);
                *//* for(DataModel dataModels:dataModel){
                     realm.beginTransaction();
                     helper.writeToDB(dataModels.getTitle(),dataModels.getUserId(),dataModels.getId(),dataModels.getCompleted());
                     realm.commitTransaction();
                 }

                 data.postValue(dataModel);*//*
             }
            }

            @Override
            public void onFailure(Call<ArrayList<DataModel>> call, Throwable t) {

            }
        });

    }*/

}
