package com.souvik.noteapplication.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.souvik.noteapplication.Repository.NoteRepository;

import java.util.ArrayList;

public class MainModel extends ViewModel {
    private MutableLiveData<ArrayList<DataModel>> mGetUser;
    private NoteRepository noteRepository;
    public void init(){
        if(mGetUser != null){
            return;
        }
        noteRepository=NoteRepository.getInstance();
        mGetUser=noteRepository.getUserDetails();
    }
    public LiveData<ArrayList<DataModel>> getData(){
        return mGetUser;
    }
}
