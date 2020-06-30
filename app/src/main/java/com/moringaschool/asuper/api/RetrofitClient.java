package com.moringaschool.asuper.api;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://api-shop-url.herokuapp.com/";
    private static RetrofitClient mInstance;
    private static Retrofit retrofit;
    private static Gson gson;


    private RetrofitClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
        }

        // changes //

    public SuperApi getSuperApi(){
        return retrofit.create(SuperApi.class);
    }

    public SuperApi create(Class<SuperApi> superApiClass) {
        return null;
    }
}
