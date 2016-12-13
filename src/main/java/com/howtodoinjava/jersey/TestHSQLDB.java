//package com.howtodoinjava.jersey;
//
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class TestHSQLDB {
//
//    Connection connection = null;
//    String url;
//    String login;
//    String password;
//
//
//    public static void main(String[] args){
//
//        TestHSQLDB test = new TestHSQLDB();
//        if (!test.loadDriver()) return;
//        if (!test.getConnection()) return;
//
//        test.createTable();
//        test.fillTable();
//        test.printTable();
//        test.closeConnection();
//    }
//
//    private boolean loadDriver() {
//
//        try {
//            Class.forName("org.hsqldb.jdbc.Driver");
//            System.out.println("Драйвер известен");
//
//        } catch (ClassNotFoundException e) {
//            System.out.println("Драйвер не найден");
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    private boolean getConnection() {
////        url = "jdbc:hsqldb://localhost:3306/serv";
//        login = "root";
//        password = "";
//
//        try {
//            String path = "mypath/";
//            String dbname = "mydb";
//            String connectionString = "jdbc:hsqldb:file:"+path+dbname;
////            String login = "katz";
////            String password = "password";
//
//            //Создаём соединение
//            connection = DriverManager.getConnection(connectionString, login, password); //url, login, password);
//            System.out.println("Соединение установлено");
//
////            connection = DriverManager.getConnection(connectionString, login, password);
//
//        } catch (SQLException e) {
//            System.out.println("Соединение не создано");
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    private void createTable() {
//        try {
//            Statement statement = connection.createStatement();
//            String sql = "CREATE TABLE testTable (id IDENTITY , value VARCHAR(255))";
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//
//        }
//    }
//
//    private void fillTable() {
//        Statement statement;
//        try {
//            statement = connection.createStatement();
//            String sql = "INSERT INTO testTable (value) VALUES('Никита')";
//            statement.executeUpdate(sql);
//            sql = "INSERT INTO testTable (value) VALUES('Никас')";
//            statement.executeUpdate(sql);
//            sql = "INSERT INTO testTable (value) VALUES('Ник')";
//            statement.executeUpdate(sql);
//            sql = "INSERT INTO testTable (value) VALUES('Катя')";
//            statement.executeUpdate(sql);
//            sql = "INSERT INTO testTable (value) VALUES('Кат')";
//            statement.executeUpdate(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void printTable() {
//        Statement statement;
//        try {
//            statement = connection.createStatement();
//            String sql = "SELECT id, value FROM testTable";
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + " "
//                        + resultSet.getString(2));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void closeConnection() {
//
//        Statement statement;
//        try {
//            statement = connection.createStatement();
//            String sql = "SHUTDOWN";
//            statement.execute(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
