package com.meanu.sijangseoul.Search;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meanu.sijangseoul.R;
import com.meanu.sijangseoul.model.RetroPrice;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private List<RetroPrice.Mgismulgainfo.row> dataList;
    private int itemLayout;
    private List<RetroPrice.Mgismulgainfo.row> arrayList;

    public SearchAdapter(List<RetroPrice.Mgismulgainfo.row> dataList, int itemLayout) {
        this.dataList = dataList;
        this.itemLayout = itemLayout;

        arrayList = new ArrayList<>();
        arrayList.addAll(dataList);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return 1;
        else return 2;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_search_list_view_header, viewGroup, false);
            return new ViewHolder(view);
        } else {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder viewHolder, int position) {
        viewHolder.label.setText(dataList.get(position).getcOT_CONTS_NAME());
        viewHolder.label.setTag("tag");
        viewHolder.icon.setImageResource(R.drawable.shopping_cart);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void filter(String charText) {

        dataList.clear();
        if (charText.length() == 0) {
            dataList.addAll(arrayList);
        } else {
            for (RetroPrice.Mgismulgainfo.row row : arrayList) {
                String name = row.getcOT_CONTS_NAME();
                String name2 = row.getcOT_GU_NAME();
                if (name2.toLowerCase().contains(charText)) {
                    dataList.add(row);
                }
                if (name.toLowerCase().contains(charText)) {
                    dataList.add(row);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView label;
        public ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);
            label = itemView.findViewById(R.id.label);
            icon = itemView.findViewById(R.id.icon_search);
        }
    }
}