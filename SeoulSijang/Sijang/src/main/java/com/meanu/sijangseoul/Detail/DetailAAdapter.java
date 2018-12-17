package com.meanu.sijangseoul.Detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meanu.sijangseoul.R;
import com.meanu.sijangseoul.model.RetroPrice;

import java.util.HashMap;
import java.util.List;

public class DetailAAdapter extends RecyclerView.Adapter<DetailAAdapter.MyViewHolder> {
    private Context mContext;
    private RetroPrice.Mgismulgainfo.row data;
    private HashMap<String, String> dataList;
    private List<String> dataName;
    private List<String> dataPrice;


    public DetailAAdapter(Context context, List<String> dataName, List<String> dataPrice) {
        this.dataName = dataName;
        this.dataPrice = dataPrice;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.detail_item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_name.setText(dataName.get(position));
        holder.tv_price.setText(dataPrice.get(position));
    }

    @Override
    public int getItemCount() {
        return dataName.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_price;

        public MyViewHolder(View view) {
            super(view);
            tv_name = view.findViewById(R.id.tv_name);
            tv_price = view.findViewById(R.id.tv_price);
        }
    }
}