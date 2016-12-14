package com.webservice.test;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Katz on 14.12.2016.
 */
public interface ProductPrices {

    public String getProductName();
    public BigDecimal getProductPrice();
    public LocalDate getValidFrom();
    public LocalDate getValidTo();

//    public LocalDate setValidFrom(LocalDate validFrom);
//    public LocalDate setValidTo(LocalDate validTo);
}
