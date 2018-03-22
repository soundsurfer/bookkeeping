package com.bookkeeping.utility;

import com.bookkeeping.budget.Budget;
import com.bookkeeping.db.DataBaseManager;

import java.util.Scanner;

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
            System.out.println("Right now, you have:" + DataBaseManager.getByBudget(name));
        }
    }
    public static void taskMenu1(){
        System.out.println("Hey, you needing some info about your budget? Print 'y' or 'n'");
        if (scanner.hasNext("y")) {
            Budget.budgetStatus();
        }
        if (scanner.hasNext("n")) {
            System.out.println("Okay, you wanna back?");
            if (scanner.hasNext("y")){
                menu1();
            }
            else ;
        } else ;
    }
}

