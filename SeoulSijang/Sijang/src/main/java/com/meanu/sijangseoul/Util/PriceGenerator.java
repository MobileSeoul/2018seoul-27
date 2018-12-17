
package com.meanu.sijangseoul.Util;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PriceGenerator {
    private static String SEARCH_URL = "http://openapi.seoul.go.kr:8088/";
    private static String API_KEY = "4644614d7573746534316552515246";
    private static String TYPE = "json";
    private static String SERVICE = "Mgismulgainfo";
    private static int START_INDEX = 1;
    private static int END_INDEX = 102;
    private static String REQUEST_URL = SEARCH_URL + API_KEY + "/" + TYPE + "/" + SERVICE + "/" + START_INDEX + "/" + END_INDEX + "/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(REQUEST_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build());

    private static Retrofit retrofit = builder.build();

    public PriceGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}

