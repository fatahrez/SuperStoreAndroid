package com.moringaschool.asuper;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.GET;

public interface SuperApi {

    @FormUrlEncoded
    @POST("register-clerk")
    Call<ResponseBody> createClerk(
            @Field("username") String Username,
            @Field("password") String Password,
            @Field("email") String Email,
            @Field("first_name") String FirstName,
            @Field("last_name") String LastName
    );
}




