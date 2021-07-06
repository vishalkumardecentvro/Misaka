package com.example.miskaa.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "country")
public class CountryEntity {

  private String name, capital, flag, region, subregion, population;
  @PrimaryKey(autoGenerate = true)
  private int id;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getSubregion() {
    return subregion;
  }

  public void setSubregion(String subregion) {
    this.subregion = subregion;
  }

  public String getPopulation() {
    return population;
  }

  public void setPopulation(String population) {
    this.population = population;
  }

  public int getId() {
    return id;
  }
}
