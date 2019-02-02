package com.ramyfradwan.ramy.weatherapp.views.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ramyfradwan.ramy.weatherapp.R;
import com.ramyfradwan.ramy.weatherapp.base.BaseActivity;
import com.ramyfradwan.ramy.weatherapp.models.WeatherModel;
import com.ramyfradwan.ramy.weatherapp.viewmodels.WeatherViewModel;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A placeholder fragment containing a simple view.
 */


public class MainActivityFragment extends Fragment {

    private String TAG = "MainFragment";
    private WeatherModel[] weatherModels;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView mRecyclerView = view.findViewById(R.id.rv_countries);
        TextView tv_no_countries = view.findViewById(R.id.tv_no_products_available);

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        WeatherViewModel viewModel =
                ViewModelProviders.of(this).get(WeatherViewModel.class);

        if (((BaseActivity) Objects.requireNonNull(super.getActivity())).isNetworkAvailable()) {
            //TODO:: Add code here for network available
        } else {
            Toast.makeText(getActivity(), "Internet is not connected", Toast.LENGTH_LONG).show();
            getActivity().finish();
        }

        return view;
    }


}
