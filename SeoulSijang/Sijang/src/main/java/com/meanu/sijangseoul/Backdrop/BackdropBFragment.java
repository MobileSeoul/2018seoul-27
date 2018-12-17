package com.meanu.sijangseoul.Backdrop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meanu.sijangseoul.R;

import butterknife.ButterKnife;

public class BackdropBFragment extends Fragment {

    private static final String TAG = "stelli";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.backdrop_b_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
