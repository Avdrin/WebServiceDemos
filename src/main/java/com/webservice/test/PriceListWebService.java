package com.webservice.test;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Katz on 13.12.2016.
 */

@Path("/priceList")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)



public class PriceListWebService implements PriceListWebServices {

    private Date getDateFromString(String dateString) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //'T'HH:mm:ss");
            Date date = df.parse(dateString);
            return date;
        } catch (ParseException e) {
            return null;
            //WebApplicationException ...("Date format should be yyyy-MM-dd'T'HH:mm:ss", Status.BAD_REQUEST);
        }

    }

    @JsonFormat(pattern = "dd::MM::yyyy")
    @GET
    public String getPrice(@QueryParam("productName") String productName, @QueryParam("date") String date){ //LocalDate date){

        Date dates = getDateFromString(date); // ProductPriceDAO productPriceDAO = new ProductPriceDAO();

//        System.out.print("pr == " + productName);

//        String json = "[{\"name\":\"mkyong\"}, {\"name\":\"laplap\"}]";@NotNull
//        List<Staff> list = mapper.readValue(json, new TypeReference<List<Staff>>(){});
        return "bnm"; //String.valueOf(date);  //String.valueOf(productPriceDAO.getPrice(productName,date));
    };


//    @GET
////    @Path("/priceList")
////    @Produces(MediaType.APPLICATION_JSON)
//    public List<ProductPrice>getPrices(@QueryParam("productName") String productName){
//            List<ProductPrice> productPrices = new ArrayList<>();
//
//        LocalDate today = LocalDate.now();
//        productPrices.add(0,new ProductPrice("wer",new BigDecimal(10),today,today));
//
////        ProductPrice prod = null; //productPrices.get(0); //r = null;
////        for (ProductPrice p : productPrices) {
////            if (p.getProductName() == "2cxv")
////                prod = p;
////        }
//
////        return productPrices.get(0);
//
//        return productPrices;
//    };
//
//
//    @POST
//    public void setPrice(@NotNull @QueryParam("productName") String productName,
//                         @NotNull @QueryParam("price") @DecimalMin("0") BigDecimal price,
//                         @QueryParam("fromDate") LocalDate fromDate, @QueryParam("toDate") LocalDate toDate){
//
//
//    };
//
//
//
//    @POST
//    public void stopSelling(@NotNull @QueryParam("productName") String productName, @QueryParam("fromDate") LocalDate fromDate, @QueryParam("toDate") LocalDate toDate){
//
//    };


}
