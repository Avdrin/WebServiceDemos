package com.webservice.test;


public class TestHSQLDB {

    public static void main(String[] args){

        DBConnection dbConnection = new DBConnection();
        DBDataSources dbDataSources = new DBDataSources();

//        TestHSQLDB test = new TestHSQLDB();
        if (!dbConnection.loadDriver()) return;
        if (dbConnection.getConnection()==null) return;

//        dbDataSources.dropTable();
//        dbDataSources.createTable();
//        dbDataSources.fillTable();
        dbDataSources.printTable();
        dbConnection.closeConnection();
    }

}
