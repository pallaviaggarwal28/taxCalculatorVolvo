package com.taxcalculator.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import io.dropwizard.client.JerseyClientConfiguration;

public class TaxCalculatorConfiguration extends Configuration {
  @Valid
  @NotNull
  @JsonProperty("httpClient")
  private JerseyClientConfiguration httpClient = new JerseyClientConfiguration();

  public JerseyClientConfiguration getHttpClientConfiguration() {
    return httpClient;
  }

}
