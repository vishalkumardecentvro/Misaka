package com.example.miskaa.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.miskaa.Database;
import com.example.miskaa.room.dao.BorderDao;
import com.example.miskaa.room.entity.BordersEntity;

import java.util.List;

public class BorderRepository {

  private BorderDao borderDao;
  private LiveData<List<BordersEntity>> countryBorders;

  public BorderRepository(Application application) {
    Database database = Database.getDatabase(application);
    this.borderDao = database.borderDao();
    this.countryBorders = borderDao.getAllBorders();
  }

  public void insertCountryBOrders(BordersEntity bordersEntity) {
    new InsertAsyncTask(borderDao).execute(bordersEntity);
  }

  public void deleteAllBorders() {

    new DeleteAllAsyncBorders(borderDao).execute();
  }

  public LiveData<List<BordersEntity>> getAllBorders() {
    return countryBorders;
  }

  private static class InsertAsyncTask extends AsyncTask<BordersEntity, Void, Void> {
    private BorderDao borderDao;

    private InsertAsyncTask(BorderDao borderDao) {
      this.borderDao = borderDao;
    }

    @Override
    protected Void doInBackground(BordersEntity... countryLanguage) {
      borderDao.insertCountryBorders(countryLanguage[0]);
      return null;
    }
  }

  private static class DeleteAllAsyncBorders extends AsyncTask<Void, Void, Void> {
    private BorderDao borderDao;

    public DeleteAllAsyncBorders(BorderDao borderDao) {
      this.borderDao = borderDao;
    }

    @Override
    protected Void doInBackground(Void... voids) {
      borderDao.deleteAllBorders();
      return null;
    }
  }
}
