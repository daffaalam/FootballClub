package com.educa62.footballclub.network;

import com.educa62.footballclub.model.RootFootball;
import com.educa62.footballclub.tool.Variables;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EndPoints {

    @GET(Variables.END_POINT_A)
    Call<RootFootball> getData(
            @Query("s") String s,
            @Query("c") String c
    );

}
