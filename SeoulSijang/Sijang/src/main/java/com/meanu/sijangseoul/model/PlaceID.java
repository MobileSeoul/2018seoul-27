package com.meanu.sijangseoul.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlaceID implements Serializable {
    @SerializedName("Meanulist")
    public List<Meanulist> Meanulist = new ArrayList<>();

    public List<PlaceID.Meanulist> getMeanulist() {
        return Meanulist;
    }

    public class Meanulist implements Serializable {

        @SerializedName("SIJANG_NAME")
        public String SIJANG_NAME;
        @SerializedName("PLACE_ID")
        public String PLACE_ID;

        public String getSIJANG_NAME() {
            return SIJANG_NAME;
        }

        public String getPLACE_ID() {
            return PLACE_ID;
        }
    }

}
