package com.bookkeeping.com.bookkeeping.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager {
    private static String URL = "jdbc:h2:tcp://localhost/~/bookkeeping";
    private static Connection connection = null;
    private static String SqlQuery = "SELECT * FROM bookkeeping";


    public static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found , try again , later ...");
            //e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, "sa", "");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            //e.printStackTrace();
        }
        return connection;
    }
    public static void dataBaseCreate(String name, int m, int s, String p){
        try {
            Statement statement = DataBaseManager.getConnection().createStatement();
            statement.execute(String.format("INSERT INTO BOOKKEEPING (name, budget, spentmoney, nameproduct) " +
                    "VALUES ('%s',%d,%d,'%s')",name,m,s,p));
        } catch (SQLException e) {
            System.out.println("Can't create statement!!!");
            e.printStackTrace();
        }
    }

}

