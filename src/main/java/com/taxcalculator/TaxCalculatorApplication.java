package com.taxcalculator;

import com.taxcalculator.config.TaxCalculatorConfiguration;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import javax.ws.rs.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaxCalculatorApplication extends Application<TaxCalculatorConfiguration> {

  private static final Logger LOGGER = LoggerFactory.getLogger(TaxCalculatorApplication.class);

  @Override
  public String getName() {
    return "Congestion Tax Calculator";
  }

  public static void main(final String[] args) throws Exception {
    new TaxCalculatorApplication().run(args);
  }

  @Override
  public void initialize(final Bootstrap<TaxCalculatorConfiguration> bootstrap) {}

  @Override
  public void run(TaxCalculatorConfiguration configuration, Environment environment) {
    final Client client = new JerseyClientBuilder(environment)
        .using(configuration.getHttpClientConfiguration())
        .build(getName());

    environment.jersey().register(client);
  }

}
