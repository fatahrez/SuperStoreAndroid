package com.moringaschool.asuper;

import com.moringaschool.asuper.models.Admin;
import com.moringaschool.asuper.models.Login;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SuperApi {
    @POST ("login")
    Call<Admin> login(@Body Login login);

    @GET("secretInfo")
    Call<ResponseBody> getSecret(@Header("Authorization") String authToken);
}
