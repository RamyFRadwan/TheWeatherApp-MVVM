package com.ramyfradwan.ramy.weatherapp.base;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ramyfradwan.ramy.weatherapp.BuildConfig;
import com.ramyfradwan.ramy.weatherapp.service.WeatherService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApp extends Application {


    public static WeatherService initRestClient() {

        // GSON converter factory for Retrofit response
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit adapter = new Retrofit.Builder().baseUrl(BuildConfig.WeatherApiKey).addConverterFactory(GsonConverterFactory.create(gson)).build();
        return adapter.create(WeatherService.class);
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

}