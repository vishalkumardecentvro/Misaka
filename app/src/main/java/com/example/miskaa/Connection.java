package com.example.miskaa;

import com.example.miskaa.table.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Connection {

  public static final String URL = "https://restcountries.eu/rest/v2/region/";

  public static CountryInterface countryInterface = null;

  public static CountryInterface getCountryInterface() {
    if (countryInterface == null) {
      Retrofit retrofit = new Retrofit.Builder()
              .baseUrl(URL)
              .addConverterFactory(GsonConverterFactory.create())
              .build();

      countryInterface = retrofit.create(CountryInterface.class);
    }
    return countryInterface;
  }

  public interface CountryInterface {
    @GET("asia")
    Call<List<Country>> getCountries();
  }

}
