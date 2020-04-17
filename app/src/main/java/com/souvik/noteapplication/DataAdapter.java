package com.souvik.noteapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.souvik.noteapplication.model.DataModel;
import com.souvik.noteapplication.databinding.CardLayoutBinding;
import com.souvik.noteapplication.databinding.FragmentDisplayBinding;

import io.realm.Realm;
import io.realm.RealmResults;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder>{

private Context mContext;
//private ArrayList<DataModel> dataList;
  private   RealmResults<DataModel> dataList;
  FragmentManager fragmentManager;
  FragmentDisplayBinding displayBinding;

public DataAdapter(Context mContext, RealmResults<DataModel> dataList, FragmentManager fragmentManager,FragmentDisplayBinding displayBinding) {
        this.mContext = mContext;
        this.dataList = dataList;
        this.fragmentManager=fragmentManager;
        this.displayBinding=displayBinding;
        }

@NonNull
@Override
public DataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout , parent, false);
    CardLayoutBinding cardLayoutBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.card_layout,parent,false);


        return new MyViewHolder(cardLayoutBinding);
        }

@Override
public void onBindViewHolder(@NonNull final DataAdapter.MyViewHolder holder, final int position) {

    DataModel dataModel=dataList.get(position);
    holder.cardLayoutBinding.setDataModel(dataModel);
    holder.cardLayoutBinding.ids.setText("UserId: "+String.valueOf(dataList.get(position).getId()));
    holder.cardLayoutBinding.title.setText(dataList.get(position).getTitle());
    try {
        Bitmap bmp = BitmapFactory.decodeByteArray(dataList.get(position).getHref(), 0, dataList.get(position).getHref().length);
        holder.cardLayoutBinding.imgeview.setImageBitmap(Bitmap.createScaledBitmap(bmp, holder.cardLayoutBinding.imgeview.getWidth(),
                holder.cardLayoutBinding.imgeview.getHeight(), false));
    }catch (Exception e){
        e.printStackTrace();
    }

    if(dataList.get(position).getCompleted()==true){
        holder.cardLayoutBinding.checkBox.setChecked(true);
    }
    else {
        holder.cardLayoutBinding.checkBox.setChecked(false);
    }


    holder.cardLayoutBinding.checkBox.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CheckBox checkBox = (CheckBox)view;
            if(checkBox.isChecked()){
                DisplayFragment.count=DisplayFragment.count+1;
                displayBinding.count.setText("Fav Count:"+String.valueOf(DisplayFragment.count));
                holder.updateData(true,dataList.get(holder.getAdapterPosition()).getId());
            }
            else {
                DisplayFragment.count=DisplayFragment.count-1;
                displayBinding.count.setText("Fav Count:"+String.valueOf(DisplayFragment.count));
            }
        }
    });


    holder.cardLayoutBinding.card.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Bundle bundle=new Bundle();
            bundle.putString("id",dataList.get(holder.getAdapterPosition()).getId());
            Fragment fragment_account = new Edit_fragment();
            fragment_account.setArguments(bundle);
          fragmentManager.beginTransaction().replace(R.id.change_layout, fragment_account).addToBackStack(null).commit();
        }
    });

}


    @Override
    public int getItemCount () {
        return dataList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
       // TextView user_id, title_text;
       // CheckBox checkBox;
       // CardView cardView;
        CardLayoutBinding cardLayoutBinding;
       Realm realm;
        private DataModel result2;
        public MyViewHolder(@NonNull CardLayoutBinding itemView) {
            super(itemView.getRoot());
            cardLayoutBinding=itemView;
            realm= Realm.getDefaultInstance();

            //user_id = (TextView) itemView.findViewById(R.id.user_id);
           // title_text = (TextView) itemView.findViewById(R.id.title);
           // checkBox=(CheckBox)itemView.findViewById(R.id.checkBox);
           // cardView=(CardView)itemView.findViewById(R.id.cardview);
        }
        public void updateData(final boolean completed, final String id){
            result2 = realm.where(DataModel.class)
                    .equalTo("id", id)
                    .findFirstAsync();
            realm.beginTransaction();

            if(result2 == null) {

                result2 = realm.createObject(DataModel.class, id);

            }

            result2.setCompleted(completed);
            realm.commitTransaction();
          //Log.e("data id",id+"");

        }
    }

}
