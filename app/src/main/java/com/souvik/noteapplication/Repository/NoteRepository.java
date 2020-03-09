package com.souvik.noteapplication.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.souvik.noteapplication.Api_instance;
import com.souvik.noteapplication.DataAdapter;
import com.souvik.noteapplication.Model.DataModel;
import com.souvik.noteapplication.RealmHelper;
import com.souvik.noteapplication.UrlCall;

import java.util.ArrayList;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NoteRepository {
    private static NoteRepository instance;
    private ArrayList<DataModel> dataModel;
    MutableLiveData<ArrayList<DataModel>> data;


    public static NoteRepository getInstance(){
        if(instance==null){
            instance=new NoteRepository();

        }
        return instance;
    }
    public MutableLiveData<ArrayList<DataModel>> getUserDetails(){

        getUser();
        data = new MutableLiveData<>();
        data.setValue(dataModel);
        return data;
    }

    //////////////////////////////////user details////////////////////////////////
    public void getUser(){

        UrlCall retrofitCall= Api_instance.getUserDetails();
        Call<ArrayList<DataModel>> userInfo=retrofitCall.userInfo();
        userInfo.enqueue(new Callback<ArrayList<DataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<DataModel>> call, Response<ArrayList<DataModel>> response) {
                Log.e("response code..",response.code()+"");
             if(response.isSuccessful()){
                 Log.e("get...",response.body().toString());
                 dataModel=response.body();
                 data.postValue(dataModel);
             }
            }

            @Override
            public void onFailure(Call<ArrayList<DataModel>> call, Throwable t) {

            }
        });

    }
}
