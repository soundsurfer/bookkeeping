package com.bookkeeping.budget;

import com.bookkeeping.db.DataBaseManager;

import java.util.Scanner;

public class Budget {
    static Scanner scanner = new Scanner(System.in);
    private static int m;
    private static int s;
    private static String p;

    public static void budgetRun(String name){
        addMoney();
        spentMoney();
        nameProduct();
        createBudget(name, m, s, p);
    }
    private static void addMoney(){
        System.out.println("Please, enter how much money you add to budget:");
        m = scanner.nextInt();
    }
    private static void spentMoney(){
        System.out.println("How much money you spent today?");
        s = scanner.nextInt();
    }
    private static void nameProduct(){
        System.out.println("What did you spend money on?");
        p = scanner.next();
    }
    public static void budgetStatus(){
        System.out.println("Now you have:" + m);
        System.out.println("You spent today:" + s);
    }
    private static void createBudget(String name, int m, int s, String p){
        DataBaseManager.insert(name, m, s, p);
    }
}
