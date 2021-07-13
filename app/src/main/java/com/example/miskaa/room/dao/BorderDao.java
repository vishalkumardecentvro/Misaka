package com.example.miskaa.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.miskaa.room.entity.BordersEntity;
import com.example.miskaa.table.Country;

import java.util.List;

@Dao
public interface BorderDao {

    @Insert
    void insertCountryBorders(BordersEntity countryBorders);

    @Query("DELETE FROM borders")
    void deleteAllBorders();

    @Query("SELECT * FROM borders")
    LiveData<List<BordersEntity>> getAllBorders();

    @Query("SELECT name FROM language where countryName = :countryName LIMIT 1")
    LiveData<List<Country.Language>> getCountryBorders(String countryName);
}


