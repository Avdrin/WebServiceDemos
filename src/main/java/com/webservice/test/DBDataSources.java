package com.webservice.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Katz on 14.12.2016.
 */
public class DBDataSources {

    DBConnection dbConnection = new DBConnection();

    protected void dropTable() {
        try {
            Statement statement = dbConnection.getConnection().createStatement(); //connection.createStatement();
            String sql = "DROP TABLE IF EXISTS testTable";
            statement.executeUpdate(sql);
            System.out.print("dropp");
        } catch (SQLException e) {
            System.out.print("err =="+e);
        }
    }
        protected void createTable() {
        try {
            Statement statement = dbConnection.getConnection().createStatement(); //connection.createStatement();
            String sql = "CREATE TABLE testTable (id IDENTITY NOT NULL, title VARCHAR(255) NOT NULL, price DECIMAL(10,2), dateFrom DATE, dateTo DATE);"; //"CREATE TABLE testTable (id IDENTITY , value VARCHAR(255), talue VARCHAR(255))";
            statement.executeUpdate(sql);
            System.out.print("createss");
        } catch (SQLException e) {
            System.out.print("err cr =="+e);
        }
    }

    protected void fillTable() {
        Statement statement;
        try {
            statement = dbConnection.getConnection().createStatement(); //connection.createStatement();
            String sql = "INSERT INTO testTable (title,price) VALUES('Услуга1',10.50)";
            statement.executeUpdate(sql);
            sql = "INSERT INTO testTable (title,price) VALUES('Услуга2',11.20)";
            statement.executeUpdate(sql);
            sql = "INSERT INTO testTable (title,price) VALUES('Услуга3',12.30)";
            statement.executeUpdate(sql);
            sql = "INSERT INTO testTable (title,price) VALUES('Услуга4',23.50)";
            statement.executeUpdate(sql);
            sql = "INSERT INTO testTable (title,price) VALUES('Услуга5',16.20)";
            statement.executeUpdate(sql);
            System.out.print("insertt");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void printTable() {
        Statement statement;
        try {
            statement = dbConnection.getConnection().createStatement(); //connection.createStatement();
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
    }


}
