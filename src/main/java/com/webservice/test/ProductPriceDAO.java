package com.webservice.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 * Created by Katz on 14.12.2016.
 */
public class ProductPriceDAO implements ProductPricesDAO {
    DBConnection dbConnection;

    @Override
    public BigDecimal getPrice(String productName, LocalDate dateFrom, LocalDate dateTo) {
        dbConnection = new DBConnection();
        dbConnection.loadDriver();

        Connection connection = dbConnection.getConnection();
        BigDecimal price = BigDecimal.ZERO;
//        ProductPrice productPrice;
        try {
            Statement statement = connection.createStatement(); //connection.createStatement();
            String sql = "SELECT id, title, price, dateFrom, dateTo FROM testTable WHERE title=" + productName;  //id, namepr, price
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
//                productPrice = resultSet;
                System.out.println(resultSet.getInt(1) + " "
                        + resultSet.getString(2) + " "
                        + resultSet.getString(3));
                price = resultSet.getBigDecimal("price"); 
            }
            System.out.print("voidd");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return price;
    }

    @Override
    public String getProductName() throws SQLException {

        dbConnection = new DBConnection();
        dbConnection.loadDriver();

        Connection connection = dbConnection.getConnection();

        try {
            Statement statement = connection.createStatement(); //connection.createStatement();
            String sql = "SELECT id, title, price FROM testTable";  //id, namepr, price
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " "
                        + resultSet.getString(2) + " "
                        + resultSet.getString(3));
            }
            System.out.print("voidd");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public BigDecimal getProductPrice() {
        return null;
    }

    @Override
    public LocalDate getValidFrom() {
        return null;
    }

    @Override
    public LocalDate getValidTo() {
        return null;
    }
}
