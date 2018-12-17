package com.meanu.sijangseoul.Search;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.meanu.sijangseoul.R;
import com.meanu.sijangseoul.Util.PriceGenerator;
import com.meanu.sijangseoul.Util.RecyclerItemClickListener;
import com.meanu.sijangseoul.model.RetroPrice;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment {
    private String TAG = "stelli";
    private OnPickerSetListener onPickerSetListener;
    private SearchAdapter adapter;
    private RecyclerView mRecyclerView;
    private RetroPrice retroPrice;
    private String sijangName;
    private String guName;
    private String dongName;
    private double locationX;
    private double locationY;
    @BindView(R.id.text_intput_search)
    TextInputEditText editText;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.search_list_fragment, container, false);
        View v = getActivity().getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (v != null) {
                v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getActivity().getWindow().setStatusBarColor(Color.parseColor("#e8d5c3"));
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            getActivity().getWindow().setStatusBarColor(Color.BLACK);
        }
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch(view);
                    return true;
                }
                return false;
            }
        });

        initLayout(view);

        retrofitParsing("");
        editTextFilter();
        addOnItemTouchListener();

        return view;
    }

    private void editTextFilter() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mRecyclerView.setAdapter(adapter);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editText.getText().toString();
                adapter.filter(text);
            }
        });
    }

    private void addOnItemTouchListener() {
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        locationX = retroPrice.getMgismulgainfo().getRow().get(position).getcOT_COORD_X();
                        locationY = retroPrice.getMgismulgainfo().getRow().get(position).getcOT_COORD_Y();
                        sijangName = retroPrice.getMgismulgainfo().getRow().get(position).getcOT_CONTS_NAME();
                        guName = retroPrice.getMgismulgainfo().getRow().get(position).getcOT_GU_NAME();
                        dongName = retroPrice.getMgismulgainfo().getRow().get(position).getcOT_DONG_NAME();
                        onPickerSetListener.onPickerSet(sijangName, guName, dongName, locationX, locationY, position);
                        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                        getActivity().onBackPressed();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }

    private void performSearch(View v) {
        if (mRecyclerView.getChildCount() == 0) {
            if (isSearchValid(editText.getText())) {
                editText.setError(getString(R.string.search_error));
            }
        } else {
            String title = ((TextView) mRecyclerView.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.label)).getText().toString();
            for (int i = 0; i < retroPrice.getMgismulgainfo().getRow().size(); i++) {
                if (title.equals(retroPrice.getMgismulgainfo().getRow().get(i).getcOT_CONTS_NAME())) {
                    guName = retroPrice.getMgismulgainfo().getRow().get(i).getcOT_GU_NAME();
                    dongName = retroPrice.getMgismulgainfo().getRow().get(i).getcOT_DONG_NAME();
                    locationX = retroPrice.getMgismulgainfo().getRow().get(i).getcOT_COORD_X();
                    locationY = retroPrice.getMgismulgainfo().getRow().get(i).getcOT_COORD_Y();
                }
            }
            onPickerSetListener.onPickerSet(
                    title,
                    guName,
                    dongName,
                    locationX,
                    locationY,
                    0
            );
            InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            getActivity().onBackPressed();

        }

        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

    }

    private void generateDataList(List<RetroPrice.Mgismulgainfo.row> dataList) {
        adapter = new SearchAdapter(dataList, R.layout.row_search_list_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    private void initLayout(View view) {
        mRecyclerView = view.findViewById(R.id.listView);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPickerSetListener) {
            onPickerSetListener = (OnPickerSetListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + "must implement OnPickerSetListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onPickerSetListener = null;
    }

    void retrofitParsing(String sijangName) {
        RetroPrice.Service service = PriceGenerator.createService(RetroPrice.Service.class);
        Call<RetroPrice> call = service.getService(sijangName);
        call.enqueue(new Callback<RetroPrice>() {
            @Override
            public void onResponse(Call<RetroPrice> call, Response<RetroPrice> response) {
                retroPrice = response.body();
                Log.d(TAG, "response.raw :" + response.raw());
                if (response.body() != null) {
                    generateDataList(retroPrice.getMgismulgainfo().getRow());

                } else {
                    Log.d(TAG, "onResponse: NULL");
                }
            }

            @Override
            public void onFailure(Call<RetroPrice> call, Throwable t) {
            }
        });
    }

    public interface OnPickerSetListener {
        void onPickerSet(String sijangName, String guName, String dondName, double locationX, double locationY, int position);
    }

    private boolean isSearchValid(@Nullable Editable text) {
        return text != null;
    }
}
