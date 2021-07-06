package com.example.miskaa.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.miskaa.room.entity.CountryEntity;

import java.util.List;

@Dao
public interface CountryDao {

    @Insert
    void insertCountryBasicInformation(CountryEntity country);

    @Query("DELETE FROM country")
    void deleteAllCountries();

    @Query("SELECT * FROM country")
    LiveData<List<CountryEntity>> getAllCountry();
}
