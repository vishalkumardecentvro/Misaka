package com.example.miskaa.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "borders")
public class BordersEntity {

  String borderName;
  private  int countryId;
  @PrimaryKey(autoGenerate = true)
  private int id;

  public BordersEntity(String borderName, int countryId) {
    this.borderName = borderName;
    this.countryId = countryId;
  }

  public String getBorderName() {
    return borderName;
  }

  public void setBorderName(String borderName) {
    this.borderName = borderName;
  }

  public int getCountryId() {
    return countryId;
  }

  public void setCountryId(int countryId) {
    this.countryId = countryId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
