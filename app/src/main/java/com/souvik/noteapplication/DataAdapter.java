package com.souvik.noteapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.souvik.noteapplication.Model.DataModel;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

private Context mContext;
private ArrayList<DataModel> dataList;

public DataAdapter(Context mContext, ArrayList<DataModel> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
        }

@NonNull
@Override
public DataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout , parent, false);

        return new MyViewHolder(itemView);
        }

@Override
public void onBindViewHolder(@NonNull DataAdapter.MyViewHolder holder, int position) {
    holder.user_id.setText(String.valueOf(dataList.get(position).getId()));
    holder.title_text.setText(String.valueOf(dataList.get(position).getTitle()));

}


    @Override
    public int getItemCount () {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView user_id, title_text, tranaction_text, amount_text, card_type;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            user_id = (TextView) itemView.findViewById(R.id.user_id);
            title_text = (TextView) itemView.findViewById(R.id.title);



        }

    }
}
