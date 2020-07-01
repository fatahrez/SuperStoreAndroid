package com.moringaschool.asuper.api;

import android.provider.ContactsContract;

import com.moringaschool.asuper.models.DefaultResponse;
import com.moringaschool.asuper.models.LoginResponse;
import com.moringaschool.asuper.models.Token;
import com.moringaschool.asuper.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SuperApi {

    @POST("/register-clerk/")
    Call<Token> createClerk(
        @Body Token token
    );

    @FormUrlEncoded
    @POST("userLogin")
    Call<LoginResponse> userLogin(
            @Field("Email_l") String Email,
            @Field("password_l") String Password
    );

}




