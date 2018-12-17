package com.meanu.sijangseoul.Backdrop;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meanu.sijangseoul.R;

import java.util.Objects;

import butterknife.ButterKnife;

public class BackdropCFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.backdrop_c_fragment, container, false);
        ButterKnife.bind(this, view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.findViewById(R.id.NestedScrollView).setBackground(Objects.requireNonNull(getContext()).getDrawable(R.drawable.backdrop_shape));
        }
        return view;
    }
}
