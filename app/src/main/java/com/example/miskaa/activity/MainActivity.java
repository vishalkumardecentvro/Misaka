package com.example.miskaa.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.miskaa.Connection;
import com.example.miskaa.adapter.CountryAdapter;
import com.example.miskaa.databinding.ActivityMainBinding;
import com.example.miskaa.room.entity.CountryEntity;
import com.example.miskaa.room.entity.LanguageEntity;
import com.example.miskaa.room.view.CountryView;
import com.example.miskaa.room.view.LanguageView;
import com.example.miskaa.table.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;
  private CountryAdapter countryAdapter;
  private CountryView countryView;
  private LanguageView languageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    View view = binding.getRoot();

    setContentView(view);

    instantiate();
    initialize();
    listen();
    load();
  }

  private void instantiate() {
    countryView = ViewModelProviders.of(this).get(CountryView.class);
    languageView = ViewModelProviders.of(this).get(LanguageView.class);

    countryAdapter = new CountryAdapter(this);
  }

  private void initialize() {
    binding.rvCountry.setAdapter(countryAdapter);
  }

  private void listen() {

  }

  private void load() {

    Call<List<Country>> data = Connection.getCountryInterface().getCountries();
    data.enqueue(new Callback<List<Country>>() {
      @Override
      public void onResponse(Call<List<Country>> call, Response<List<Country>> countryResponse) {
        if (countryResponse.body() != null) {
          countryAdapter.setCountryList(countryResponse.body());
          storeDataInRoom(countryResponse.body());
        }
      }

      @Override
      public void onFailure(Call<List<Country>> call, Throwable t) {
        Toast.makeText(MainActivity.this, "Please check your internet connection or try again", Toast.LENGTH_SHORT).show();

      }
    });

  }

  private void storeDataInRoom(List<Country> countryList) {
    for (Country country : countryList) {
      storeCountryBasicInformation(country);
      storeCountryLanguage(country.getLanguages(), country.getName());
    }
  }

  private void storeCountryBasicInformation(Country country) {
    CountryEntity countryEntity = new CountryEntity();

    countryEntity.setName(country.getName());
    countryEntity.setCapital(country.getCapital());
    countryEntity.setFlag(country.getFlag());
    countryEntity.setPopulation(country.getPopulation());
    countryEntity.setRegion(country.getRegion());
    countryEntity.setSubregion(country.getSubregion());

    countryView.insert(countryEntity);
  }

  private void storeCountryLanguage(List<Country.Language> languageList, String countryName) {
    LanguageEntity countryLanguage = new LanguageEntity();

    for (Country.Language language : languageList) {

      countryLanguage.setName(language.getName());
      countryLanguage.setCountryName(countryName);

      Log.i("--language--", countryLanguage.getName());

      languageView.insert(countryLanguage);
    }


  }
}