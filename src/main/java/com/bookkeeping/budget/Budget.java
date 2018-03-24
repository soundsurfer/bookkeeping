package com.bookkeeping.budget;

import com.bookkeeping.db.DataBaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Budget {
    static Scanner scanner = new Scanner(System.in);
    private static int m;
    private static int s;
    private static String p;
    public static int sm;

    public static void budgetRun(String name) {
        addMoney();
        createBudget(name, m);
    }

    public static void spendingRun(int sm, String name) {
        spentMoney(name, sm);
        nameProduct();
    }

    private static void addMoney() {
        System.out.println("Please, enter how much money you add to budget:");
        m = scanner.nextInt();
    }

    private static void spentMoney(String name, int sm){
        System.out.println("How much money you spent today?");
        s = scanner.nextInt();
        try {
            ResultSet rs = DataBaseManager.getByBudget(name);
            while(rs.next()) {
                sm = rs.getInt("BUDGET") - s;
                updateBudget(sm, name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static void nameProduct(){
        System.out.println("What did you spend money on?");
        p = scanner.next();
    }
    private static void createBudget(String name, int m){
        DataBaseManager.insert(name, m);
    }
    private static void updateBudget (int sm, String name) {DataBaseManager.updateBudget(sm,name);}
}
