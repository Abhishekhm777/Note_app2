package com.souvik.noteapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.souvik.noteapplication.model.DataModel;

import io.realm.Realm;

import com.souvik.noteapplication.databinding.FragmentEditFragmentBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class Edit_fragment extends Fragment {


    private Realm realm;
    private RealmHelper helper;
    private String id;
    private DataModel result2;
    private static String title="";
    private FragmentEditFragmentBinding fragmentEditFragmentBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentEditFragmentBinding= com.souvik.noteapplication.databinding.FragmentEditFragmentBinding.inflate(inflater,container,false);
        View view=fragmentEditFragmentBinding.getRoot();

        Bundle bundle=getArguments();
         id=bundle.getString("id");
        realm= Realm.getDefaultInstance();
        helper=new RealmHelper(realm);
        setEditText();
       saveButtonClick();
       cancleButtonClick();



        return view;
    }
    ////////////////////////set title to edit text///////////////////////
    public void setEditText(){
        realm.beginTransaction();
        result2 = realm.where(DataModel.class)
                .equalTo("id", id)
                .findFirstAsync();
        fragmentEditFragmentBinding.editText.setText(result2.getTitle());
        title=result2.getTitle();
        fragmentEditFragmentBinding.title1.setText("User Id:"+result2.getUserId());
        realm.commitTransaction();
    }
    /////////////////////////save button click///////////////////////////
    public  void saveButtonClick(){
        fragmentEditFragmentBinding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!title.equals(fragmentEditFragmentBinding.editText.getText().toString())) {
                    updateData();

                }
                else {
                    getActivity().onBackPressed();
                }
            }
        });
    }
    public void cancleButtonClick(){
        fragmentEditFragmentBinding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentEditFragmentBinding.editText.setText(title);
            }
        });
    }

    public void updateData(){
        realm.beginTransaction();
        if(result2 == null) {
            result2 = realm.createObject(DataModel.class, id);
        }
        result2.setTitle(fragmentEditFragmentBinding.editText.getText().toString());
        result2.setCompleted(true);
        realm.commitTransaction();
        getActivity().onBackPressed();

    }


}


