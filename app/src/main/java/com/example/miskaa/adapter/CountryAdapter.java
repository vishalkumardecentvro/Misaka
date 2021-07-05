package com.example.miskaa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miskaa.Country;
import com.example.miskaa.databinding.RvCountryBinding;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
  private List<Country> countryList = new ArrayList<>();
  private Context context;

  public CountryAdapter(Context context) {
    this.context = context;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ViewHolder(RvCountryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.populate(countryList.get(position));
  }

  @Override
  public int getItemCount() {
    return countryList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    private final RvCountryBinding binding;

    public ViewHolder(RvCountryBinding binding) {
      super(binding.getRoot());
      this.binding = binding;

    }

    private void populate(Country country) {

      binding.tvName.setText(country.getName());
      binding.tvCapital.setText(country.getCapital());
      binding.tvRegion.setText(country.getRegion());
      binding.tvSubregion.setText(country.getSubregion());
      binding.tvPopulation.setText(country.getPopulation());

      ArrayAdapter<String> borderAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, country.getBorders());
      binding.spinnerBorder.setAdapter(borderAdapter);

      ArrayList<String> languageArrayList = new ArrayList<String>();

      for (Country.Language lang : country.getLanguages()) {
        languageArrayList.add(lang.getName());
        languageArrayList.add(lang.getNativeName());
        languageArrayList.add(lang.getIso639_1());
        languageArrayList.add(lang.getIso639_2());
      }

      ArrayAdapter<String> languageAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, languageArrayList);
      binding.spinnerLanguage.setAdapter(languageAdapter);

    }
  }

  public void setCountryList(List<Country> countryList) {
    this.countryList = countryList;
    notifyDataSetChanged();
  }
}
