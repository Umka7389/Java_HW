package ru.geekbrains.HW;

public class Homework {
    private static float task1 (int a, int b, float c, int d) {
        return (a * (b + (c / d)));
    }
    private static boolean task2 (int a, int b){
        return (a + b) >= 10 && (a + b) <= 20;
    }
    private static boolean task3 (int a){
        boolean c = true;
        if (a < 0) {
            c = false;
        }
        return c;
    }
    private static String task4 (String a){
        return "Привет, " + a + "!";
    }
    private static boolean task5 (int year){
        boolean c = false;
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0){
            c = true;
        }
        return c;
    }
    public static void main (String [] args){
        //System.out.println(task1(10, 20, 30, 40));
        //System.out.println(task2(10, 20));
        /*
        if (task3(0)){
            System.out.println("Введено положительное число");
        } else {
            System.out.println("Введено отрицательное число");
        }
        */
        //System.out.println(task4("Денис"));
       /* if (task5(100)){
            System.out.println("Год висоскосный!");
        } else {
            System.out.println("Год невисокосный!");
        }*/
    }
}

