package com.bookkeeping.utility;

import com.bookkeeping.budget.Budget;
import com.bookkeeping.db.DataBaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.bookkeeping.budget.Budget.sm;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    public static void menu1() {
        System.out.println("Hi! My name is Bookkeeping Manager, what's your name?");
        String name = scanner.next();
        System.out.println("Hi! " + name + ", what you need?");
        if (scanner.hasNext("newbudget")) {
            Budget.budgetRun(name);
            taskMenu1();
        }
        if (scanner.hasNext("budgetstatus")) {
            try {
                System.out.println("Right now, you have:");
                ResultSet rs = DataBaseManager.getByBudget(name);
                while (rs.next()){
                    System.out.println(rs.getString("BUDGET"));
                    taskMenu1();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (scanner.hasNext("spent")){
            Budget.spendingRun(sm, name);
        }
        if (scanner.hasNext("search")){
            searching();
        }
    }
    public static void taskMenu1() {

        System.out.println("Okay, you wanna back?");
        if (scanner.hasNext("y")) {
            menu1();
        }
        else;
    }
    public static void searching(){
        //TODO Create logic for searching
    }
}

