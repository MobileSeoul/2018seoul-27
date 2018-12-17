package com.meanu.sijangseoul.Detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.meanu.sijangseoul.R;
import com.meanu.sijangseoul.model.RetroPrice;

public class DetailMapFragment extends Fragment implements OnMapReadyCallback {

    private static String ARG_PARAM1 = "asd";
    private String TAG = "stelli";
    private RetroPrice.Mgismulgainfo.row dataList;


    public static DetailMapFragment newInstance(RetroPrice.Mgismulgainfo.row param1) {
        DetailMapFragment fragment = new DetailMapFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dataList = (RetroPrice.Mgismulgainfo.row) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_fragment, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.detail_map);
        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(final GoogleMap map) {

        LatLng sijang = new LatLng(dataList.getcOT_COORD_Y(), dataList.getcOT_COORD_X());

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(sijang);
        markerOptions.title(dataList.getcOT_CONTS_NAME());
        markerOptions.snippet(dataList.getcOT_ADDR_FULL_NEW());
        map.addMarker(markerOptions);

        map.moveCamera(CameraUpdateFactory.newLatLng(sijang));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

}
