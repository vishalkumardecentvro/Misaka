package com.example.miskaa.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.miskaa.CountryDatabase;
import com.example.miskaa.room.dao.CountryDao;
import com.example.miskaa.room.entity.CountryEntity;

import java.util.List;

public class CountryRepository {

    private CountryDao countryDao;
    private LiveData<List<CountryEntity>> countryInformation;

    public CountryRepository(Application application) {
        CountryDatabase countryDatabase = CountryDatabase.getDatabase(application);
        this.countryDao = countryDatabase.countryDao();
        this.countryInformation = countryDao.getAllCountry();
    }

    public void insertCountryBasicInformation(CountryEntity country){
        new InsertAsyncTask(countryDao).execute(country);
    }

    public void deleteAllInformation(){

        new DeleteAllAsyncCountries(countryDao).execute();
    }

    public LiveData<List<CountryEntity>> getBasicCountryInformation() {
        return countryInformation;
    }

    private static class InsertAsyncTask extends AsyncTask<CountryEntity,Void,Void> {

        private CountryDao countryDao;

        private InsertAsyncTask(CountryDao countryDao){  // constructor
            this.countryDao = countryDao;
        }

        @Override
        protected Void doInBackground(CountryEntity... countryInformation) {
            countryDao.insertInformation(countryInformation[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncCountries extends AsyncTask<Void,Void,Void>{

        private CountryDao countryDao;

        public DeleteAllAsyncCountries(CountryDao countryDao) {
            this.countryDao = countryDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            countryDao.deleteAllCountries();
            return null;
        }
    }
}
