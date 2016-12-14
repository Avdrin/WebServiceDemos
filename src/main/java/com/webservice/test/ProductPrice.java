package com.webservice.test;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Katz on 13.12.2016.
 */
public class ProductPrice implements ProductPrices {
    private final String productName;
    private final BigDecimal productPrice;
    private final LocalDate validFrom;
    private final LocalDate validTo;
    public ProductPrice(String productName, BigDecimal productPrice, LocalDate validFrom, LocalDate validTo) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
    public String getProductName() { return productName; }
    public BigDecimal getProductPrice() { return productPrice; }
    // цена действует на протяжении интервала, заданного датами
    // getValidFrom() и getValidTo(), в том числе и в даты,
    // задающие границы интервала.
    //
    // Методы возвращают null, если интервал не ограничен снизу
    // (сверху).
    public LocalDate getValidFrom() { return validFrom; }
    public LocalDate getValidTo() { return validTo; }

//    @Override
//    public LocalDate setValidFrom(LocalDate validFrom) {
//        return null;
//    }
//    @Override
//    public LocalDate setValidTo(LocalDate validTo) {
//        return null;
//    }
}
