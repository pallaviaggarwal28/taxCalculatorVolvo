package com.taxcalculator.service;

import com.taxcalculator.model.TaxRequest;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaxCalculationServiceTest {

  private TaxCalculationService taxCalculationService;

  @BeforeEach
  public void setup() {
    taxCalculationService = new TaxCalculationService();
  }

  @Test
  public void taxCalculationServiceTest() throws IOException {
    TaxRequest taxRequest = new TaxRequest("car", "2013-01-14 21:00:00", "2013-01-14 21:05:00");
    var tax = taxCalculationService.calculateTax("gothenberg", taxRequest);
    System.out.println(tax);
  }

}
