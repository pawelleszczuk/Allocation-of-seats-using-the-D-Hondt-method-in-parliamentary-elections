package Main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import static Main.Main.*;

public class MandateAllocationReport {
    public static void allocationReport(){

        mainReportTable();
        completeMainReportTable();

        System.out.println("Do you want to see the Main Report Table? Y / N");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();

        if(decision.equalsIgnoreCase("Y")){
            printMainReportTable();
        }

        System.out.println("Do you want to export the Main Report Table to external file? Y / N"); // do jakiego pliku, jaka ścieżka?
        decision = scanner.nextLine();
        if(decision.equalsIgnoreCase("Y")){
            exportFile();
        }
        System.out.println();

    }





    public static void mainReportTable(){

        mainReportTable = new String[numberOfElectionCommittees][6];

        sortedWorkingTable_NumVotes_and_CommName();

        for(int i=0; i < 6; i++){
            for(int j=0; j < numberOfElectionCommittees; j++){
                if(i==0){
                    mainReportTable[j][i]=String.valueOf(j+1);
                } else if (i==1) {
                    mainReportTable[j][i] = listOfCommittees.get(j+1);
                } else if (i==2) {
                    mainReportTable[j][i] = String.valueOf(numberOfVotes.get(listOfCommittees.get(j+1)));
                } else if (i==3) {
                    float floatValue = numberOfVotes.get(listOfCommittees.get(j+1));
                    mainReportTable[j][i] = String.format("%.2f",(floatValue / totalNumberOfVotes * 100));
                } else if (i==4) {
                    mainReportTable[j][i] = parliamentarySeatDistributionTable[j][1];
                } else {
                    float floatValue = Float.parseFloat(mainReportTable[j][i-1]);
                    mainReportTable[j][i] = String.format(Locale.US,"%.2f",(floatValue / numberOfMandatesToBeDistributed * 100));
                }
            }
        }
    }



    public static void completeMainReportTable(){
        completeMainReportTable = new String[numberOfElectionCommittees + 1][6];

        String[] firstRowMainReportTable = {"No.", "Committee", "Amount of votes", "Percentage of votes [%]",
                "Amount of seats", "Percentage of seats [%]"};

        for(int i = 0; i < 6; i++){
            completeMainReportTable[0][i] = firstRowMainReportTable[i];
            for(int j = 0; j < numberOfElectionCommittees; j++){
                completeMainReportTable[j+1][i] = mainReportTable[j][i];
            }
        }
    }



    public static void printMainReportTable() {
        System.out.println("The distribution of parliamentary seats is as follows:");
        System.out.println();

        for(int i = 0; i < numberOfElectionCommittees + 1; i++){
            for(int j = 0; j < 6; j++){
                System.out.print(completeMainReportTable[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }




    public static void exportFile(){
        System.out.println("Enter the name of the file with extension:");
        Scanner sc = new Scanner(System.in);
        String nameOfTheFile = sc.nextLine();

        try {
            PrintWriter out = new PrintWriter(nameOfTheFile);

            for(int i = 0; i < numberOfElectionCommittees + 1; i++){
                for(int j = 0; j < 6; j++){
                    out.print(completeMainReportTable[i][j] + "|");
                }
                out.println();
            }

            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry, I can't create the file!");
        }
    }






    public static void sortedWorkingTable_NumVotes_and_CommName(){
        String[][] partialArray = new String[numberOfElectionCommittees* numberOfMandatesToBeDistributed][2];

        int rowToAdd = 0;
        for(int i = 0; i < numberOfElectionCommittees; i++){ //
            for(int j = 0; j < numberOfMandatesToBeDistributed; j++){
                partialArray[rowToAdd][0] = completeWorkingTable[j+1][i+1];
                partialArray[rowToAdd][1] = completeWorkingTable[0][i+1];
                rowToAdd++;
            }
        }

        float[] partialArrayFloats = new float[partialArray.length];

        for (int i = 0; i < partialArray.length; i++){
            partialArrayFloats[i] = Float.parseFloat(partialArray[i][0]);
        }

        quickSort(partialArrayFloats, 0, partialArrayFloats.length - 1);

        String[][] tableOfHighestPartialNumbersWithCommitteeName = new String[numberOfMandatesToBeDistributed][2];
        for(int i = 0; i< numberOfMandatesToBeDistributed; i++){
            tableOfHighestPartialNumbersWithCommitteeName[i][0] = String.format(Locale.US, "%.2f",(partialArrayFloats[partialArrayFloats.length - 1 - i]));

            for(int j = 0; j < partialArrayFloats.length; j++){
                if((tableOfHighestPartialNumbersWithCommitteeName[i][0]).equals(partialArray[j][0])){
                    tableOfHighestPartialNumbersWithCommitteeName[i][1] = partialArray[j][1];
                }
            }
        }

        parliamentarySeatDistributionTable = new String[numberOfElectionCommittees][2];
        for(int i = 0; i < numberOfElectionCommittees;i++){
            int counterOfSeatsForCommittee = 0;
            parliamentarySeatDistributionTable[i][0] = completeWorkingTable[0][i+1];

            for(int j = 0; j < numberOfMandatesToBeDistributed; j++){
                if((parliamentarySeatDistributionTable[i][0]).equals(tableOfHighestPartialNumbersWithCommitteeName[j][1])){
                    counterOfSeatsForCommittee++;
                }
                parliamentarySeatDistributionTable[i][1] = String.valueOf(counterOfSeatsForCommittee);
            }
        }


    }



    // SORTOWANIE SZYBKIE TABLICY SAMYCH FLOATÓW ///////////////////////////////////////////////////////////////////////

    public static void quickSort(float[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(float[] arr, int low, int high) {
        float pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                float temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        float temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printArray(float[] arr) {
        for (float num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
