package com.souvik.noteapplication.model;


import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public  class DataModel extends RealmObject {


    @Expose
    @SerializedName("completed")
    private boolean completed;
    @Expose
    @SerializedName("title")
    private String title;
    @PrimaryKey
    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("userId")
    private String userId;

    private byte[] href;

    public DataModel(boolean completed, String title, String  id, String userId) {
        this.completed = completed;
        this.title = title;
        this.id = id;
        this.userId = userId;
    }

    public DataModel() {
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public byte[] getHref() {
        return href;
    }

    public void setHref(byte[] href) {
        this.href = href;
    }
}
