package com.webservice.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Katz on 14.12.2016.
 */
public class DBConnection {

    Connection connection = null;
    String url;
    String login;
    String password;



    protected boolean loadDriver() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            System.out.println("Драйвер известен");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер не найден");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    protected Connection getConnection() {
//        url = "jdbc:hsqldb:hsql:/localhost/test"; //"jdbc:hsqldb://localhost:3306/serv";
        login = "root";
        password = "";

        try {
            String path = "mypath/";
            String dbname = "mydb";
            String connectionString = "jdbc:hsqldb:file:"+path+dbname;
//
            connection = DriverManager.getConnection(connectionString, login, password);
            System.out.println("Соединение установлено");

        } catch (SQLException e) {
            System.out.println("Соединение не создано");
            e.printStackTrace();
            return null; //false;
        }
        return connection; //true;
    }


    protected void closeConnection() {
        Statement statement;
        try {
            statement = connection.createStatement();
            String sql = "SHUTDOWN";
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//      public BasicDataSource dataSource() {
//      BasicDataSource ds = new BasicDataSource();
// 	    ds.setDriverClassName("org.postgresql.Driver");
// 		ds.setUrl("jdbc:postgresql://192.168.60.102:5432/nikasappdb");
// 		ds.setUsername("commonuser");
// 		ds.setPassword("password");
//      ds.setDriverClassName("org.hsqldb.jdbcDriver");
//      ds.setUrl("jdbc:hsqldb:hsql:/localhost/test");
//      ds.setUsername("sa");
//      ds.setPassword("");
//      return ds; 	}

}
