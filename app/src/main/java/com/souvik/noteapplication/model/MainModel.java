package com.souvik.noteapplication.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.souvik.noteapplication.Repository.NoteRepository;

import java.util.ArrayList;

public class MainModel extends ViewModel {
    private MutableLiveData<ProductModel> mGetUser;
    private NoteRepository noteRepository;
    public void init(){
        if(mGetUser != null){
            return;
        }
        noteRepository=NoteRepository.getInstance();
        mGetUser=noteRepository.getProductDetails();
    }
    public LiveData<ProductModel> getData(){
        return mGetUser;
    }
}
