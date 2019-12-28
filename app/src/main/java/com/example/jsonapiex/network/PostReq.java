package com.example.jsonapiex.network;

import java.util.HashMap;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostReq {
    @FormUrlEncoded
    @POST("user/register.html")
    public Call<ResponseBody> registerUser(@Field("userName") String userNameValue,
                                           @Field("password") String passwordValue,
                                           @Field("email") String emailValue);


    @POST("create")
    public Call<ResponseBody> getPost(@Body RequestBody body);

}
