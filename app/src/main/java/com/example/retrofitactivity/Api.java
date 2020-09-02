package com.example.retrofitactivity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Belal on 10/2/2017.
 */

public interface Api {
//    String BASE_URL = "https://postman-echo.com/";
    String BASE_URL = "https://hamlet.payfill.co/";
//    String BASE_URL = "https://raw.githubusercontent.com/Nsikaktopdown/Recipe/master/";
    @POST("/api/auth/login")
//    @POST("/basic-auth")
    @FormUrlEncoded
//    Call<Hero> hero(String email, String pass);
    Call<LoginInfo> hero(@Field("email") String email, @Field("password") String pass);
}





