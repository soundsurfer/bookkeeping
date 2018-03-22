package com.bookkeeping.db;

import com.bookkeeping.utility.Settings;

import java.sql.*;

public class DataBaseManager {
    private static Connection connection = null;

    private static Statement statement;

    private static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found , try again , later ...");
            //e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(
                    Settings.properties.getProperty("URL"),
                    Settings.properties.getProperty("USER"),
                    Settings.properties.getProperty("PASSWORD"));
        } catch (SQLException e) {
            System.out.println("Connection failed");
            //e.printStackTrace();
        }
        return connection;
    }

    public static void insert(String name, int m, int s, String p) {
        try {
            statement = DataBaseManager.getConnection().createStatement();
            statement.execute(String.format("INSERT INTO BOOKKEEPING (name, budget, spentmoney, nameproduct) " +
                    "VALUES ('%s',%d,%d,'%s')", name, m, s, p));
        } catch (SQLException e) {
            System.out.println("Can't create statement!!!");
            e.printStackTrace();
        }
    }

    public static ResultSet getByName(String name) {
        try {
            statement = DataBaseManager.getConnection().createStatement();
            return statement.executeQuery(String.format("SELECT * FROM BOOKKEEPING WHERE name = '%s'", name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet getById(int id) {
        try {
            statement = DataBaseManager.getConnection().createStatement();
            return statement.executeQuery(String.format("SELECT * FROM BOOKKEEPING WHERE id = '%d'", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ResultSet getByBudget(String name){
        try {

            statement = DataBaseManager.getConnection().createStatement();
            return statement.executeQuery(String.format("SELECT BUDGET FROM BOOKKEEPING WHERE name = '%s'",name));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}

