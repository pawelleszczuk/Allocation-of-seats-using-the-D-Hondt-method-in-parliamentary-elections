package Main;

import java.util.Locale;
import java.util.Scanner;

import static Main.Global.*;

public class WorkingTable {

    public static void proportionalityTable(){

        createProportionalityTable();

        System.out.println("Do you want to see the proportionality table? Y / N");
        Scanner scanner = new Scanner(System.in);
        String userDecision = scanner.nextLine();

        if(userDecision.equalsIgnoreCase("Y")){
            PrintAndExportTableToFile.printTable(completeWorkingTable);
        }

        System.out.println("Do you want to export the proportionality table to external file? Y / N");
        userDecision = scanner.nextLine();
        if(userDecision.equalsIgnoreCase("Y")){
            PrintAndExportTableToFile.exportTableToFile(completeWorkingTable);
        }
        System.out.println();

    }



    public static void createProportionalityTable(){
        String[] firstRowOfWorkingTable = new String[numberOfElectionCommittees+1];
        firstRowOfWorkingTable[0] = "Divider";
        for(int i = 1; i < (numberOfElectionCommittees+1); i++){
            firstRowOfWorkingTable[i] = listOfCommittees.get(i);
        }

        int[] firstColumnOfWorkingTable = new int[numberOfMandatesToBeDistributed];
        for(int i = 0; i < numberOfMandatesToBeDistributed; i++){
            firstColumnOfWorkingTable[i] = i+1;
        }

        float[][] workingTable = new float[numberOfMandatesToBeDistributed][numberOfElectionCommittees];
        for(int i = 0; i < numberOfElectionCommittees; i++){
            for(int j = 0; j < numberOfMandatesToBeDistributed; j++){
                float number = (numberOfVotesForTheCommittees.get(listOfCommittees.get(i+1)));
                workingTable[j][i] = number / (firstColumnOfWorkingTable[j]);
            }
        }
        System.out.println();

        completeWorkingTable(firstRowOfWorkingTable, firstColumnOfWorkingTable, workingTable);
    }



    public static void completeWorkingTable(String firstRowOfWorkingTable[], int firstColumnOfWorkingTable[], float workingTable[][]){
        completeWorkingTable = new String[numberOfMandatesToBeDistributed +1][numberOfElectionCommittees+1];
        for(int i = 0; i < numberOfElectionCommittees+1; i++){
            completeWorkingTable[0][i] = firstRowOfWorkingTable[i];
        }

        for(int i = 0; i < numberOfMandatesToBeDistributed; i++){
            completeWorkingTable[i+1][0] = String.valueOf(firstColumnOfWorkingTable[i]);
        }

        for(int i = 0; i < numberOfElectionCommittees; i++){
            for(int j = 0; j < numberOfMandatesToBeDistributed; j++){
                completeWorkingTable[j+1][i+1] = String.format(Locale.US,"%.2f", (workingTable[j][i]));
            }
        }

    }

}