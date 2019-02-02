package com.ramyfradwan.ramy.weatherapp.viewmodels;

import com.ramyfradwan.ramy.weatherapp.BuildConfig;
import com.ramyfradwan.ramy.weatherapp.models.CitiesWeatherModel;
import com.ramyfradwan.ramy.weatherapp.models.WeatherModel;
import com.ramyfradwan.ramy.weatherapp.utils.Constants;

import androidx.lifecycle.ViewModel;
import retrofit2.Call;

public class WeatherViewModel extends ViewModel {

    private Call<CitiesWeatherModel> countriesListObservable;
    private Call<WeatherModel> countryWeatherObservable;

    public WeatherViewModel() {
        countriesListObservable = null;
        countryWeatherObservable = null;
    }

    public Call<CitiesWeatherModel> getCountriesListObservable() {

        countriesListObservable = WeatherRepository.getInstance().getWeatherForAllCountries(Constants.DEFAULT_COUNTRYCODES, BuildConfig.WeatherApiKey);
        return countriesListObservable;
    }

    public Call<WeatherModel> getWeatherByCountry(String countryID) {
        countryWeatherObservable = WeatherRepository.getInstance().getWeatherDataByCityCode(countryID, BuildConfig.WeatherApiKey);
        return countryWeatherObservable;
    }


}
