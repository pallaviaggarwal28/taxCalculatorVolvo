package com.taxcalculator.model.taxrule;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rules {

  @JsonProperty("taxApplicableToVehicles")
  private final List<String> taxApplicableToVehicles;

  @JsonProperty("weekendFree")
  private final Boolean weekendFree;

  @JsonProperty("publicHolidayFree")
  private final Boolean publicHolidayFree;

  @JsonProperty("dayBeforePublicHolidayFree")
  private final Boolean dayBeforePublicHolidayFree;

  @JsonProperty("freeMonths")
  private final List<String> freeMonths;

  @JsonProperty("maxTimeBeforeNextTaxation")
  private final String maxTimeBeforeNextTaxation;

  @JsonProperty("publicHolidays")
  private final List<String> publicHolidays;

  @JsonProperty("maxTaxPerDay")
  private final String maxTaxPerDay;

  @JsonProperty("weekdayRules")
  private final List<WeekDayRules> weekdayRules;

  @JsonCreator
  public Rules(
      @JsonProperty("taxApplicableToVehicles") List<String> taxApplicableToVehicles,
      @JsonProperty("weekendFree") Boolean weekendFree,
      @JsonProperty("publicHolidayFree") Boolean publicHolidayFree,
      @JsonProperty("dayBeforePublicHolidayFree") Boolean dayBeforePublicHolidayFree,
      @JsonProperty("freeMonths") List<String> freeMonths,
      @JsonProperty("maxTimeBeforeNextTaxation") String maxTimeBeforeNextTaxation,
      @JsonProperty("publicHolidays") List<String> publicHolidays,
      @JsonProperty("maxTaxPerDay") String maxTaxPerDay,
      @JsonProperty("weekdayRules") List<WeekDayRules> weekdayRules
  ) {
    this.taxApplicableToVehicles = taxApplicableToVehicles;
    this.weekendFree = weekendFree;
    this.publicHolidayFree = publicHolidayFree;
    this.dayBeforePublicHolidayFree = dayBeforePublicHolidayFree;
    this.freeMonths = freeMonths;
    this.maxTimeBeforeNextTaxation = maxTimeBeforeNextTaxation;
    this.publicHolidays = publicHolidays;
    this.maxTaxPerDay = maxTaxPerDay;
    this.weekdayRules = weekdayRules;
  }

  public List<String> getTaxApplicableToVehicles() {
    return taxApplicableToVehicles;
  }

  public Boolean getWeekendFree() {
    return weekendFree;
  }

  public Boolean getPublicHolidayFree() {
    return publicHolidayFree;
  }

  public Boolean getDayBeforePublicHolidayFree() {
    return dayBeforePublicHolidayFree;
  }

  public List<String> getFreeMonths() {
    return freeMonths;
  }

  public String getMaxTimeBeforeNextTaxation() {
    return maxTimeBeforeNextTaxation;
  }

  public List<String> getPublicHolidays() {
    return publicHolidays;
  }

  public String getMaxTaxPerDay() {
    return maxTaxPerDay;
  }

  public List<WeekDayRules> getWeekdayRules() {
    return weekdayRules;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rules rules = (Rules) o;
    return Objects.equals(taxApplicableToVehicles, rules.taxApplicableToVehicles) &&
        Objects.equals(weekendFree, rules.weekendFree) &&
        Objects.equals(publicHolidayFree, rules.publicHolidayFree) &&
        Objects.equals(dayBeforePublicHolidayFree, rules.dayBeforePublicHolidayFree) &&
        Objects.equals(freeMonths, rules.freeMonths) &&
        Objects.equals(maxTimeBeforeNextTaxation, rules.maxTimeBeforeNextTaxation) &&
        Objects.equals(publicHolidays, rules.publicHolidays) &&
        Objects.equals(maxTaxPerDay, rules.maxTaxPerDay) &&
        Objects.equals(weekdayRules, rules.weekdayRules);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(taxApplicableToVehicles, weekendFree, publicHolidayFree, dayBeforePublicHolidayFree, freeMonths, maxTimeBeforeNextTaxation,
            publicHolidays, maxTaxPerDay, weekdayRules);
  }
}
