package com.bookkeeping.main;

import com.bookkeeping.utility.Menu;
import com.bookkeeping.utility.Settings;

public class Main {
    public static void main(String[] args) {
        Settings.readConfig();
        Menu.menu1();
    }
}
