package com.ramyfradwan.ramy.weatherapp.viewmodels;

import com.ramyfradwan.ramy.weatherapp.BuildConfig;
import com.ramyfradwan.ramy.weatherapp.models.WeatherModel;

import retrofit2.Call;

public class WeatherViewModel {

    private Call<WeatherModel> countryWeatherObservable;

    public WeatherViewModel() {
        countryWeatherObservable = null;
    }

    public Call<WeatherModel> getWeatherByCountry(String countryID) {
        countryWeatherObservable = WeatherRepository.getInstance().getWeatherDataByCityCode(countryID, BuildConfig.WeatherApiKey);
        return countryWeatherObservable;
    }


}
