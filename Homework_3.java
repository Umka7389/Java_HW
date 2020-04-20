package ru.geekbrains.HW.Java_HW;

import java.util.Random;
import java.util.Scanner;

public class Homework_3 {

    public static class TicTacToe {

        private static int fieldSizeY;
        private static int fieldSizeX;
        private static char[][] field;
        private static int maxWinCount = 4;

        private static final Scanner SCANNER = new Scanner(System.in);
        private static final Random RANDOM = new Random();

        private static final char HUMAN_DOT = 'X';
        private static final char AI_DOT = 'O';
        private static final char EMPTY_DOT = '.';


        // init field
        private static void initMap() {
            fieldSizeY = 10;
            fieldSizeX = 10;
            field = new char[fieldSizeY][fieldSizeX];
            for (int y = 0; y < fieldSizeY; y++) {
                for (int x = 0; x < fieldSizeX; x++) {
                    field[y][x] = EMPTY_DOT;
                }
            }
        }

        // print field
        private static void printMap() {
            System.out.println("-------");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print("|");
                for (int x = 0; x < fieldSizeX; x++) {
                    System.out.print(field[y][x] + "|");
                }
                System.out.println();
            }
        }

        // human turn
        private static void humanTurn() {
            int x;
            int y;
            do {
                System.out.println("Заполните от 1 до 5-х");
                x = SCANNER.nextInt() - 1;
                y = SCANNER.nextInt() - 1;
            } while (!(isEmptyCell(y, x) && isValidCell(y, x)));
            field[y][x] = HUMAN_DOT;
        }

        // is cell empty
        private static boolean isEmptyCell(int y, int x) {
            return field[y][x] == EMPTY_DOT;
        }

        // is cell valid
        private static boolean isValidCell(int y, int x) {
            return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
        }

        // ai turn
        private static void aiTurn() {
            int x;
            int y;
            do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
            } while (!isEmptyCell(y, x));
            field[y][x] = AI_DOT;
        }

        // check win
        private static boolean checkWin(char c) {

            for (int y = 0; y < fieldSizeY; y++){
               for (int x = 0; x < fieldSizeX; x++){
                   if (checkHorLine(y, x, c, maxWinCount) ||
                       checkVertLine(y, x, c, maxWinCount) ||
                       checkDiaUpLine(y, x, c, maxWinCount) ||
                       checkDiaDownLine(y, x, c, maxWinCount))
                   return true;
               }
            }
        return false;
        }

        // prevent win check
        private static boolean preventWinCheck() {
            for (int i = 0; i < fieldSizeY; i++){
                for (int j = 0; j < fieldSizeX; j++){
                    char c = field [i][j];
                    for (int y = 0; y < fieldSizeY; y++){
                        for (int x = 0; x < fieldSizeX; x++){
                            if (isEmptyCell(j, i)) {
                                field[i][j] = HUMAN_DOT;
                                if (checkHorLine(y, x, HUMAN_DOT, maxWinCount) ||
                                    checkVertLine(y, x, HUMAN_DOT, maxWinCount) ||
                                    checkDiaUpLine(y, x, HUMAN_DOT, maxWinCount) ||
                                    checkDiaDownLine(y, x, HUMAN_DOT, maxWinCount)) {
                                    field[i][j] = AI_DOT;
                                    return true;
                                }
                            }
                        }
                    }
                    field [i][j] = c;
                }
            }
            return false;
        }

        //checkHorWin
        private static boolean checkHorLine (int y, int x, char c, int maxWinCount){
            if (x + maxWinCount <= fieldSizeX){
                for (int i = x; i < (x + maxWinCount); i++) {
                    if (field [y][i] != c){
                        return false;
                    }
                } return true;
            } else return false;
        }

        //checkVertWin
        private static boolean checkVertLine (int y, int x, char c, int maxWinCount){
            if (y + maxWinCount <= fieldSizeY){
                for (int i = y; i < (y + maxWinCount); i++) {
                    if (field [i][x] != c){
                        return false;
                    }
                } return true;
            } else return false;
        }

        //checkDiaUpWin
        private static boolean checkDiaUpLine (int y, int x, char c, int maxWinCount){
            if (y - maxWinCount >= 0 && x + maxWinCount <= fieldSizeX){
                for (int i = y, j = x; i > (y - maxWinCount) && j < (x + maxWinCount); i--, j++) {
                    if (field [i][j] != c){
                        return false;
                    }
                } return true;
            } else return false;
        }

        //checkDiaDownWin
        private static boolean checkDiaDownLine (int y, int x, char c, int maxWinCount){
            if (y + maxWinCount <= fieldSizeY && x + maxWinCount <= fieldSizeX){
                for (int i = y, j = x; i < (y + maxWinCount) && j < (x + maxWinCount); i++, j++) {
                    if (field [i][j] != c){
                        return false;
                    }
                } return true;
            } else return false;
        }

        // check draw
        private static boolean isMapFull() {
            for (int y = 0; y < fieldSizeY; y++) {
                for (int x = 0; x < fieldSizeX; x++) {
                    if (isEmptyCell(y, x)) return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            while (true) {
                initMap();
                printMap();
                while (true) {
                    humanTurn();
                    printMap();
                    if (gameChecks(HUMAN_DOT, "Human win!")) break;
                    if(!preventWinCheck()) aiTurn();
                    printMap();
                    if (gameChecks(AI_DOT, "AI win!")) break;
                }
                System.out.println("Play again?");
                if (!SCANNER.next().equals("Y"))
                    break;
            }
            SCANNER.close();
/*
            int[] arr = {1,2,3,4,5,6,7};
            arraySum("Hello", 0, arr);
            arraySum("Hello", 0, new int[] {1,2,3,4,5,6,7});
            arraySum("Hello", 0, 1,2,3,4,5,6,7);
*/
        }

        private static int arraySum(String s, int b, int... a) {
            int r = 0;
            for (int i = 0; i < a.length; i++) {
                r += a[i];
            }
            return r;
        }

        private static boolean gameChecks(char aiDot, String s) {
            if (checkWin(aiDot)) {
                System.out.println(s);
                return true;
            }
            if (isMapFull()) {
                System.out.println("draw!");
                return true;
            }
            return false;
        }
    }
}
