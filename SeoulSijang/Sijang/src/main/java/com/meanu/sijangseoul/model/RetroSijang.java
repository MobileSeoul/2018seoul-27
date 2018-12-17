package com.meanu.sijangseoul.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RetroSijang {
    public RetroSijang.MgisTraShop getMgisTraShop() {
        return MgisTraShop;
    }

    public void setMgisTraShop(RetroSijang.MgisTraShop mgisTraShop) {
        MgisTraShop = mgisTraShop;
    }

    @SerializedName("MgisTraShop")
    MgisTraShop MgisTraShop;

    public class MgisTraShop {
        @SerializedName("list_total_count")
        int list_total_count;
        RESULT RESULT;

        public List<row> row = new ArrayList<>();

        public List<RetroSijang.MgisTraShop.row> getRow() {
            return row;
        }

        class RESULT {

        }

        public class row {

            @SerializedName("COT_ADDR_FULL_NEW")
            String COT_ADDR_FULL_NEW;

            public String getCOT_ADDR_FULL_NEW() {
                return COT_ADDR_FULL_NEW;
            }

            public Float getCOT_COORD_X() {
                return COT_COORD_X;
            }

            public Float getCOT_COORD_Y() {
                return COT_COORD_Y;
            }

            //            @SerializedName("COT_ADDR_FULL_OLD")
//            String COT_ADDR_FULL_OLD;
            @SerializedName("COT_COORD_X")
            Float COT_COORD_X;
            @SerializedName("COT_COORD_Y")
            Float COT_COORD_Y;
            @SerializedName("COT_CONTS_NAME")
            String COT_CONTS_NAME;

            public String getCOT_CONTS_NAME() {
                return COT_CONTS_NAME;
            }

            @SerializedName("COT_GU_NAME")
            String COT_GU_NAME;
            @SerializedName("COT_DONG_NAME")
            String COT_DONG_NAME;

            public String getCOT_GU_NAME() {
                return COT_GU_NAME;
            }

            public String getCOT_DONG_NAME() {
                return COT_DONG_NAME;
            }
//            @SerializedName("COT_MASTER_NO")
//            int COT_MASTER_NO;


//            @SerializedName("COT_VALUE_02")
//            String COT_VALUE_02;
//            @SerializedName("COT_VALUE_03")
//            String COT_VALUE_03;
//            @SerializedName("COT_VALUE_04")
//            String COT_VALUE_04;
//            @SerializedName("COT_VALUE_05")
//            String COT_VALUE_05;
//            @SerializedName("COT_VALUE_06")
//            String COT_VALUE_06;
//            @SerializedName("COT_VALUE_07")
//            String COT_VALUE_07;
//            @SerializedName("COT_VALUE_08")
//            String COT_VALUE_08;
//            @SerializedName("COT_VALUE_09")
//            String COT_VALUE_09;
//            @SerializedName("COT_VALUE_10")
//            String COT_VALUE_10;
//            @SerializedName("COT_VALUE_11")
//            String COT_VALUE_11;
//            @SerializedName("COT_VALUE_12")
//            String COT_VALUE_12;
//            @SerializedName("COT_VALUE_13")
//            String COT_VALUE_13;
//            @SerializedName("COT_VALUE_14")
//            String COT_VALUE_14;
//            @SerializedName("COT_VALUE_15")
//            String COT_VALUE_15;
//            @SerializedName("COT_VALUE_16")
//            String COT_VALUE_16;
//            @SerializedName("COT_VALUE_17")
//            String COT_VALUE_17;
//            @SerializedName("COT_VALUE_18")
//            String COT_VALUE_18;
//
//
//            @SerializedName("COT_NAME_01")
//            String serachDate;
//            @SerializedName("COT_NAME_02")
//            String COT_NAME_02;
//            @SerializedName("COT_NAME_03")
//            String COT_NAME_03;
//            @SerializedName("COT_NAME_04")
//            String COT_NAME_04;
//            @SerializedName("COT_NAME_05")
//            String COT_NAME_05;
//            @SerializedName("COT_NAME_06")
//            String COT_NAME_06;
//            @SerializedName("COT_NAME_07")
//            String COT_NAME_07;
//            @SerializedName("COT_NAME_08")
//            String COT_NAME_08;
//            @SerializedName("COT_NAME_09")
//            String COT_NAME_09;
//            @SerializedName("COT_NAME_10")
//            String COT_NAME_10;
//            @SerializedName("COT_NAME_11")
//            String COT_NAME_11;
//            @SerializedName("COT_NAME_12")
//            String COT_NAME_13;
//            @SerializedName("COT_NAME_14")
//            String COT_NAME_14;
//            @SerializedName("COT_NAME_15")
//            String COT_NAME_15;
//            @SerializedName("COT_NAME_16")
//            String COT_NAME_16;
//            @SerializedName("COT_NAME_17")
//            String COT_NAME_17;
//            @SerializedName("COT_NAME_18")
//            String COT_NAME_18;
//
//            @SerializedName("COT_UPDATE_DATE")
//            String COT_UPDATE_DATE;

        }
    }

    public interface Service {
        @GET("%20/%20/{sijangName}")
        Call<RetroSijang> getService(@Path("sijangName") String sijangName);

    }

}
