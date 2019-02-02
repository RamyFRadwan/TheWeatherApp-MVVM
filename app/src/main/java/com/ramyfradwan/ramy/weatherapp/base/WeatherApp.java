package com.ramyfradwan.ramy.weatherapp.base;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApp extends Application {


    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

}