package com.meanu.sijangseoul.Backdrop;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;
import com.meanu.sijangseoul.R;
import com.meanu.sijangseoul.model.GuName;
import com.meanu.sijangseoul.model.RetroPrice;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BackdropListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.backdrop_list_fragment, container, false);
        RecyclerView recyclerView = view1.findViewById(R.id.recycler_view);

        RecyclerViewExpandableItemManager expMgr = new RecyclerViewExpandableItemManager(null);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(expMgr.createWrappedAdapter(new MyAdapter(getContext())));

        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        expMgr.attachRecyclerView(recyclerView);
        return view1;
    }

    static abstract class MyBaseItem {
        public final long id;
        public final String text;

        public MyBaseItem(long id, String text) {
            this.id = id;
            this.text = text;
        }
    }

    static class MyGroupItem extends MyBaseItem {
        public final List<MyChildItem> children;

        public MyGroupItem(long id, String text) {
            super(id, text);
            children = new ArrayList<>();
        }
    }

    static class MyChildItem extends MyBaseItem {
        public MyChildItem(long id, String text) {
            super(id, text);
        }
    }

    static abstract class MyBaseViewHolder extends AbstractExpandableItemViewHolder {
        TextView textView;

        public MyBaseViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }

    static class MyGroupViewHolder extends MyBaseViewHolder {
        public MyGroupViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class MyChildViewHolder extends MyBaseViewHolder {
        public MyChildViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class MyAdapter extends AbstractExpandableItemAdapter<MyGroupViewHolder, MyChildViewHolder> {
        List<MyGroupItem> mItems;
        private RetroPrice retroPrice;
        private List<RetroPrice.Mgismulgainfo.row> dataList;
        private Context context;


        public MyAdapter(Context context) {
            this.context = context;

            String json = null;
            AssetManager assetManager = context.getAssets();
            InputStream is = null;
            try {
                is = assetManager.open("test");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            RetroPrice retroPrice = new Gson().fromJson(json, RetroPrice.class);
            dataList = retroPrice.getMgismulgainfo().getRow();

            setHasStableIds(true);

            mItems = new ArrayList<>();
            List<GuName> list = new ArrayList<>();
            list.add(new GuName("종로구", 0));
            list.add(new GuName("중구", 0));
            list.add(new GuName("용산구", 0));
            list.add(new GuName("성동구", 0));
            list.add(new GuName("광진구", 0));
            list.add(new GuName("동대문구", 0));
            list.add(new GuName("중랑구", 0));
            list.add(new GuName("성북구", 0));
            list.add(new GuName("강북구", 0));
            list.add(new GuName("도봉구", 0));
            list.add(new GuName("노원구", 0));
            list.add(new GuName("은평구", 0));
            list.add(new GuName("서대문구", 0));
            list.add(new GuName("마포구", 0));
            list.add(new GuName("양천구", 0));
            list.add(new GuName("강서구", 0));
            list.add(new GuName("구로구", 0));
            list.add(new GuName("금천구", 0));
            list.add(new GuName("영등포구", 0));
            list.add(new GuName("동작구", 0));
            list.add(new GuName("관악구", 0));
            list.add(new GuName("서초구", 0));
            list.add(new GuName("강남구", 0));
            list.add(new GuName("송파구", 0));
            list.add(new GuName("강동구", 0));
            for (int i = 0; i < dataList.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (dataList.get(i).getcOT_GU_NAME().equals(list.get(j).getGuName())) {
                        list.get(j).setCurrent(list.get(j).getCurrent() + 1);
                        list.get(j).getList().add(dataList.get(i));
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                MyGroupItem groupItem = new MyGroupItem(i, list.get(i).getGuName());
                for (int j = 0; j < list.get(i).getList().size(); j++) {
                    groupItem.children.add(new MyChildItem(j, list.get(i).getList().get(j).getcOT_CONTS_NAME()));
                }
                mItems.add(groupItem);
            }
        }

        @Override
        public int getGroupCount() {
            return mItems.size();
        }

        @Override
        public int getChildCount(int groupPosition) {
            return mItems.get(groupPosition).children.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return mItems.get(groupPosition).id;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return mItems.get(groupPosition).children.get(childPosition).id;
        }

        @Override
        public MyGroupViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_group_item_for_expandable_minimal, parent, false);
            return new MyGroupViewHolder(v);
        }

        @Override
        public MyChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_child_item_for_expandable_minimal, parent, false);
            return new MyChildViewHolder(v);
        }

        @Override
        public void onBindGroupViewHolder(MyGroupViewHolder holder, int groupPosition, int viewType) {
            MyGroupItem group = mItems.get(groupPosition);
            holder.textView.setText(group.text);
        }

        @Override
        public void onBindChildViewHolder(MyChildViewHolder holder, int groupPosition, int childPosition, int viewType) {
            MyChildItem child = mItems.get(groupPosition).children.get(childPosition);
            holder.textView.setText(child.text);
        }

        @Override
        public boolean onCheckCanExpandOrCollapseGroup(MyGroupViewHolder holder, int groupPosition, int x, int y, boolean expand) {
            return true;
        }
    }
}