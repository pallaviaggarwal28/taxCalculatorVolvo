package com.taxcalculator.model.taxrule;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxRule {

  @JsonProperty("exemptedVehicles")
  private final List<String> exemptedVehicles;

  @JsonProperty("rules")
  private final List<Rules> rules;

  @JsonCreator
  public TaxRule(
      @JsonProperty("exemptedVehicles") List<String> exemptedVehicles,
      @JsonProperty("rules") List<Rules> rules
  ) {
    this.exemptedVehicles = exemptedVehicles;
    this.rules = rules;
  }

  public List<String> getExemptedVehicles() {
    return exemptedVehicles;
  }

  public List<Rules> getRules() {
    return rules;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaxRule taxRule = (TaxRule) o;
    return Objects.equals(exemptedVehicles, taxRule.exemptedVehicles) &&
        Objects.equals(rules, taxRule.rules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exemptedVehicles, rules);
  }
}
