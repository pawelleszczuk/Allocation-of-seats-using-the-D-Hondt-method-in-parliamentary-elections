package Main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
import static Main.Main.*;

public class WorkingTable {

    public static void workingTable(){

        numberOfElectionCommittees = listOfCommittees.size();

        String[] firstRowOfWorkingTable = new String[numberOfElectionCommittees+1];
        firstRowOfWorkingTable[0] = "Divider";
        for(int i = 1; i < numberOfElectionCommittees+1; i++){
            firstRowOfWorkingTable[i] = listOfCommittees.get(i);
        }

        int[] firstColumnOfWorkingTable = new int[numberOfSeatsToBeDistributed];
        for(int i = 0; i < numberOfSeatsToBeDistributed; i++){
            firstColumnOfWorkingTable[i] = i+1;
        }

        float[][] workingTable = new float[numberOfSeatsToBeDistributed][numberOfElectionCommittees];
            for(int i = 0; i < numberOfElectionCommittees; i++){
                for(int j = 0; j < numberOfSeatsToBeDistributed; j++){
                    float number = (Main.numberOfVotes.get(listOfCommittees.get(i+1)));
                    workingTable[j][i] = number / (firstColumnOfWorkingTable[j]);
                }
            }
        System.out.println();

        completeWorkingTable(firstRowOfWorkingTable, firstColumnOfWorkingTable, workingTable);


        System.out.println("Do you want to see the proportionally table? Y / N");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();

        if(decision.equalsIgnoreCase("Y")){
            printCompleteWorkingTable();
        }

        System.out.println("Do you want to export the proportionally table to external file? Y / N"); // do jakiego pliku, jaka ścieżka?
        decision = scanner.nextLine();
        if(decision.equalsIgnoreCase("Y")){
            exportFile();
        }
        System.out.println();

    }


    public static void completeWorkingTable(String firstRowOfWorkingTable[], int firstColumnOfWorkingTable[], float workingTable[][]){
        completeWorkingTable = new String[numberOfSeatsToBeDistributed+1][numberOfElectionCommittees+1];
        for(int i = 0; i < numberOfElectionCommittees+1; i++){
            completeWorkingTable[0][i] = firstRowOfWorkingTable[i];
        }

        for(int i = 0; i < numberOfSeatsToBeDistributed; i++){
            completeWorkingTable[i+1][0] = String.valueOf(firstColumnOfWorkingTable[i]);
        }

        for(int i = 0; i < numberOfElectionCommittees; i++){
            for(int j = 0; j < numberOfSeatsToBeDistributed; j++){
                completeWorkingTable[j+1][i+1] = String.format(Locale.US,"%.2f", (workingTable[j][i]));
            }
        }


    }


    public static void printCompleteWorkingTable(){
        for(int i = 0; i < numberOfSeatsToBeDistributed+1; i++){
            for(int j = 0; j < numberOfElectionCommittees+1; j++){
                System.out.print(completeWorkingTable[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void exportFile() {
        System.out.println("Enter the name of the file with extension:");
        Scanner scanner = new Scanner(System.in);
        String nameOfTheFile = scanner.nextLine();

        try {
            PrintWriter out = new PrintWriter(nameOfTheFile);

            for(int i = 0; i < numberOfSeatsToBeDistributed+1; i++) {
                for (int j = 0; j < numberOfElectionCommittees + 1; j++) {
                    out.print(completeWorkingTable[i][j] + "|");
                }
                out.println();
            }

            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry, I can't create the file!");
        }
    }

}