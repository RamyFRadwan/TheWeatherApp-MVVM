package com.ramyfradwan.ramy.weatherapp.service;

import com.ramyfradwan.ramy.weatherapp.models.CitiesWeatherModel;
import com.ramyfradwan.ramy.weatherapp.models.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    /*
     * Returns data based on the country and city name
     */
    @GET("/data/2.5/weather")
    Call<WeatherModel> getWeatherDataByCityCode(@Query("q") String q, @Query("appid") String appId);

    /*
     * Returns all the data for given countries
     */
    @GET("/data/2.5/group")
    Call<CitiesWeatherModel> getWeatherForAllCountries(@Query("id") String id, @Query("appid") String appid);

}
