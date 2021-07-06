package com.example.miskaa.room.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.miskaa.room.entity.LanguageEntity;
import com.example.miskaa.room.repository.LanguageRepository;

import java.util.List;

public class LanguageView extends AndroidViewModel {

  private LanguageRepository repository;

  private LiveData<List<LanguageEntity>> allLanguages;

  public LanguageView(@NonNull Application application) {
    super(application);
    repository = new LanguageRepository(application);

    allLanguages = repository.getAllLanguages();
  }

  public void insert(LanguageEntity countryEntity) {
    repository.insertCountryLanguages(countryEntity);
  }

  public LiveData<List<LanguageEntity>> getAllLanguages() {
    return allLanguages;
  }

  public void DeleteAllLanguages() {
    repository.deleteAllLanguages();
  }
}
