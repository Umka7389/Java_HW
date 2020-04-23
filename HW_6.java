package ru.geekbrains.HW.Java_HW;

import java.io.*;
import java.util.Scanner;

public class HW_6 {
    public static void CreateFile (String fileName, String txt ){
        try {
            PrintStream ps_1 = new PrintStream(new FileOutputStream(fileName, true));
            ps_1.println(txt);
            ps_1.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static boolean checkTxtContainInFile (String fileForCheck, String checkString ) throws IOException {
        FileInputStream fileForCheckIS = new FileInputStream(fileForCheck);
        StringBuilder fileString = new StringBuilder();
        Scanner scanner = new Scanner(fileForCheckIS);
        while (scanner.hasNext()){
            fileString.append(scanner.nextLine()).append("\n");}
        scanner.close();
        fileForCheckIS.close();
        return fileString.toString().contains(checkString);
    }
    public static boolean checkTxtContainInDirectory (String searchDirectory, String checkString ) throws IOException {
        File searchFile = new File(searchDirectory);
        for (int i = 0; i < searchFile.list().length; i++) {
            if (checkTxtContainInFile(searchDirectory + "\\" + searchFile.list()[i], checkString)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        String fileForInput = "file_1.txt";
        String fileForCopy = "file_2.txt";
        String checkString = "Continue of the first part with another symbols...................\n13";
        CreateFile (fileForInput, "There is a first part of the text! Some kind of symbols...........................");
        CreateFile (fileForCopy, "Continue of the first part with another symbols...................\n13245");
        String searchDirectory = "C:\\files";
        try {
            FileInputStream fileForInputIS = new FileInputStream(fileForCopy);
            Scanner scanner = new Scanner(fileForInputIS);
            PrintStream ps_1 = new PrintStream(new FileOutputStream(fileForInput, true));
            String stringForCopy = "";
            while (scanner.hasNext()) {
                stringForCopy = scanner.nextLine();
                ps_1.println(stringForCopy);
            }
            fileForInputIS.close();
            ps_1.close();
            scanner.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        if (checkTxtContainInFile(fileForInput, checkString)) {
            System.out.println("Файл содержит указанное слово");
        } else System.out.println("Файл НЕ содержит указанное слово");

        if (checkTxtContainInDirectory(searchDirectory, checkString)) {
            System.out.println("Папка содержит указанное слово");
        } else System.out.println("Папка НЕ содержит указанное слово");
    }
}
