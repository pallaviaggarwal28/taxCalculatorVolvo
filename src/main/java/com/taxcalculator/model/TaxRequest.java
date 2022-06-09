package com.taxcalculator.model;

public class TaxRequest {
  private final String vehicle;
  private final String entryTime;
  private final String exitTime;

  public TaxRequest(String vehicle, String entryTime, String exitTime) {
    this.vehicle = vehicle;
    this.entryTime = entryTime;
    this.exitTime = exitTime;
  }

  public String getVehicle() {
    return vehicle;
  }

  public String getEntryTime() {
    return entryTime;
  }

  public String getExitTime() {
    return exitTime;
  }
}
