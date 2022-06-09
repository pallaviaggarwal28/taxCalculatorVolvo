package com.taxcalculator;

public class TaxCalculationException extends RuntimeException {

  public TaxCalculationException(String errorMessage) {
    super(errorMessage);
  }

  public TaxCalculationException(String errorMessage, Throwable err) {
    super(errorMessage, err);
  }
}
