package com.webservice.test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Katz on 14.12.2016.
 */
public interface ProductPricesDAO {

    public String getProductName() throws SQLException;
    public BigDecimal getProductPrice();
    public LocalDate getValidFrom();
    public LocalDate getValidTo();

    BigDecimal getPrice(String productName, LocalDate dateFrom, LocalDate dateTo);

}
