package com.example.miskaa.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.miskaa.room.entity.LanguageEntity;
import com.example.miskaa.table.Country;

import java.util.List;

@Dao
public interface LanguageDao {

    @Insert
    void insertLanguages (LanguageEntity countryLanguageEntity);

    @Query("DELETE FROM language")
    void deleteAllLanguages();

    @Query("SELECT * FROM language")
    LiveData<List<LanguageEntity>> getAllLanguagesInfo();

    @Query("SELECT name FROM language where countryName = :countryName LIMIT 1")
    LiveData<List<Country.Language>> getCountryLanguages(String countryName);
}
