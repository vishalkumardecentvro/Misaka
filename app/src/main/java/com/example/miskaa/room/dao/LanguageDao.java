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
    void deleteAllLanguages();

    @Query("SELECT * FROM language")
    LiveData<List<LanguageEntity>> getAllLanguagesInfo();
}
