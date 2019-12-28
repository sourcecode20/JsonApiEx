package com.example.jsonapiex.network;

import com.example.jsonapiex.model.Worldpopulation;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetReq {

    @GET("/wp-content/uploads/2019/03/world-population-androchef.txt")
    Call<List<Worldpopulation>> loadWordPopulationList();

    String baseUrl = "http://androchef.com";

    // Creating a retrofit object and adding GsonConverterFactory which uses GSon for JSON
    Retrofit retrofit = new Retrofit.Builder().
            baseUrl(baseUrl).
            addConverterFactory(GsonConverterFactory.create()).build();

    GetReq getReq = retrofit.create(GetReq.class);

    Call<List<Worldpopulation>> apiCall = getReq.loadWordPopulationList();
}
