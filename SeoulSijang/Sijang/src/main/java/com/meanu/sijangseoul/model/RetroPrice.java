package com.meanu.sijangseoul.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RetroPrice implements Serializable {


    @SerializedName("Mgismulgainfo")
    public Mgismulgainfo Mgismulgainfo;

    public Mgismulgainfo getMgismulgainfo() {
        return Mgismulgainfo;
    }


    public interface Service {
        @GET("%20/%20/{sijangName}/")
        Call<RetroPrice> getService(@Path("sijangName") String sijangName);

    }

    public class Mgismulgainfo {

        @SerializedName("list_total_count")
        public int listTotalCount;
        @SerializedName("RESULT")
        public RESULT rESULT;
        @SerializedName("row")
        public List<row> row = new ArrayList<>();

        public List<RetroPrice.Mgismulgainfo.row> getRow() {
            return row;
        }

        public class RESULT {

            @SerializedName("CODE")
            public String cODE;
            @SerializedName("MESSAGE")
            public String mESSAGE;

        }

        public class row implements Serializable {

            @SerializedName("COT_ADDR_FULL_NEW")
            public String cOT_ADDR_FULL_NEW;
            @SerializedName("COT_ADDR_FULL_OLD")
            public String cOT_ADDR_FULL_OLD;
            @SerializedName("COT_COORD_X")
            public double cOT_COORD_X;
            @SerializedName("COT_COORD_Y")
            public double cOT_COORD_Y;
            @SerializedName("COT_CONTS_ID")
            public String cOT_CONTS_ID;
            @SerializedName("COT_CONTS_LAN_TYPE")
            public String cOT_CONTS_LAN_TYPE;
            @SerializedName("COT_CONTS_NAME")
            public String cOT_CONTS_NAME;
            @SerializedName("COT_SI_NAME")
            public String cOT_SI_NAME;
            @SerializedName("COT_GU_NAME")
            public String cOT_GU_NAME;
            @SerializedName("COT_DONG_NAME")
            public String cOT_DONG_NAME;
            @SerializedName("COT_SAN_NAME")
            public String cOT_SAN_NAME;
            @SerializedName("COT_MASTER_NO")
            public String cOT_MASTER_NO;
            @SerializedName("COT_SLAVE_NO")
            public String cOT_SLAVE_NO;
            @SerializedName("COT_EXTRA_NAME")
            public String cOT_EXTRA_NAME;
            @SerializedName("COT_TEL_NO")
            public String cOT_TEL_NO;
            @SerializedName("COT_VALUE_01")
            public String cOT_VALUE_01;
            @SerializedName("COT_VALUE_02")
            public String cOT_VALUE_02;
            @SerializedName("COT_VALUE_03")
            public String cOT_VALUE_03;
            @SerializedName("COT_VALUE_04")
            public String cOT_VALUE_04;
            @SerializedName("COT_VALUE_05")
            public String cOT_VALUE_05;
            @SerializedName("COT_VALUE_06")
            public String cOT_VALUE_06;
            @SerializedName("COT_VALUE_07")
            public String cOT_VALUE_07;
            @SerializedName("COT_VALUE_08")
            public String cOT_VALUE_08;
            @SerializedName("COT_VALUE_09")
            public String cOT_VALUE_09;
            @SerializedName("COT_VALUE_10")
            public String cOT_VALUE_10;
            @SerializedName("COT_VALUE_11")
            public String cOT_VALUE_11;
            @SerializedName("COT_VALUE_12")
            public String cOT_VALUE_12;
            @SerializedName("COT_VALUE_13")
            public String cOT_VALUE_13;
            @SerializedName("COT_VALUE_14")
            public String cOT_VALUE_14;
            @SerializedName("COT_VALUE_15")
            public String cOT_VALUE_15;
            @SerializedName("COT_VALUE_16")
            public String cOT_VALUE_16;
            @SerializedName("COT_VALUE_17")
            public String cOT_VALUE_17;
            @SerializedName("COT_VALUE_18")
            public String cOT_VALUE_18;
            @SerializedName("COT_VALUE_19")
            public String cOT_VALUE_19;
            @SerializedName("COT_VALUE_20")
            public String cOT_VALUE_20;
            @SerializedName("COT_NAME_01")
            public String cOT_NAME_01;
            @SerializedName("COT_NAME_02")
            public String cOT_NAME_02;
            @SerializedName("COT_NAME_03")
            public String cOT_NAME_03;
            @SerializedName("COT_NAME_04")
            public String cOT_NAME_04;
            @SerializedName("COT_NAME_05")
            public String cOT_NAME_05;
            @SerializedName("COT_NAME_06")
            public String cOT_NAME_06;
            @SerializedName("COT_NAME_07")
            public String cOT_NAME_07;
            @SerializedName("COT_NAME_08")
            public String cOT_NAME_08;
            @SerializedName("COT_NAME_09")
            public String cOT_NAME_09;
            @SerializedName("COT_NAME_10")
            public String cOT_NAME_10;
            @SerializedName("COT_NAME_11")
            public String cOT_NAME_11;
            @SerializedName("COT_NAME_12")
            public String cOT_NAME_12;
            @SerializedName("COT_NAME_13")
            public String cOT_NAME_13;
            @SerializedName("COT_NAME_14")
            public String cOT_NAME_14;
            @SerializedName("COT_NAME_15")
            public String cOT_NAME_15;
            @SerializedName("COT_NAME_16")
            public String cOT_NAME_16;
            @SerializedName("COT_NAME_17")
            public String cOT_NAME_17;
            @SerializedName("COT_NAME_18")
            public String cOT_NAME_18;
            @SerializedName("COT_NAME_19")
            public String cOT_NAME_19;
            @SerializedName("COT_NAME_20")
            public String cOT_NAME_20;
            @SerializedName("COT_COORD_DATA")
            public String cOT_COORD_DATA;
            @SerializedName("COT_COORD_TYPE")
            public String cOT_COORD_TYPE;
            @SerializedName("COT_LINE_WEIGHT")
            public String cOT_LINE_WEIGHT;
            @SerializedName("COT_LINE_COLOR")
            public String cOT_LINE_COLOR;
            @SerializedName("COT_KW")
            public String cOT_KW;
            @SerializedName("COT_REG_DATE")
            public String cOT_REG_DATE;
            @SerializedName("COT_UPDATE_DATE")
            public String cOT_UPDATE_DATE;

            public String getcOT_ADDR_FULL_NEW() {
                return cOT_ADDR_FULL_NEW;
            }

            public String getcOT_ADDR_FULL_OLD() {
                return cOT_ADDR_FULL_OLD;
            }

            public double getcOT_COORD_X() {
                return cOT_COORD_X;
            }

            public double getcOT_COORD_Y() {
                return cOT_COORD_Y;
            }

            public String getcOT_CONTS_ID() {
                return cOT_CONTS_ID;
            }

            public String getcOT_CONTS_LAN_TYPE() {
                return cOT_CONTS_LAN_TYPE;
            }

            public String getcOT_CONTS_NAME() {
                return cOT_CONTS_NAME;
            }

            public void setcOT_CONTS_NAME(String cOT_CONTS_NAME) {
                this.cOT_CONTS_NAME = cOT_CONTS_NAME;
            }

            public String getcOT_SI_NAME() {
                return cOT_SI_NAME;
            }

            public String getcOT_GU_NAME() {
                return cOT_GU_NAME;
            }

            public void setcOT_GU_NAME(String cOT_GU_NAME) {
                this.cOT_GU_NAME = cOT_GU_NAME;
            }

            public String getcOT_DONG_NAME() {
                return cOT_DONG_NAME;
            }

            public String getcOT_SAN_NAME() {
                return cOT_SAN_NAME;
            }

            public String getcOT_MASTER_NO() {
                return cOT_MASTER_NO;
            }

            public String getcOT_SLAVE_NO() {
                return cOT_SLAVE_NO;
            }

            public String getcOT_EXTRA_NAME() {
                return cOT_EXTRA_NAME;
            }

            public String getcOT_TEL_NO() {
                return cOT_TEL_NO;
            }

            public String getcOT_VALUE_01() {
                return cOT_VALUE_01;
            }

            public String getcOT_VALUE_02() {
                return cOT_VALUE_02;
            }

            public String getcOT_VALUE_03() {
                return cOT_VALUE_03;
            }

            public String getcOT_VALUE_04() {
                return cOT_VALUE_04;
            }

            public String getcOT_VALUE_05() {
                return cOT_VALUE_05;
            }

            public String getcOT_VALUE_06() {
                return cOT_VALUE_06;
            }

            public String getcOT_VALUE_07() {
                return cOT_VALUE_07;
            }

            public String getcOT_VALUE_08() {
                return cOT_VALUE_08;
            }

            public String getcOT_VALUE_09() {
                return cOT_VALUE_09;
            }

            public String getcOT_VALUE_10() {
                return cOT_VALUE_10;
            }

            public String getcOT_VALUE_11() {
                return cOT_VALUE_11;
            }

            public String getcOT_VALUE_12() {
                return cOT_VALUE_12;
            }

            public String getcOT_VALUE_13() {
                return cOT_VALUE_13;
            }

            public String getcOT_VALUE_14() {
                return cOT_VALUE_14;
            }

            public String getcOT_VALUE_15() {
                return cOT_VALUE_15;
            }

            public String getcOT_VALUE_16() {
                return cOT_VALUE_16;
            }

            public String getcOT_VALUE_17() {
                return cOT_VALUE_17;
            }

            public String getcOT_VALUE_18() {
                return cOT_VALUE_18;
            }

            public String getcOT_VALUE_19() {
                return cOT_VALUE_19;
            }

            public String getcOT_VALUE_20() {
                return cOT_VALUE_20;
            }

            public String getcOT_NAME_01() {
                return cOT_NAME_01;
            }

            public String getcOT_NAME_02() {
                return cOT_NAME_02;
            }

            public String getcOT_NAME_03() {
                return cOT_NAME_03;
            }

            public String getcOT_NAME_04() {
                return cOT_NAME_04;
            }

            public String getcOT_NAME_05() {
                return cOT_NAME_05;
            }

            public String getcOT_NAME_06() {
                return cOT_NAME_06;
            }

            public String getcOT_NAME_07() {
                return cOT_NAME_07;
            }

            public String getcOT_NAME_08() {
                return cOT_NAME_08;
            }

            public String getcOT_NAME_09() {
                return cOT_NAME_09;
            }

            public String getcOT_NAME_10() {
                return cOT_NAME_10;
            }

            public String getcOT_NAME_11() {
                return cOT_NAME_11;
            }

            public String getcOT_NAME_12() {
                return cOT_NAME_12;
            }

            public String getcOT_NAME_13() {
                return cOT_NAME_13;
            }

            public String getcOT_NAME_14() {
                return cOT_NAME_14;
            }

            public String getcOT_NAME_15() {
                return cOT_NAME_15;
            }

            public String getcOT_NAME_16() {
                return cOT_NAME_16;
            }

            public String getcOT_NAME_17() {
                return cOT_NAME_17;
            }

            public String getcOT_NAME_18() {
                return cOT_NAME_18;
            }

            public String getcOT_NAME_19() {
                return cOT_NAME_19;
            }

            public String getcOT_NAME_20() {
                return cOT_NAME_20;
            }

            public String getcOT_COORD_DATA() {
                return cOT_COORD_DATA;
            }

            public String getcOT_COORD_TYPE() {
                return cOT_COORD_TYPE;
            }

            public String getcOT_LINE_WEIGHT() {
                return cOT_LINE_WEIGHT;
            }

            public String getcOT_LINE_COLOR() {
                return cOT_LINE_COLOR;
            }

            public String getcOT_KW() {
                return cOT_KW;
            }

            public String getcOT_REG_DATE() {
                return cOT_REG_DATE;
            }

            public String getcOT_UPDATE_DATE() {
                return cOT_UPDATE_DATE;
            }
        }
    }
}
