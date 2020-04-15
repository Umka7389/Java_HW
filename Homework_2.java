package ru.geekbrains.HW;


import java.util.Arrays;

public class Homework_2 {
    //task 1
    private static int[] changeArr (int[] arrInput) {
        for (int i = 0; i < arrInput.length; i++){
            arrInput[i] = (arrInput[i] == 0 ? 1 : 0);
        }
        return arrInput;
    }

    // task 2
    private static int[] arrFillUp (int[] arrInput){
        for (int i =0; i < arrInput.length; i++){
            arrInput[i] = i*3 +1;
        }
        return arrInput;
    }

    // task 3
    private static int[] arrMultiply (int[] arrInput){
        for (int i =0; i < arrInput.length; i++){
            arrInput[i] = (arrInput[i] < 6 ? arrInput[i] * 2 : arrInput[i]);
        }
        return arrInput;
    }

    //task 4
    private static int arrMax (int[] arrInput){
        int max = arrInput[0];
        for (int i =0; i < arrInput.length; i++){
            max = (max > arrInput[i] ? max : arrInput[i]);
        }
        return max;
    }
    private static int arrMin (int[] arrInput){
        int min = arrInput[0];
        for (int i =0; i < arrInput.length; i++){
            min = (min < arrInput[i] ? min : arrInput[i]);
        }
        return min;
    }

    //task 6
    private static boolean arrBorder (int[] arrInput){
        boolean border = false;
        for (int i = 0; i < arrInput.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j <= i; j++) {
                sumLeft += arrInput[j];
            }
            for (int j = arrInput.length - 1-i; j >= 0; j--) {
                sumRight += arrInput[j];
            }
            if (sumLeft == sumRight){
                border = true;
                break;
            }
        }
        return border;
    }

    //task 7
    private static int[] arrMovePosition (int[] arrInput, int n){
        int newN = n % arrInput.length;
        int[] arrSupport = new int[arrInput.length];
        for (int i = 0; i < arrInput.length; i++){
            if (i + newN < arrInput.length && i + newN >= 0){
                arrSupport[i+newN] = arrInput[i];
            } else if (newN > 0) {
                arrSupport[i + newN - arrInput.length] = arrInput[i];
                }
            else {
                arrSupport[i + newN + arrInput.length] = arrInput[i];
            }
            }
        return arrSupport;
    }

    //task 8
    private static int[] arrMovePositionWithoutArrSup (int[] arrInput, int n){
        int newN = n % arrInput.length;
        int a;
        if (newN > 0) {
            for (int i = 0; i < newN; i++) {
                a = arrInput[0];
                arrInput[0] = arrInput[arrInput.length - 1];
                for (int j = 1; j < arrInput.length; j++) {
                    arrInput[arrInput.length - j] = arrInput[arrInput.length - 1 - j];
                }
                arrInput[1] = a;
            }
        } else {
            for (int i = 0; i < -newN; i++) {
                a = arrInput[arrInput.length - 1];
                arrInput[arrInput.length - 1] = arrInput[0];
                for (int j = 1; j < arrInput.length-1; j++) {
                    arrInput[j-1] = arrInput[j];
                }
                arrInput[arrInput.length -2] = a;
            }
            }
        return arrInput;
    }

    public static void main (String [] args) {
        //task 1
        int[] arr_1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(changeArr(arr_1)));

        //task 2
        int [] arr_2 = new int[8];
        System.out.println(Arrays.toString(arrFillUp(arr_2)));

        //task3
        int[] arr_3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println(Arrays.toString(arrMultiply(arr_3)));

        //task4
        int[] arr_4 = {1, 4, 7, 10, 13, 16, 19, 22};
        System.out.println(arrMax(arr_4));
        System.out.println(arrMin(arr_4));

        //task5
        int[][] arr_5 = new int [5][5];
        for (int i = 0; i < arr_5.length; i++){
            for (int j = 0; j < arr_5[0].length; j++){
                arr_5[i][j] = (i == j ? 1 : arr_5[i][j] );
            }
        }
        for (int i = 0; i < arr_5.length; i++) {
            System.out.println(Arrays.toString(arr_5[i]));
        }

        //task6
        int [] arr_6 = {10, 1, 2, 3, 4, 5};
        System.out.println(arrBorder(arr_6));

        //task7
        int [] arr_7 = {10, 1, 2, 3, 4};
        System.out.println(Arrays.toString(arrMovePosition(arr_7, -12)));

        //task8
        int [] arr_8 = {10, 1, 2, 3, 4};
        System.out.println(Arrays.toString(arrMovePositionWithoutArrSup(arr_8, 12)));
    }
}
