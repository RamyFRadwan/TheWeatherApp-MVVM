package com.ramyfradwan.ramy.weatherapp.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;


@Database(entities = {WeatherTable.class}, version = 1)
public abstract class WeatherRoomDB extends RoomDatabase {
    private static volatile WeatherRoomDB INSTANCE;

    static WeatherRoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WeatherRoomDB.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WeatherRoomDB.class, "weather_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract WeatherDao WeatherDao();

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
