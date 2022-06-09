package com.taxcalculator.model.taxrule;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeekDayRules {

  @JsonProperty("inTime")
  private final String inTime;

  @JsonProperty("outTime")
  private final String outTime;

  @JsonProperty("taxValue")
  private final String taxValue;

  @JsonCreator
  public WeekDayRules(
      @JsonProperty("inTime") String inTime,
      @JsonProperty("outTime") String outTime,
      @JsonProperty("taxValue") String taxValue
  ) {
    this.inTime = inTime;
    this.outTime = outTime;
    this.taxValue = taxValue;
  }

  public String getInTime() {
    return inTime;
  }

  public String getOutTime() {
    return outTime;
  }

  public String getTaxValue() {
    return taxValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeekDayRules that = (WeekDayRules) o;
    return Objects.equals(inTime, that.inTime) &&
        Objects.equals(outTime, that.outTime) &&
        Objects.equals(taxValue, that.taxValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inTime, outTime, taxValue);
  }
}
