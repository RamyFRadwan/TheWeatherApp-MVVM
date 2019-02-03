package com.ramyfradwan.ramy.weatherapp.db;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class WeatherRepositoryOffline {

    private WeatherDao mWeatherDao;
    private LiveData<List<WeatherTable>> mAllWords;

    WeatherRepositoryOffline(Application application) {
        WeatherRoomDB db = WeatherRoomDB.getDatabase(application);
        mWeatherDao = db.WeatherDao();
        mAllWords = mWeatherDao.getAllWords();
    }

    LiveData<List<WeatherTable>> getAllWords() {
        return mAllWords;
    }


    public void insert(WeatherTable weatherTable) {
        new insertAsyncTask(mWeatherDao).execute(weatherTable);
    }

    private static class insertAsyncTask extends AsyncTask<WeatherTable, Void, Void> {

        private WeatherDao mAsyncTaskDao;

        insertAsyncTask(WeatherDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WeatherTable... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
