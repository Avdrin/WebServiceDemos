package com.webservice.test;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katz on 13.12.2016.
 */

@Path("/priceList")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PriceListWebService implements PriceListWebServices {
    @GET
    public BigDecimal getPrice(@NotNull @QueryParam("productName") String productName, @NotNull @QueryParam("date") LocalDate date){

        return null;
    };


    @GET
//    @Path("/priceList")
//    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductPrice>getPrices(@QueryParam("productName") String productName){
            List<ProductPrice> productPrices = new ArrayList<>();

        LocalDate today = LocalDate.now();
        productPrices.add(0,new ProductPrice("wer",new BigDecimal(10),today,today));

//        ProductPrice prod = null; //productPrices.get(0); //r = null;
//        for (ProductPrice p : productPrices) {
//            if (p.getProductName() == "2cxv")
//                prod = p;
//        }

//        return productPrices.get(0);

        return productPrices;
    };


    @POST
    public void setPrice(@NotNull @QueryParam("productName") String productName,
                         @NotNull @QueryParam("price") @DecimalMin("0") BigDecimal price,
                         @QueryParam("fromDate") LocalDate fromDate, @QueryParam("toDate") LocalDate toDate){


    };



    @POST
    public void stopSelling(@NotNull @QueryParam("productName") String productName, @QueryParam("fromDate") LocalDate fromDate, @QueryParam("toDate") LocalDate toDate){

    };


}
