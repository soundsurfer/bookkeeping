package com.bookkeeping.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataBaseClient {

    public ResultSet select(String filter, String table) throws SQLException;

    public boolean insert(String[] data, String table);

    public boolean delete(String filter, String table);

    public void update(String[] data, String table);

    public ResultSet getById(int id, String table) throws SQLException;

    public ResultSet getBy(String filter, String table) throws SQLException;
}
