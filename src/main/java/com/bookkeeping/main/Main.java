package com.bookkeeping.main;

import com.bookkeeping.budget.Budget;
import com.bookkeeping.db.DataBaseManager;
import com.bookkeeping.utility.Menu;
import com.bookkeeping.utility.Settings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Settings.readConfig();
        Menu.menu1();

    }
}
