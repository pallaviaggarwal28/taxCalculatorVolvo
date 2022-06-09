package com.taxcalculator.service;

import com.taxcalculator.TaxCalculationException;
import com.taxcalculator.model.TaxRequest;
import com.taxcalculator.model.taxrule.Rules;
import com.taxcalculator.model.taxrule.TaxRuleData;
import com.taxcalculator.util.FileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

import static com.taxcalculator.util.DateUtils.getDateFromString;

public class TaxCalculationService {

  private static final String TAX_RULES_FILES = "data/";

  public Double calculateTax(String city, TaxRequest taxRequest) throws IOException {
    String fileName = city.toLowerCase().concat(".json");
    var taxRulesFromFile = FileUtils.readFileDataFromPath(TAX_RULES_FILES.concat(fileName));

    ObjectMapper mapper = new ObjectMapper();
    TaxRuleData taxRuleData = mapper.readValue(taxRulesFromFile, TaxRuleData.class);
    var taxRules = taxRuleData.getTaxRule();

    if (!city.toLowerCase().equalsIgnoreCase(taxRuleData.getCity().toLowerCase())) {
      throw new TaxCalculationException(String.format("The city name %s is not same as in the rules file %s", city, taxRuleData.getCity()));
    }
    if (taxRules.getExemptedVehicles().contains(taxRequest.getVehicle()))
      return (double) 0;
    return calculateTax(taxRequest, taxRules.getRules());
  }

  public Double calculateTax(TaxRequest taxRequest, List<Rules> rules) {
    var entryDateTime = getDateFromString(taxRequest.getEntryTime());
    var exitDateTime = getDateFromString(taxRequest.getExitTime());

    /* Using first entry of rules as a hard coded value for rule processing.
    * Have added this as a list to accommodate various rules for various set of vehicles, but here assuming it to be just one entry
    * */
    var cityRules = rules.get(0);

    if (cityRules.getFreeMonths().contains(entryDateTime.getMonth().name()) &&
        cityRules.getFreeMonths().contains(exitDateTime.getMonth().name())) {
      return (double) 0;
    }
    return (double) 1;
  }
}
