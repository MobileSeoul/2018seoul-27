package com.meanu.sijangseoul.Detail;

import android.app.FragmentManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResponse;
import com.google.android.gms.location.places.PlacePhotoResponse;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.meanu.sijangseoul.R;
import com.meanu.sijangseoul.model.PlaceID;
import com.meanu.sijangseoul.model.RetroPrice;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String EXTRA_NAME = "key";
    private static final String TAG = "stelli";
    private RetroPrice retroPrice;
    private RecyclerView mRecyclerView;
    private GeoDataClient mGeoDataClient;
    private PlaceID placeID;
    private RetroPrice.Mgismulgainfo.row dataList;
    private ConnectivityManager cm;
//    private boolean canAddItem = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.detail_activity);
        TextView dateSearch = findViewById(R.id.dateSearch);
        View view = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (view != null) {
                view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(Color.parseColor("#e8d5c3"));
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.BLACK);
        }

        dataList = (RetroPrice.Mgismulgainfo.row) getIntent().getSerializableExtra(EXTRA_NAME);
        dateSearch.setText(dataList.getcOT_NAME_01());
        setBackgroundImage();

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(dataList.getcOT_CONTS_NAME());
        Typeface font = ResourcesCompat.getFont(this, R.font.name_font);
        collapsingToolbar.setCollapsedTitleTypeface(font);
        collapsingToolbar.setExpandedTitleTypeface(font);

        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mRecyclerView = view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));

        List<String> dataName = new ArrayList<>();
        dataName.add(dataList.getcOT_NAME_02());
        dataName.add(dataList.getcOT_NAME_03());
        dataName.add(dataList.getcOT_NAME_04());
        dataName.add(dataList.getcOT_NAME_05());
        dataName.add(dataList.getcOT_NAME_06());
        dataName.add(dataList.getcOT_NAME_07());
        dataName.add(dataList.getcOT_NAME_08());
        dataName.add(dataList.getcOT_NAME_09());
        dataName.add(dataList.getcOT_NAME_10());
        dataName.add(dataList.getcOT_NAME_11());
        dataName.add(dataList.getcOT_NAME_12());
        dataName.add(dataList.getcOT_NAME_13());
        dataName.add(dataList.getcOT_NAME_14());
        dataName.add(dataList.getcOT_NAME_15());
        dataName.add(dataList.getcOT_NAME_16());
        dataName.add(dataList.getcOT_NAME_17());
        dataName.add(dataList.getcOT_NAME_18());
        dataName.add(dataList.getcOT_NAME_19());
        List<String> dataPrice = new ArrayList<>();
        dataPrice.add(dataList.getcOT_VALUE_02());
        dataPrice.add(dataList.getcOT_VALUE_03());
        dataPrice.add(dataList.getcOT_VALUE_04());
        dataPrice.add(dataList.getcOT_VALUE_05());
        dataPrice.add(dataList.getcOT_VALUE_06());
        dataPrice.add(dataList.getcOT_VALUE_07());
        dataPrice.add(dataList.getcOT_VALUE_08());
        dataPrice.add(dataList.getcOT_VALUE_09());
        dataPrice.add(dataList.getcOT_VALUE_10());
        dataPrice.add(dataList.getcOT_VALUE_11());
        dataPrice.add(dataList.getcOT_VALUE_12());
        dataPrice.add(dataList.getcOT_VALUE_13());
        dataPrice.add(dataList.getcOT_VALUE_14());
        dataPrice.add(dataList.getcOT_VALUE_15());
        dataPrice.add(dataList.getcOT_VALUE_16());
        dataPrice.add(dataList.getcOT_VALUE_17());
        dataPrice.add(dataList.getcOT_VALUE_18());
        dataPrice.add(dataList.getcOT_VALUE_19());
        mRecyclerView.setAdapter(new DetailAAdapter(mRecyclerView.getContext(), dataName, dataPrice));

    }

    private void setBackgroundImage() {

        mGeoDataClient = Places.getGeoDataClient(this);

        String json = null;
        AssetManager assetManager = this.getAssets();
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
        final ImageView background = findViewById(R.id.background);
        if (isNetworkConnected()) {
            for (int i = 0; i < placeID.getMeanulist().size(); i++) {
                if (dataList.getcOT_CONTS_NAME().equals(placeID.getMeanulist().get(i).SIJANG_NAME)) {
                    final Task<PlacePhotoMetadataResponse> photoMetadataResponse = mGeoDataClient.getPlacePhotos(placeID.getMeanulist().get(i).PLACE_ID);
                    photoMetadataResponse.addOnCompleteListener(new OnCompleteListener<PlacePhotoMetadataResponse>() {
                        @Override
                        public void onComplete(@NonNull Task<PlacePhotoMetadataResponse> task) {
                            // Get the list of photos.
                            PlacePhotoMetadataResponse photos = task.getResult();
                            // Get the PlacePhotoMetadataBuffer (metadata for all of the photos).
                            PlacePhotoMetadataBuffer photoMetadataBuffer = photos.getPhotoMetadata();
                            // Get the first photo in the list.
                            PlacePhotoMetadata photoMetadata = photoMetadataBuffer.get(1);
                            // Get the attribution text.
//                            CharSequence attribution = photoMetadata.getAttributions();
                            // Get a full-size bitmap for the photo.
                            Task<PlacePhotoResponse> photoResponse = mGeoDataClient.getPhoto(photoMetadata);
                            photoResponse.addOnCompleteListener(new OnCompleteListener<PlacePhotoResponse>() {
                                @Override
                                public void onComplete(@NonNull Task<PlacePhotoResponse> task) {
                                    PlacePhotoResponse photo = task.getResult();
                                    Bitmap bitmap = photo.getBitmap();
                                    background.setImageBitmap(bitmap);

                                }
                            });
                        }
                    });
                } else if (dataList.cOT_CONTS_NAME.equals("신창시장")) {
                    background.setImageResource(R.drawable.peaches);
                } else if (dataList.cOT_CONTS_NAME.equals("방림시장")) {
                    background.setImageResource(R.drawable.apples);
                } else if (dataList.cOT_CONTS_NAME.equals("청담삼익시장")) {
                    background.setImageResource(R.drawable.olives);
                } else if (dataList.cOT_CONTS_NAME.equals("현대시장")) {
                    background.setImageResource(R.drawable.market);
                }
            }
        } else {
            Random random = new Random();
            int a = random.nextInt(4);
            switch (a) {
                case 0:
                    background.setImageResource(R.drawable.peaches);
                case 1:
                    background.setImageResource(R.drawable.peaches);
                case 2:
                    background.setImageResource(R.drawable.peaches);
                case 3:
                    background.setImageResource(R.drawable.peaches);
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.heart) {
//            invalidateOptionsMenu();
//        }
        return super.onOptionsItemSelected(item);

    }

//    public boolean onPrepareOptionsMenu(Menu menu) {
//        View parentLayout = findViewById(android.R.id.content);
//        if (canAddItem) {
//            menu.getItem(0).setIcon(R.drawable.heart);
////            SharedPreference.addFavorite(this, dataList);
//            Snackbar.make(parentLayout, "구독 시장에 추가", Snackbar.LENGTH_LONG)
//                    .setAction("YES", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                        }
//                    }).show();
//            canAddItem = false;
//        } else {
//            menu.getItem(0).setIcon(R.drawable.heart_outline);
////            SharedPreference.removeFavorite(this, dataList);
//            Snackbar.make(parentLayout, "구독 시장에서 제거", Snackbar.LENGTH_LONG)
//                    .setAction("YES", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                        }
//                    }).show();
//            canAddItem = true;
//        }
//
//        return super.onPrepareOptionsMenu(menu);
//    }


    @Override
    public void onMapReady(final GoogleMap map) {
        LatLng sijang = new LatLng(dataList.getcOT_COORD_Y(), dataList.getcOT_COORD_X());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(sijang);
        markerOptions.title(dataList.getcOT_CONTS_NAME());
        markerOptions.snippet(dataList.getcOT_ADDR_FULL_NEW());
        map.addMarker(markerOptions);
        map.moveCamera(CameraUpdateFactory.newLatLng(sijang));
        map.animateCamera(CameraUpdateFactory.zoomTo(16));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_detail, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    private boolean isNetworkConnected() {
        cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
