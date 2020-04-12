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
            fieldSizeY = 5;
            fieldSizeX = 5;
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
            boolean checkHor;
            boolean checkVer;
            boolean checkDia1;
            boolean checkDia2;
            int winCountHor;
            int winCountVer;
            int winCountDia1;
            int winCountDia2;

            for (int i = 0; i < fieldSizeY; i++){
               checkHor = true;
               checkVer = true;
               checkDia1 = true;
               checkDia2 = true;
               winCountHor = 0;
               winCountVer = 0;
               winCountDia1 = 0;
               winCountDia2 = 0;
               for (int j = 0; j < fieldSizeX; j++){
                   checkHor = checkHor && (field [i][j] == c);
                   if (checkHor) winCountHor++;
                   checkVer = checkVer && (field [j][i] == c);
                   if (checkVer) winCountVer++;
                   checkDia1 = checkDia1 && (field [j][j] == c);
                   if (checkDia1) winCountDia1++;
                   checkDia2 = checkDia2 && (field [j][fieldSizeX-1-j] == c);
                   if (checkDia2) winCountDia2++;
                   if (winCountHor == maxWinCount || winCountVer == maxWinCount || winCountDia1 == maxWinCount || winCountDia2 == maxWinCount){
                       return true;
                   }
               }
            }
        return false;
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
                    aiTurn();
                    printMap();
                    if (gameChecks(AI_DOT, "AI win!")) break;
                }
                System.out.println("Play again?");
                if (!SCANNER.next().equals("Y"))
                    break;
            }
            SCANNER.close();
            int[] arr = {1,2,3,4,5,6,7};
            arraySum("Hello", 0, arr);
            arraySum("Hello", 0, new int[] {1,2,3,4,5,6,7});
            arraySum("Hello", 0, 1,2,3,4,5,6,7);
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
