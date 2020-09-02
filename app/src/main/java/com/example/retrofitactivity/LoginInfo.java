package com.example.retrofitactivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginInfo {
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;

 @SerializedName("token")
    @Expose
    private String token

//    public Hero(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl, String bio) {

}