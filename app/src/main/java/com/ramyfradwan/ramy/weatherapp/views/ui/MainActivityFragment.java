package com.ramyfradwan.ramy.weatherapp.views.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ramyfradwan.ramy.weatherapp.R;
import com.ramyfradwan.ramy.weatherapp.models.CitiesWeatherModel;
import com.ramyfradwan.ramy.weatherapp.models.WeatherModel;
import com.ramyfradwan.ramy.weatherapp.viewmodels.WeatherViewModel;
import com.ramyfradwan.ramy.weatherapp.views.Adapters.CountriesListAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */

public class MainActivityFragment extends Fragment {

    TextView tv_no_countries;
    private String TAG = "MainFragment";
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private WeatherModel[] weatherModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = view.findViewById(R.id.rv_countries);
        tv_no_countries = view.findViewById(R.id.tv_no_products_available);

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        WeatherViewModel viewModel =
                ViewModelProviders.of(this).get(WeatherViewModel.class);

//        if (((BaseActivity) super.getActivity()).isNetworkAvailable()) {
        viewModel.getCountriesListObservable().enqueue(new Callback<CitiesWeatherModel>() {
            @Override
            public void onResponse(@NonNull Call<CitiesWeatherModel> call, @NonNull Response<CitiesWeatherModel> citiesWeatherModel) {

                if (citiesWeatherModel.body() != null && citiesWeatherModel.body().getList() != null && citiesWeatherModel.body().getList().length > 0) {
                    tv_no_countries.setVisibility(View.GONE);
                    weatherModels = citiesWeatherModel.body().getList();
                    generateCountryCards(citiesWeatherModel.body());
                } else {
                    tv_no_countries.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(@NonNull Call<CitiesWeatherModel> call, @NonNull Throwable t) {

            }
        });
//        } else {
//            Toast.makeText(getActivity(), "Internet is not connected", Toast.LENGTH_LONG).show();
//            getActivity().finish();
//        }

        return view;
    }

    private void generateCountryCards(CitiesWeatherModel citiesWeatherModel) {
        RecyclerView.Adapter mAdapter = new CountriesListAdapter(getActivity(), citiesWeatherModel.getList());
        mRecyclerView.setAdapter(mAdapter);

    }

}
