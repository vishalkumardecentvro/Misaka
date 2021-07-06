package com.example.miskaa.room.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.miskaa.room.entity.BordersEntity;
import com.example.miskaa.room.repository.BorderRepository;

import java.util.List;

public class BorderView extends AndroidViewModel {

  private BorderRepository repository;

  private LiveData<List<BordersEntity>> allBorders;

  public BorderView(@NonNull Application application) {
    super(application);
    repository = new BorderRepository(application);

    allBorders = repository.getAllBorders();
  }

  public void insert(BordersEntity countryEntity) {
    repository.insertCountryBOrders(countryEntity);
  }

  public LiveData<List<BordersEntity>> getAllBorders() {
    return allBorders;
  }

  public void DeleteAllLanguages() {
    repository.deleteAllBorders();
  }
}
