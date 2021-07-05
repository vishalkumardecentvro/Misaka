package com.example.miskaa.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.miskaa.room.entity.LanguageEntity;

import java.util.List;

@Dao
public interface LanguageDao {

    @Insert
    void insertLanguages (LanguageEntity countryLanguageEntity);

    @Query("DELETE FROM language")
    void deleteAllNotes();

    @Query("SELECT * FROM language")
    LiveData<List<LanguageEntity>> getAllLanguagesInfo();

//    @Query("select id,iso639_1,iso639_2,name,nativeName from language where "+" name = :country_name ")
//    LiveData<List<LanguageEntity>> getLanguageByCountryName(String country_name);
}
