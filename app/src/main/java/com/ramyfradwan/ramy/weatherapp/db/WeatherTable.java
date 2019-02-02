package com.ramyfradwan.ramy.weatherapp.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "weather_table")
public class WeatherTable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String city;

    @NonNull
    private int day;

    @NonNull
    private String description;

    @NonNull
    private int min;

    @NonNull
    private int max;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getCity() {
        return city;
    }

    public void setCity(@NonNull String city) {
        this.city = city;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
