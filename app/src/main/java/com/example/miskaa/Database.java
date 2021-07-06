package com.example.miskaa;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.miskaa.room.entity.BordersEntity;
import com.example.miskaa.room.entity.CountryEntity;
import com.example.miskaa.room.entity.LanguageEntity;
import com.example.miskaa.room.dao.BorderDao;
import com.example.miskaa.room.dao.CountryDao;
import com.example.miskaa.room.dao.LanguageDao;

@androidx.room.Database(entities = {CountryEntity.class, LanguageEntity.class, BordersEntity.class}, version = 1,exportSchema = false)
public abstract class Database extends RoomDatabase {

  public static Database databaseInstance;

  public static synchronized Database getDatabase(Context context) {
    if (databaseInstance == null) {

      databaseInstance = Room.databaseBuilder(context.getApplicationContext(), Database.class, "Country_Database")
              .fallbackToDestructiveMigrationFrom()
              .build();
    }
    return databaseInstance;
  }

  public abstract CountryDao countryDao();

  public abstract LanguageDao languageDao();

  public abstract BorderDao borderDao();
}
