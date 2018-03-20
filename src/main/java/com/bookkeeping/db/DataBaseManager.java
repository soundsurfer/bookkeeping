package com.bookkeeping.db;

import com.bookkeeping.utility.Settings;

import java.sql.*;

public class DataBaseManager implements DataBaseClient{

    private static Statement statement;

    public DataBaseManager() throws SQLException,ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(
                Settings.properties.getProperty("URL"),
                Settings.properties.getProperty("USER"),
                Settings.properties.getProperty("PASSWORD"));

        statement = connection.createStatement();
    }


    public ResultSet select(String filter, String table) throws SQLException {
        return statement.executeQuery(String.format("select %s from %s",filter,table));
    }

    public boolean insert(String[] data, String table) {
       //TODO Create logic for insert method
        return true;
    }

    public boolean delete(String filter, String table) {
        return true;
    }

    public void update(String[] data, String table) {
        //TODO Create logic for update method
    }

    public ResultSet getById(int id, String table) throws SQLException {
        return statement.executeQuery(String.format("select * from %s where id = '%d'",table,id));
    }

    public ResultSet getBy(String filter, String table) throws SQLException {
        return statement.executeQuery(String.format("select %s from %s",filter,table));
    }

    public static void insert(String name, int m, int s, String p) {
    }
}

