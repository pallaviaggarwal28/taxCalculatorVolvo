package com.taxcalculator.resource;

import com.taxcalculator.model.TaxRequest;
import com.taxcalculator.service.TaxCalculationService;
import java.io.IOException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/taxCalculator")
public class TaxCalculationResource {

  private final TaxCalculationService taxCalculationService;

  public TaxCalculationResource(TaxCalculationService taxCalculationService) {
    this.taxCalculationService = taxCalculationService;
  }

  @POST
  @Path("/{city}/calculateTax")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Double calculateTax(
      @PathParam("city") String city,
      @NotNull @Valid final TaxRequest taxRequest
  ) throws IOException {
    taxCalculationService.calculateTax(city, taxRequest);
    return null; //TODO replace this stub to something useful
  }

}
