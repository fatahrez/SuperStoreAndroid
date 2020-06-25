package com.moringaschool.asuper.api;

import android.provider.ContactsContract;

import com.moringaschool.asuper.models.DefaultResponse;
import com.moringaschool.asuper.models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SuperApi {

    @FormUrlEncoded
    @POST("register-clerk")
    Call<DefaultResponse> createClerk(
            @Field("username") String Username,
            @Field("password") String Password,
            @Field("email") String Email,
            @Field("first_name") String FirstName,
            @Field("last_name") String LastName
    );

    @FormUrlEncoded
    @POST("userlogin")
    Call<LoginResponse> userLogin(
            @Field("Email_l") String Email,
            @Field("password_l") String Password
    );

}




