package com.meanu.sijangseoul.Product;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResponse;
import com.google.android.gms.location.places.PlacePhotoResponse;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.meanu.sijangseoul.R;
import com.meanu.sijangseoul.model.PlaceID;
import com.meanu.sijangseoul.model.RetroPrice;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<RetroPrice.Mgismulgainfo.row> dataList;
    private int itemLayout;
    private double locationX;
    private double locationY;
    private GeoDataClient mGeoDataClient;
    private PlaceID placeID;
    private ConnectivityManager cm;

    public ProductAdapter(List<RetroPrice.Mgismulgainfo.row> dataList, int itemLayout, double locationX, double locationY, Context context) {
        this.dataList = dataList;
        this.itemLayout = itemLayout;
        this.locationX = locationX;
        this.locationY = locationY;

        mGeoDataClient = Places.getGeoDataClient(context);

        String json = null;
        AssetManager assetManager = context.getAssets();
        InputStream is = null;
        try {
            is = assetManager.open("placeid.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        placeID = new Gson().fromJson(json, PlaceID.class);

        cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductAdapter.ViewHolder viewHolder, final int position) {

        if (isNetworkConnected()) {
            for (int i = 0; i < placeID.Meanulist.size(); i++) {
                if (dataList.get(position).cOT_CONTS_NAME.equals(placeID.getMeanulist().get(i).SIJANG_NAME)) {
                    Log.d("stelli", placeID.getMeanulist().get(i).PLACE_ID + dataList.get(position).getcOT_CONTS_NAME() + "=" + placeID.getMeanulist().get(i).getSIJANG_NAME());
                    final Task<PlacePhotoMetadataResponse> photoMetadataResponse = mGeoDataClient.getPlacePhotos(placeID.getMeanulist().get(i).PLACE_ID);
                    photoMetadataResponse.addOnCompleteListener(new OnCompleteListener<PlacePhotoMetadataResponse>() {
                        @Override
                        public void onComplete(@NonNull Task<PlacePhotoMetadataResponse> task) {
                            PlacePhotoMetadataResponse photos = task.getResult();
                            PlacePhotoMetadataBuffer photoMetadataBuffer = photos.getPhotoMetadata();
                            PlacePhotoMetadata photoMetadata = photoMetadataBuffer.get(0);
                            Task<PlacePhotoResponse> photoResponse = mGeoDataClient.getPhoto(photoMetadata);
                            photoResponse.addOnCompleteListener(new OnCompleteListener<PlacePhotoResponse>() {
                                @Override
                                public void onComplete(@NonNull Task<PlacePhotoResponse> task) {
                                    PlacePhotoResponse photo = task.getResult();
                                    Bitmap bitmap = photo.getBitmap();
                                    Bitmap resized = Bitmap.createScaledBitmap(bitmap, 160, 140, true);
                                    viewHolder.sijangImage.setImageBitmap(resized);
                                }
                            });
                        }
                    });
                } else if (dataList.get(position).cOT_CONTS_NAME.equals("신창시장")) {
                    viewHolder.sijangImage.setImageResource(R.drawable.peaches);
                } else if (dataList.get(position).cOT_CONTS_NAME.equals("방림시장")) {
                    viewHolder.sijangImage.setImageResource(R.drawable.apples);
                } else if (dataList.get(position).cOT_CONTS_NAME.equals("청담삼익시장")) {
                    viewHolder.sijangImage.setImageResource(R.drawable.olives);
                } else if (dataList.get(position).cOT_CONTS_NAME.equals("현대시장")) {
                    viewHolder.sijangImage.setImageResource(R.drawable.market);
                }
            }
        } else {

            Random random = new Random();
            int a = random.nextInt(3);
            switch (a) {
                case 0:
                    viewHolder.sijangImage.setImageResource(R.drawable.peaches);
                case 1:
                    viewHolder.sijangImage.setImageResource(R.drawable.apples);
                case 2:
                    viewHolder.sijangImage.setImageResource(R.drawable.olives);
                case 3:
                    viewHolder.sijangImage.setImageResource(R.drawable.market);
            }
        }

        Location locationA = new Location("1");
        locationA.setLongitude(locationX);//x
        locationA.setLatitude(locationY);//y
        Location locationB = new Location("2");
        locationB.setLongitude(dataList.get(position).getcOT_COORD_X());
        locationB.setLatitude(dataList.get(position).getcOT_COORD_Y());
        double distance = locationA.distanceTo(locationB) / 1000;
        String result = String.format("%.2f", distance);
        RetroPrice.Mgismulgainfo.row item = dataList.get(position);

        if (dataList.get(position).cOT_CONTS_NAME.equals("행복한세상 목동점(하나로마트)")) {
            viewHolder.textTitle.setText("하나로마트 목동점");
        } else {
            viewHolder.textTitle.setText(item.getcOT_CONTS_NAME());
        }
        viewHolder.textSubTitle.setText(item.getcOT_ADDR_FULL_OLD());
        viewHolder.textDistance.setText(result + "km");
        viewHolder.itemView.setTag(item);
    }


    @Override
    public int getItemCount() {
        return 9;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textTitle;
        public TextView textSubTitle;
        public TextView textDistance;
        public ImageView sijangImage;

        public ViewHolder(View itemView) {
            super(itemView);
            sijangImage = itemView.findViewById(R.id.product_image);
            textTitle = itemView.findViewById(R.id.text_title);
            textSubTitle = itemView.findViewById(R.id.text_subtitle);
            textDistance = itemView.findViewById(R.id.text_distance);
        }
    }

    private boolean isNetworkConnected() {
        return cm.getActiveNetworkInfo() != null;
    }
}