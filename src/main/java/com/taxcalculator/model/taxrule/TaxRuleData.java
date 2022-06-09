package com.taxcalculator.model.taxrule;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxRuleData {

  @JsonProperty("city")
  private final String city;

  @JsonProperty("taxRules")
  private final TaxRule taxRules;

  @JsonCreator
  public TaxRuleData(@JsonProperty("city") String city, @JsonProperty("taxRules") TaxRule taxRules) {
    this.city = city;
    this.taxRules = taxRules;
  }

  public String getCity() {
    return city;
  }

  public TaxRule getTaxRule() {
    return taxRules;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaxRuleData that = (TaxRuleData) o;
    return Objects.equals(city, that.city) &&
        Objects.equals(taxRules, that.taxRules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, taxRules);
  }
}
