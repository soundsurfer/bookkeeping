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
    }

    private static int addMoney() {
        System.out.println("Please, enter how much money you add to budget:");
        int addingMoney = scanner.nextInt();
        if(addingMoney <= 0){
            System.out.println("Please , enter valid sum of money!");
            return scanner.nextInt();
        }else
        return addingMoney;
    }

    private static void spentMoney(String name) {
        System.out.println("How much money you spent today?");
        int spentMoneyToday = scanner.nextInt();
        try {
            ResultSet rs = DataBaseManager.getByBudget(name);
            while (rs.next()) {
                if (rs.getInt("BUDGET") < spentMoneyToday) {
                    System.out.println("You have not enough money,try again");
                    spentMoney(name);
                } else
                    DataBaseManager.updateBudget(rs.getInt("BUDGET") - spentMoneyToday, spentMoneyToday, nameProduct(), name);
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

    public static boolean isUserExist(String name) {
        ResultSet rs = DataBaseManager.getByName(name);
        try {
            while(rs.next()){
                if(rs.getString("name").equals(name))
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
