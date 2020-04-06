package ru.geekbrains.HW;

public class Homework {
    private static float task1 (int a, int b, int c, int d) {
        return (a * (b + (c / d)));
    }
    private static boolean task2 (int a, int b){
        return (a + b) >= 10 && (a + b) <= 20;
    }
    private static void task3 (int a){
        if (a >= 0){
            System.out.println("Введено положительное число");
        } else {
            System.out.println("Введено отрицательное число");
        }
    }
    private static String task4 (String a){
        return "Привет, " + a + "!";
    }
    private static void task5 (int year){
        if (year % 400 == 0){
            System.out.println(year + " - високосный год!");
        } else if (year % 100 == 0){
            System.out.println(year + " - НЕ високосный год!");
        } else if (year % 4 == 0){
            System.out.println(year + " - високосный год!");
        } else {
            System.out.println(year + " - НЕ високосный год!");
        }
    }
    public static void main (String [] args){
        //System.out.println(task1(10, 20, 30, 40));
        //System.out.println(task2(10, 20));
        //task3(-4);
        //System.out.println(task4("Денис"));
        task5(16);
    }
}

