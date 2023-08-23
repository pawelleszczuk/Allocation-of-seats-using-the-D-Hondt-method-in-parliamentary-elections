package Main;

import java.util.Locale;
import java.util.Scanner;

import static Main.Global.*;

public class MandateAllocationReport {

    static String[][] parliamentarySeatDistributionTable;
    static String[][] mainReportTable;

    public static void mandateAllocationToCommitteesReport(){

        createMainReportTable();

        System.out.println("Do you want to see the Main Report Table? Y / N");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();

        if(decision.equalsIgnoreCase("Y")){
            PrintAndExportTableToFile.printTable(completeMainReportTable, (numberOfElectionCommittees + 1), 6);
        }

        System.out.println("Do you want to export the Main Report Table to external file? Y / N");
        decision = scanner.nextLine();
        if(decision.equalsIgnoreCase("Y")){
            PrintAndExportTableToFile.exportTableToFile(completeMainReportTable, (numberOfElectionCommittees + 1), 6);
        }
        System.out.println();

    }



    public static void createMainReportTable(){

        mainReportTable = new String[numberOfElectionCommittees][6];

        sortedWorkingTabWithQuotientsAndCommNameOnly();

        for(int j=0; j < numberOfElectionCommittees; j++){
            for(int i=0; i < 6; i++){
                if(i==0){
                    mainReportTable[j][i]=String.valueOf(j+1);
                } else if (i==1) {
                    mainReportTable[j][i] = listOfCommittees.get(j+1);
                } else if (i==2) {
                    mainReportTable[j][i] = String.valueOf(numberOfVotesForTheCommittees.get(listOfCommittees.get(j+1)));
                } else if (i==3) {
                    float floatValue = numberOfVotesForTheCommittees.get(listOfCommittees.get(j+1));
                    mainReportTable[j][i] = String.format(Locale.US, "%.2f",(floatValue / totalNumberOfVotes * 100));
                } else if (i==4) {
                    mainReportTable[j][i] = parliamentarySeatDistributionTable[j][1];
                } else {
                    float floatValue = Float.parseFloat(mainReportTable[j][i-1]);
                    mainReportTable[j][i] = String.format(Locale.US,"%.2f",(floatValue / numberOfMandatesToBeDistributed * 100));
                }
            }
        }

        completeMainReportTable();

    }



    public static void completeMainReportTable(){
        completeMainReportTable = new String[numberOfElectionCommittees + 1][6];

        String[] firstRowMainReportTable = {"No.", "Committee", "Amount of votes", "Percentage of votes [%]",
                "Amount of seats", "Percentage of seats [%]"};

        for(int j = 0; j < 6; j++){
            completeMainReportTable[0][j] = firstRowMainReportTable[j];
            for(int i = 0; i < numberOfElectionCommittees; i++){
                completeMainReportTable[i+1][j] = mainReportTable[i][j];
            }
        }
    }



    public static void sortedWorkingTabWithQuotientsAndCommNameOnly(){

        String[][] workingTabWithSuccessiveQuotientsAndCommName = new String[numberOfElectionCommittees * numberOfMandatesToBeDistributed][2];

        int rowToAdd = 0;
        for(int i = 0; i < numberOfElectionCommittees; i++){ //
            for(int j = 0; j < numberOfMandatesToBeDistributed; j++){
                workingTabWithSuccessiveQuotientsAndCommName[rowToAdd][0] = completeWorkingTable[j+1][i+1];
                workingTabWithSuccessiveQuotientsAndCommName[rowToAdd][1] = completeWorkingTable[0][i+1];
                rowToAdd++;
            }
        }

        float[] floatWorkingTabWithQuotientsAndCommName = new float[workingTabWithSuccessiveQuotientsAndCommName.length];

        for (int i = 0; i < workingTabWithSuccessiveQuotientsAndCommName.length; i++){
            floatWorkingTabWithQuotientsAndCommName[i] = Float.parseFloat(workingTabWithSuccessiveQuotientsAndCommName[i][0]);
        }

        quickSort(floatWorkingTabWithQuotientsAndCommName, 0, floatWorkingTabWithQuotientsAndCommName.length - 1);

        String[][] tableOfHighestQuotientsWithCommName = new String[numberOfMandatesToBeDistributed][2];
        for(int i = 0; i< numberOfMandatesToBeDistributed; i++){
            tableOfHighestQuotientsWithCommName[i][0] = String.format(Locale.US, "%.2f",(floatWorkingTabWithQuotientsAndCommName[floatWorkingTabWithQuotientsAndCommName.length - 1 - i]));

            for(int j = 0; j < floatWorkingTabWithQuotientsAndCommName.length; j++){
                if((tableOfHighestQuotientsWithCommName[i][0]).equals(workingTabWithSuccessiveQuotientsAndCommName[j][0])){
                    tableOfHighestQuotientsWithCommName[i][1] = workingTabWithSuccessiveQuotientsAndCommName[j][1];
                }
            }
        }

        parliamentarySeatDistributionTable = new String[numberOfElectionCommittees][2];
        for(int i = 0; i < numberOfElectionCommittees;i++){
            int counterOfSeatsForCommittee = 0;
            parliamentarySeatDistributionTable[i][0] = completeWorkingTable[0][i+1];

            for(int j = 0; j < numberOfMandatesToBeDistributed; j++){
                if((parliamentarySeatDistributionTable[i][0]).equals(tableOfHighestQuotientsWithCommName[j][1])){
                    counterOfSeatsForCommittee++;
                }
                parliamentarySeatDistributionTable[i][1] = String.valueOf(counterOfSeatsForCommittee);
            }
        }

    }




    public static void quickSort(float[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);

            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    public static int partition(float[] array, int low, int high) {
        float pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                float memory = array[i];
                array[i] = array[j];
                array[j] = memory;
            }
        }

        float temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return (i + 1);
    }

}
