package com.example.miskaa.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "borders")
public class BordersEntity {

  String borderName;
  private String countryName;
  @PrimaryKey(autoGenerate = true)
  private int id;

  public String getBorderName() {
    return borderName;
  }

  public void setBorderName(String borderName) {
    this.borderName = borderName;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
