package com.example.miskaa.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.miskaa.room.entity.BordersEntity;

import java.util.List;

@Dao
public interface BorderDao {

    @Insert
    void insertBorderInfo (BordersEntity countryBorders);

    @Query("DELETE FROM borders")
    void deleteAllBorders();

    @Query("SELECT * FROM borders")
    LiveData<List<BordersEntity>> getAllBorders();
}


