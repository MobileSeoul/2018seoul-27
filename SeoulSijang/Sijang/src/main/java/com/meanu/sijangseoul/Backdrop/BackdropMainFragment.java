package com.meanu.sijangseoul.Backdrop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.button.MaterialButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meanu.sijangseoul.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BackdropMainFragment extends Fragment {
    private static String ARG_PARAM1 = "stelli";
    @BindView(R.id.backdrop_A)
    MaterialButton mMaterialButton1;
//    @BindView(R.id.backdrop_B)
//    MaterialButton mMaterialButton2;
//    @BindView(R.id.backdrop_C)
//    MaterialButton mMaterialButton3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.backdrop, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.backdrop_A, R.id.backdrop_B, R.id.backdrop_C})
    void setBackdropClick(View view) {
        switch (view.getId()) {
            case R.id.backdrop_A:
                FragmentTransaction ftsA = getActivity().getSupportFragmentManager().beginTransaction();
                ftsA.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                ftsA.replace(R.id.backdrop, new BackdropListFragment(), "BackdropAFragment");
                ftsA.addToBackStack("BackdropAFragment");
                ftsA.commit();
                break;
//            case R.id.backdrop_B :
//                FragmentTransaction ftsB = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
//                ftsB.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
//                ftsB.replace(R.id.backdrop, new BackdropBFragment(),"BackdropBFragment");
//                ftsB.addToBackStack("BackdropBFragment");
//                ftsB.commit();
//                break;
//            case R.id.backdrop_C :
//                FragmentTransaction ftsC = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
//                ftsC.setCustomAnimations(R.anim.slideup, android.R.anim.fade_out);
//                ftsC.replace(R.id.product_grid, new BackdropCFragment(),"BackdropCFragment");
//                ftsC.addToBackStack("BackdropCFragment");
//                ftsC.commit();
//                break;
        }
    }
}
