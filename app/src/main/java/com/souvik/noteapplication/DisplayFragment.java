package com.souvik.noteapplication;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.souvik.noteapplication.model.DataModel;
import com.souvik.noteapplication.model.MainModel;


import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import com.souvik.noteapplication.databinding.FragmentDisplayBinding;
import com.souvik.noteapplication.model.ProductModel;


public class DisplayFragment extends Fragment {

   //private RecyclerView recyclerView;
   private DataAdapter dataAdapter;
   private MainModel mainViewModel;
    private Realm realm;
    private RealmHelper helper;
     static int count=0;
   //public static TextView textView;
   private RealmResults<DataModel> getResult;
    FragmentDisplayBinding displayBinding;

    // Progress Dialog
    private ProgressDialog pDialog;

    // Progress dialog type (0 - for Horizontal progress bar)
    public static final int progress_bar_type = 0;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        displayBinding=FragmentDisplayBinding.inflate(inflater,container,false);
        displayBinding.downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDownload();
            }
        });

        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(),1,GridLayoutManager.VERTICAL, false);
        displayBinding.recyclerview.setLayoutManager(mLayoutManager);
        displayBinding.recyclerview.hasFixedSize();



        return displayBinding.getRoot();
    }

   /* @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type: // we set this to 0
                pDialog = new ProgressDialog(getContext());
                pDialog.setMessage("Downloading file. Please wait...");
                pDialog.setIndeterminate(false);
                pDialog.setMax(100);
                pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pDialog.setCancelable(true);
                pDialog.show();
                return pDialog;
            default:
                return null;
        }
    }*/
    private  void startDownload(){
        realm= Realm.getDefaultInstance();
        // getResult = realm.where(DataModel.class).findAll();

        helper=new RealmHelper(realm);
        mainViewModel= ViewModelProviders.of(getActivity()).get(MainModel.class);
        mainViewModel.init();
        mainViewModel.getData().observe(getActivity(), new Observer<ProductModel>() {
            @Override
            public void onChanged(ProductModel dataModels) {
                if(dataModels==null){

                    getResult = realm.where(DataModel.class).findAll();
                    Log.e("called",getResult.size()+"");

                    dataAdapter = new DataAdapter(getActivity(), getResult, getFragmentManager(),displayBinding);
                    displayBinding.recyclerview.setAdapter(dataAdapter);




                }
                else {
                    dataAdapter.notifyDataSetChanged();
                    Log.e("updated",getResult.size()+"");
                }
                countCheck();

            }
        });

    }

    private void countCheck(){

        RealmResults<DataModel> getRes = realm.where(DataModel.class).equalTo("completed", true).findAll();
        count=getRes.size();
        displayBinding.count.setText("Fav Count:"+String.valueOf(count));
    }



    @Override
    public void onResume() {
        super.onResume();
        if(dataAdapter!=null) {
            dataAdapter.notifyDataSetChanged();
        }
    }





}


