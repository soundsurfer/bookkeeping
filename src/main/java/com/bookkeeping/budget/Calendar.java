package com.bookkeeping.budget;

public class Calendar {
    public static int day(int M, int D, int Y){
        int y = Y - (14 - M) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = M + 12 * ((14 - M) / 12) - 2;
        int d = (D + x + (31*m)/12) % 7;
        return d;
    }
    public static boolean isLeapYear(int year) {
        if  ((year % 4 == 0) && (year % 100 != 0)) return true;
        if  (year % 400 == 0) return true;
        return false;
    }

    public static void time(String[] args) {
        int M = Integer.parseInt(args[0]);
        int Y = Integer.parseInt(args[1]);


        String[] months = {
                "",
                "January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"
        };

        int[] days = {
                0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        if (M == 2 && isLeapYear(Y)) days[M] = 29;

        System.out.println("   " + months[M] + " " + Y);
        System.out.println(" S  M Tu  W Th  F  S");

        int d = day(M, 1, Y);

        for (int i = 0; i < d; i++)
            System.out.print("   ");
        for (int i = 1; i <= days[M]; i++) {
            System.out.printf("%2d ", i);
            if (((i + d) % 7 == 0) || (i == days[M])) System.out.println();
        }

    }
}
