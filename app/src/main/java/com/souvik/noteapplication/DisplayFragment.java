package com.souvik.noteapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.souvik.noteapplication.Model.DataModel;
import com.souvik.noteapplication.Model.MainModel;

import java.util.ArrayList;

import io.realm.Realm;


public class DisplayFragment extends Fragment {

   private RecyclerView recyclerView;
   private DataAdapter dataAdapter;
   private MainModel mainViewModel;
    private Realm realm;
    private RealmHelper helper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_display, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview) ;
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(),1,GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        realm= Realm.getDefaultInstance();
        helper=new RealmHelper(realm);
        mainViewModel= ViewModelProviders.of(getActivity()).get(MainModel.class);
        mainViewModel.init();
        mainViewModel.getData().observe(getActivity(), new Observer<ArrayList<DataModel>>() {
            @Override
            public void onChanged(ArrayList<DataModel> dataModels) {
                if(dataModels!=null){
                    for(DataModel dataModel:dataModels){
                        helper.writeToDB(dataModel.getUserId(),dataModel.getTitle());
                    }

                    dataAdapter=new DataAdapter(getActivity(),dataModels);
                    recyclerView.setAdapter(dataAdapter);
                }

            }
        });



        return view;
    }

}
