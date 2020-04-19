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
        Call<ProductModel> proInfo = retrofitCall.productInfo("bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODczNjE4MTUsInVzZXJfbmFtZSI6ImFrYXNoMUBnbWFpbC5jb20iLCJhdXRob3JpdGllcyI6WyJST0xFX1dIT0xFU0FMRVIiXSwianRpIjoiZjg1MzUyMWYtMDA5OC00Y2I3LTg1ZGEtY2JjZDg2YmNjNDYzIiwiY2xpZW50X2lkIjoib3Jkb2Z5LXdlYiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.Wn79rhmvAlXuX3on54Vv2SiuNhxHa2rxMPPTVqEQDEKgfrEd-S6ABZJ_oedIPvciT1FRua0hIFCjmU609RwCdtw9XfPFW5jIQTuULcH0R8aQtfJNJ8UawCPNj89itpiGHfBckvz7iQSVcZeGyB2Nkr07tXrNdOTXRUONSG6ODcLiwNQ9UdLxcLQs-4orrpraefzNG1Hwq-UScEmx6e0bv-UIn-Vm0aXSxHM18mQoyw1Wlc8MeY5evYh8r7AHOT3GgzDvY7fmYkStj7Kjc_t-DBllJu0pqTHc7IwsO8aVzk8v4ZpXELA14KewnaQs87_MDfgsNezo3tgJ-H8pZIS_gA");
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
