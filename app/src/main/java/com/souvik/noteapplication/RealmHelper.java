package com.souvik.noteapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.souvik.noteapplication.model.DataModel;
import com.souvik.noteapplication.model.ProductModel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
    }
    public Integer dbSize(){
        userDetails=realm.where(DataModel.class).findAll();
        return userDetails.size();
    }

   /* ///////////////////////////////////////////////write into DB/////////////////////////////////////////////////
    public void writeToDB(final ArrayList<DataModel>dataModel, final MutableLiveData<ArrayList<DataModel>>data) {
        try {


            realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm bgRealm) {



                        for (DataModel dataModels : dataModel) {
                            DataModel dm = bgRealm.createObject(DataModel.class, dataModels.getId());
                            dm.setTitle(dataModels.getTitle());
                            dm.setUserId(dataModels.getUserId());
                            dm.setCompleted(dataModels.getCompleted());
                        }
                        //bgRealm.commitTransaction();


                }
            }, new Realm.Transaction.OnSuccess() {
                @Override
                public void onSuccess() {
                    data.postValue(dataModel);


                }
            }, new Realm.Transaction.OnError() {
                @Override
                public void onError(Throwable error) {

                    // Transaction failed and was automatically canceled.
                    Log.e("Database", error.getMessage());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
   ///////////////////////////////////////////////write into DB/////////////////////////////////////////////////
   public void writeToDB(final ProductModel productModel, final MutableLiveData<ProductModel>data) {
       try {


           realm.executeTransactionAsync(new Realm.Transaction() {
               @Override
               public void execute(Realm bgRealm) {
                   List<ProductModel.Content> contentlist=productModel.getProducts().getContent();
                   Log.e("product name..",productModel.getProducts().toString());
                   int count=1;
                   for (ProductModel.Content content :contentlist) {
                       DataModel dm = bgRealm.createObject(DataModel.class, content.getId());
                       dm.setTitle(content.getName());
                       dm.setUserId(content.getSku());
                       dm.setCompleted(content.getShowable());
                       dm.setDate(content.getCreatedOn());
                       count=count+1;
                       if (count<6) {
                           dm.setHref(getBitmapFromURL("https://server.mrkzevar.com/gate/b2b/catalog/api/v1/assets/image/"+content.getImageGridFsID().get(0)));
                           Log.e("count..."+content.getImageGridFsID().get(0),count+"");
                       }



                   }
                   //bgRealm.commitTransaction();


               }
           }, new Realm.Transaction.OnSuccess() {
               @Override
               public void onSuccess() {
                   data.postValue(productModel);


               }
           }, new Realm.Transaction.OnError() {
               @Override
               public void onError(Throwable error) {

                   // Transaction failed and was automatically canceled.
                   Log.e("Databassss", error.getMessage());
               }
           });
       }catch (Exception e){
           e.printStackTrace();
       }
   }

    public  byte[] getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            myBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            Log.e("image byte...",byteArray.length+"");
            return byteArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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
