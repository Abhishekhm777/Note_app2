package com.souvik.noteapplication;

import android.content.SharedPreferences;
import android.util.Log;

import com.souvik.noteapplication.Model.DataModel;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {
    Realm realm;
    RealmResults<DataModel> userDetails;
    Boolean saved,delete;

    public RealmHelper(Realm realm) {
        this.realm = realm;

    }
    public void delete(){
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.deleteAll();

        realm.commitTransaction();

    }

    public void retrieveDB()
    {
        userDetails=realm.where(DataModel.class).findAll();
        Log.d("REALM RESULT SIZE", String.valueOf(userDetails));

    }
    public Integer dbSize(){
        userDetails=realm.where(DataModel.class).findAll();
        return userDetails.size();
    }

    ///////////////////////////////////////////////write into DB/////////////////////////////////////////////////
    public void writeToDB(final Integer Id, final String title) {

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {


                DataModel dm = bgRealm.createObject(DataModel.class);
               dm.setUserId(Id);
               dm.setTitle(title);

                Log.d("Database...2", "" + dm.getTitle().toString());


            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                Log.e("Database", "data inserted");

                //  myEditor.putInt("count_key",mCnt1++).apply();

            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Log.e("Database", error.getMessage());
            }
        });

    }
    //READ
    public ArrayList<DataModel> justreferesh()
    {
        ArrayList<DataModel> productsList=new ArrayList<>();


        for(DataModel dm:userDetails)
        {
            productsList.add(dm);

        }
        // return retrieve();
        return productsList;
    }
}
