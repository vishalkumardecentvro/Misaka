package com.example.miskaa.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.miskaa.Database;
import com.example.miskaa.room.dao.LanguageDao;
import com.example.miskaa.room.entity.LanguageEntity;

import java.util.List;

public class LanguageRepository {

  private LanguageDao languageDao;
  private LiveData<List<LanguageEntity>> countryLanguage;

  public LanguageRepository(Application application) {
    Database database = Database.getDatabase(application);
    this.languageDao = database.languageDao();
    this.countryLanguage = languageDao.getAllLanguagesInfo();
  }

  public void insertCountryLanguages(LanguageEntity language) {
    new InsertAsyncTask(languageDao).execute(language);
  }

  public void deleteAllLanguages() {

    new DeleteAllAsyncLanguage(languageDao).execute();
  }

  public LiveData<List<LanguageEntity>> getAllLanguages() {
    return countryLanguage;
  }

  private static class InsertAsyncTask extends AsyncTask<LanguageEntity, Void, Void> {
    private LanguageDao languageDao;

    private InsertAsyncTask(LanguageDao languageDao) {
      this.languageDao = languageDao;
    }

    @Override
    protected Void doInBackground(LanguageEntity... countryLanguage) {
      languageDao.insertLanguages(countryLanguage[0]);
      return null;
    }
  }

  private static class DeleteAllAsyncLanguage extends AsyncTask<Void, Void, Void> {
    private LanguageDao languageDao;

    public DeleteAllAsyncLanguage(LanguageDao languageDao) {
      this.languageDao = languageDao;
    }

    @Override
    protected Void doInBackground(Void... voids) {
      languageDao.deleteAllLanguages();
      return null;
    }
  }
}
