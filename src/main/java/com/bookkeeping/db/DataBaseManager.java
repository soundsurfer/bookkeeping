package com.bookkeeping.db;

import com.bookkeeping.utility.Settings;

import java.sql.*;

public class DataBaseManager implements DataBaseClient{
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


    public static ResultSet getByName(String name) {
        try {
            statement = DataBaseManager.getConnection().createStatement();
            return statement.executeQuery(String.format("SELECT * FROM BOOKKEEPING WHERE name = '%s'", name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getByBudget(String name) throws SQLException {
            return statement.executeQuery(String.format("SELECT BUDGET FROM BOOKKEEPING WHERE name = '%s'",name));
    }

    public void select(String filter) {

    }

    public void insert(String name, int m) throws SQLException {
        statement.execute(String.format("INSERT INTO BOOKKEEPING (name, budget) " +
                "VALUES ('%s',%d)", name, m));

    }

    public void delete() {

    }

    public int update(int sm, int spentToday, String product, String name) throws SQLException {
        return statement.executeUpdate(String.format
                ("UPDATE BOOKKEEPING SET budget = %d, spentmoney = %d, NAMEPRODUCT = '%s' WHERE name = '%s';", sm,spentToday,product, name));
    }

    public ResultSet getById(int id) throws SQLException {
        return statement.executeQuery(String.format("SELECT * FROM BOOKKEEPING WHERE id = '%d'", id));
    }
}

