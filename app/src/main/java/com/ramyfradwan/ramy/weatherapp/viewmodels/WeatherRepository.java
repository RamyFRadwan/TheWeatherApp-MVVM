package com.ramyfradwan.ramy.weatherapp.viewmodels;

import android.util.Log;

import com.ramyfradwan.ramy.weatherapp.BuildConfig;
import com.ramyfradwan.ramy.weatherapp.base.WeatherApp;
import com.ramyfradwan.ramy.weatherapp.models.CitiesWeatherModel;
import com.ramyfradwan.ramy.weatherapp.models.WeatherModel;
import com.ramyfradwan.ramy.weatherapp.service.WeatherService;
import com.ramyfradwan.ramy.weatherapp.utils.Constants;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    private static WeatherService weatherService;

    static WeatherService getInstance() {
        weatherService = WeatherApp.initRestClient();
        return weatherService;
    }


    /*
     * Method: getWeatherDataByCityCode
     * It fetches the data from HTTP API based on the country name - convert into observable livedata object
     */
    public LiveData<WeatherModel> getWeatherDataByCityCode(String q) {
        final MutableLiveData<WeatherModel> data = new MutableLiveData<>();

        weatherService.getWeatherDataByCityCode(q, BuildConfig.WeatherApiKey).enqueue(new Callback<WeatherModel>() {

            @Override
            public void onResponse(@NonNull Call<WeatherModel> call, @NonNull Response<WeatherModel> response) {
                data.setValue(response.body());
                if (null != response.body()) {
                    Log.e("Resposses", response.body().toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherModel> call, @NonNull Throwable t) {
                Log.e("ERRoOORR", "Error retrieving DATAAA");
            }
        });

        return data;
    }

    /*
     * Method: getWeathersForCountries
     * It fetches the data from HTTP API and convert into observable livedata object
     */
    public LiveData<CitiesWeatherModel> getWeathersForCountries() {
        final MutableLiveData<CitiesWeatherModel> data = new MutableLiveData<>();

        weatherService.getWeatherForAllCountries(Constants.DEFAULT_COUNTRYCODES, BuildConfig.WeatherApiKey)
                .enqueue(new Callback<CitiesWeatherModel>() {
                    @Override
                    public void onResponse(@NonNull Call<CitiesWeatherModel> call, @NonNull Response<CitiesWeatherModel> response) {
                        data.setValue(response.body());
                    }

                    @Override
                    public void onFailure(@NonNull Call<CitiesWeatherModel> call, @NonNull Throwable t) {

                    }
                });

        return data;
    }

}