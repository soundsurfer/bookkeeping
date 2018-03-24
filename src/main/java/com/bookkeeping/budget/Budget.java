package com.bookkeeping.budget;

import com.bookkeeping.db.DataBaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Budget {
    static Scanner scanner = new Scanner(System.in);

    public static void budgetRun(String name) {
        createBudget(name, addMoney());
    }

    public static void spendingRun(String name) {
        spentMoney(name);
        nameProduct();
    }

    private static int addMoney() {
        System.out.println("Please, enter how much money you add to budget:");
        return scanner.nextInt();
    }

    private static void spentMoney(String name) {
        System.out.println("How much money you spent today?");
        int spentMoneyToday = scanner.nextInt();
        try {
            ResultSet rs = DataBaseManager.getByBudget(name);
            while (rs.next()) {
                DataBaseManager.updateBudget(rs.getInt("BUDGET") - spentMoneyToday,nameProduct(), name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String nameProduct() {
        System.out.println("What did you spend money on?");
        return scanner.next();
    }

    private static void createBudget(String name, int m) {
        DataBaseManager.insert(name, m);
    }

}
