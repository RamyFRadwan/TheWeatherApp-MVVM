package com.ramyfradwan.ramy.weatherapp.db;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface WeatherDao {

    @Insert
    void insert(WeatherTable weatherTable);

    @Query("Delete From weather_table")
    void deleteAll();

    @Query("SELECT * from weather_table ORDER BY day ASC")
    List<WeatherTable> getAllWords();
}
