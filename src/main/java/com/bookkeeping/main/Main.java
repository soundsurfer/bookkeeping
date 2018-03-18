package com.bookkeeping.main;

import com.bookkeeping.budget.Budget;
import com.bookkeeping.db.DataBaseManager;
import com.bookkeeping.utility.Settings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Settings.readConfig();
        //start();
    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi! My name is Bookkeeping Manager, what's your name?");
        String name = scanner.next();
        System.out.println("Okay, " + name + ", let's go...");
        Budget.budgetRun(name);
        System.out.println("Hey, you needing some info about your budget? Print 'y' or 'n'");
        if (scanner.hasNext("y")) {
            Budget.budgetStatus();
        }
        if (scanner.hasNext("n")) {
            System.out.println("Okay, see you later ;)");
        } else ;

    }
}
