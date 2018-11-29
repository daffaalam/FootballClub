package com.educa62.footballclub.network;

import com.educa62.footballclub.model.RootFootball;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface EndPoints {

    @GET("v2/teams")
    Call<RootFootball> getData(
            @Header("X-Auth-Token") String apiKey
    );

}
