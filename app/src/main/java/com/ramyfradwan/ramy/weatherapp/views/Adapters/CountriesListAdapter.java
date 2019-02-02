package com.ramyfradwan.ramy.weatherapp.views.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ramyfradwan.ramy.weatherapp.R;
import com.ramyfradwan.ramy.weatherapp.models.WeatherModel;
import com.ramyfradwan.ramy.weatherapp.utils.Constants;
import com.ramyfradwan.ramy.weatherapp.views.ui.WeatherDetailActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class CountriesListAdapter extends RecyclerView.Adapter<CountriesListAdapter.ViewHolder> {
    private static final String TAG = "Recycleview";
    private static WeatherModel[] citiesWeatherModels;
    private Context context;

    public CountriesListAdapter(Context context, WeatherModel[] citiesWeatherModels) {
        CountriesListAdapter.citiesWeatherModels = citiesWeatherModels;
        this.context = context;

    }

    @NonNull
    @Override
    public CountriesListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                              int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        String countryCityName = citiesWeatherModels[position].getName() + ", " + citiesWeatherModels[position].getSys().getCountry();
        holder.mTextView.setText(countryCityName);
        loadImageFromUrlToImageView(holder.weatherIcon, citiesWeatherModels[position].getWeather()[0].getIcon());
    }

    @Override
    public int getItemCount() {
        return citiesWeatherModels.length;
    }

    /*
     * Method: loadImageFromUrlToImageView
     * Using Glide library - it will load the image from url and cache into imageview
     */
    private void loadImageFromUrlToImageView(final ImageView imageView, String imageIconName) {

        if (imageIconName != null) {
            String imageUri = Constants.IMAGE_URL + imageIconName + context.getString(R.string.imageExtentionPNG);
            Log.d(TAG, imageUri);

            // To load the image dynamically on-fly
            Glide.with(context).load(imageUri)
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);

        } else {
            Log.e(TAG, context.getString(R.string.imageNotFound));
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mTextView;
        ImageView weatherIcon;

        ViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.cardview_list_title3);
            weatherIcon = v.findViewById(R.id.cardview_image3);
            v.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "Clicked");
            String countryCityName = citiesWeatherModels[getAdapterPosition()].getName() + "," + citiesWeatherModels[getAdapterPosition()].getSys().getCountry();
            if (context != null) {
                Intent weatherDetailIntent = new Intent(context, WeatherDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("countryName", countryCityName);
                weatherDetailIntent.putExtras(bundle);
                context.startActivity(weatherDetailIntent);
            }
        }
    }
}



