package com.meanu.sijangseoul.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;
import com.meanu.sijangseoul.model.RetroPrice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreference {

    public static final String PREFS_NAME = "PRODUCT_APP";
    public static final String FAVORITES = "Product_Favorite";

    public SharedPreference() {
        super();
    }

    public void saveFavorites(Context context, List<RetroPrice.Mgismulgainfo.row> favorites) {
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }

    public void addFavorite(Context context, RetroPrice.Mgismulgainfo.row product) {
        List<RetroPrice.Mgismulgainfo.row> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<RetroPrice.Mgismulgainfo.row>();
        favorites.add(product);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, RetroPrice.Mgismulgainfo.row product) {
        ArrayList<RetroPrice.Mgismulgainfo.row> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(product);
            saveFavorites(context, favorites);
        }
    }

    public ArrayList<RetroPrice.Mgismulgainfo.row> getFavorites(Context context) {
        SharedPreferences settings;
        List<RetroPrice.Mgismulgainfo.row> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            RetroPrice.Mgismulgainfo.row[] favoriteItems = gson.fromJson(jsonFavorites,
                    RetroPrice.Mgismulgainfo.row[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<RetroPrice.Mgismulgainfo.row>(favorites);
        } else
            return null;

        return (ArrayList<RetroPrice.Mgismulgainfo.row>) favorites;
    }
}