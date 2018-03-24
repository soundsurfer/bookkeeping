package com.bookkeeping.db;

public interface DataBaseClient {

    public void select(String filter);

    public void insert();

    public void delete();

    public void update();

    public void getBy(String filter);
}
