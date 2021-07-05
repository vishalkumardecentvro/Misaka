package com.example.miskaa;

import java.util.List;

public class Country {

  private String name, capital, flag, region, subregion, population;

  private List<String> borders;
  private List<Language> languages;

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

  public List<String> getBorders() {
    return borders;
  }

  public void setBorders(List<String> borders) {
    this.borders = borders;
  }

  public List<Language> getLanguages() {
    return languages;
  }

  public void setLanguages(List<Language> languages) {
    this.languages = languages;
  }

  public class Language {

    private String name, nativeName, iso639_1, iso639_2;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getNativeName() {
      return nativeName;
    }

    public void setNativeName(String nativeName) {
      this.nativeName = nativeName;
    }

    public String getIso639_1() {
      return iso639_1;
    }

    public void setIso639_1(String iso639_1) {
      this.iso639_1 = iso639_1;
    }

    public String getIso639_2() {
      return iso639_2;
    }

    public void setIso639_2(String iso639_2) {
      this.iso639_2 = iso639_2;
    }
  }
}
