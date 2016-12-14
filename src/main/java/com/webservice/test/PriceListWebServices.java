package com.webservice.test;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Katz on 12.12.2016.
 */
public interface PriceListWebServices {

    // Получает цену товара на указанную дату. Если товар не
    // продается в указанную дату, то возвращает пустой ответ с HTTP-кодом No Content.
    //
    // Если товар с переданным именем еще не был внесен в прайс-лист,
    // возвращает пустой ответ с HTTP-кодом Not Found.
    @GET
    BigDecimal getPrice(@NotNull @QueryParam("productName") String productName, @NotNull @QueryParam("date") LocalDate date);




    // Получает цены товара с промежутками действия цены.
    // Результат отсортирован в порядке возрастания даты действия
    // цены.
    //
    // Если товар с переданным именем еще не был внесен в прайс-лист,
    // возвращает пустой ответ с HTTP-кодом Not Found.
    @GET
    List<ProductPrice> getPrices(@NotNull @QueryParam("productName") String productName);





    // Устанавливает цену товара в указанном интервале дат, цена
    // действует на протяжении всего интервала, включая его границы.
    // Если fromDate или toDate не установлены, то левая (правая) граница
    // интервала считается равной минус (плюс) бесконечности.
    //
    // Если для товара уже была ранее установлена другая цена в
    // какие-то из дней указанного периода, она будет изменена на
    // переданную в этом методе. При этом цены, установленные на
    // даты, не попадающие в заданный интервал, остаются неизменными.
    //
    // Если параметр fromDate больше toDate, возвращает HTTP-код Internal Server Error.
    @POST
    void setPrice(@NotNull @QueryParam("productName") String productName, @NotNull @QueryParam("price") @DecimalMin("0") BigDecimal price, @QueryParam("fromDate") LocalDate fromDate, @QueryParam("toDate") LocalDate toDate);





    // Прекращает продажу товара в указанном интервале дат, товар
    // не доступен к продаже на протяжении всего интервала, включая
    // его границы. Если fromDate или toDate не установлены, то левая
    // (правая) граница интервала считается равной минус (плюс)
    // бесконечности.
    //
    // Если параметр fromDate больше toDate, возвращает HTTP-код Internal Server Error.
    //
    // Если товар с переданным именем еще не был внесен в прайс-лист,
    // возвращает пустой ответ с HTTP-кодом Not Found.
    @POST
    void stopSelling(@NotNull @QueryParam("productName") String productName, @QueryParam("fromDate") LocalDate fromDate, @QueryParam("toDate") LocalDate toDate);



}
