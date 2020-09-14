package com.diego.sejas.flowtest.interfaces;

import com.diego.sejas.flowtest.models.Province;
import com.diego.sejas.flowtest.models.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIService {

    @GET("forecast?lang=sp,es&appid=6d6be900da19a2bed65cab1c8fed9196&metric")
    Call<WeatherResponse> getWeatherData(@Query("q") String name,
                                         @Query("cnt") String client);

    @GET
    Call<Province> getProvince(@Url String loginUrl);
}
