package com.bookkeeping.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataBaseClient {

    public void select(String filter);

    public void insert(String name, int m) throws SQLException;

    public void delete();

    public int update(int sm, int spentToday, String product, String name) throws SQLException;

    public ResultSet getById(int id) throws SQLException;

    public ResultSet getByBudget(String name) throws SQLException;
}
