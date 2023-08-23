package Main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintAndExportTableToFile {

    public static void printTable(String[][] table, int numberOfRows, int numberOfColumns){
        for(int i = 0; i < numberOfColumns; i++){
            for(int j = 0; j < numberOfRows; j++){
                System.out.print(table[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void exportTableToFile(String[][] table, int numberOfRows, int numberOfColumns){
        System.out.println("Enter the name of the file:");
        Scanner scanner = new Scanner(System.in);
        String nameOfTheFile = scanner.nextLine()+".csv";

        try {
            PrintWriter out = new PrintWriter(nameOfTheFile);

            for(int i = 0; i < numberOfColumns; i++) {
                for (int j = 0; j < numberOfRows; j++) {
                    out.print(table[i][j] + ",");
                }
                out.println();
            }
            out.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Sorry, I can't create the file!");
        }
    }

}