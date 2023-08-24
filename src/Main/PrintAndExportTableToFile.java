package Main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintAndExportTableToFile {

    public static void printTable(String[][] table){

        for(String[] row : table){
            for(String column : row){
                System.out.print(column + " | ");
            }
            System.out.println();
        }

        System.out.println();
    }


    public static void exportTableToFile(String[][] table){
        System.out.println("Enter the name of the file:");
        Scanner scanner = new Scanner(System.in);
        String nameOfTheFile = scanner.nextLine()+".csv";

        try {
            PrintWriter out = new PrintWriter(nameOfTheFile);

            for(String[] row : table){
                for(String column : row){
                    out.print(column + ",");
                }
                out.println();
            }
            out.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Sorry, I can't create the file!");
        }
    }

}