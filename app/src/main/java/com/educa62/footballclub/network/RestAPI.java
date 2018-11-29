package com.educa62.footballclub.network;

import com.educa62.footballclub.tool.Variables;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAPI {

    public Retrofit getEndPoint() {
        return new Retrofit.Builder().baseUrl(Variables.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

}
