package com.example.miskaa.room.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.miskaa.room.entity.CountryEntity;
import com.example.miskaa.room.repository.CountryRepository;

import java.util.List;

public class CountryView extends AndroidViewModel {

  private CountryRepository repository;

  private LiveData<List<CountryEntity>> allInformation;

  public CountryView(@NonNull Application application) {
    super(application);
    repository = new CountryRepository(application);

    allInformation = repository.getBasicCountryInformation();
  }

  public void insert(CountryEntity countryEntity) {
    repository.insertCountryBasicInformation(countryEntity);
  }


  public LiveData<List<CountryEntity>> getBasicCountryInformation() {
    return allInformation;
  }


  public void DeleteBasicInformation() {
    repository.deleteAllInformation();
  }
}
