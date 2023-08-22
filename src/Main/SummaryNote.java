package Main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static Main.Main.*;
import static Main.Main.howManyElectionCommitteesReceivedASeat;

public class SummaryNote {
    public static void summaryNote(){

        System.out.println(totalNumberOfCandidates + " candidates took part in the elections from " + numberOfElectionCommittees + " election committees");
        System.out.println("There were " + numberOfSeatsToBeDistributed + " of seats to be distributed between these Election Committees");
        System.out.println(howManyElectionCommitteesReceivedASeat + " Election Committees received mandates");
        System.out.println();
        System.out.println("The seats are divided between Election Committees as below:");

        for(int i = 0; i < howManyElectionCommitteesReceivedASeat; i++){
            System.out.println(tableOfCommitteesWithAmountOfReceivedSeats[i][0] + " - " + tableOfCommitteesWithAmountOfReceivedSeats[i][1]);
        }
        System.out.println();

        System.out.println("The following candidates won parliamentary seats:");
        for(int i = 0; i < numberOfSeatsToBeDistributed; i++){
            System.out.print(listOfCandidatesWhoReceivedASeat.get(i).getCandidateIndividualIndexInElections() + " | ");
            System.out.print(listOfCandidatesWhoReceivedASeat.get(i).getElectionCommittee() + " | ");
            System.out.print(listOfCandidatesWhoReceivedASeat.get(i).getNumberOnTheCommitteeList() + " | ");
            System.out.print(listOfCandidatesWhoReceivedASeat.get(i).getSurname() + " | ");
            System.out.print(listOfCandidatesWhoReceivedASeat.get(i).getName() + " | ");
            System.out.println(listOfCandidatesWhoReceivedASeat.get(i).getNumberOfVotes() + " | ");
        }
        System.out.println();

        System.out.println("Do you want to export summary note to external file? Y / N");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();

        if(decision.equalsIgnoreCase("Y")){
            exportSummaryNote();
        }
    }

    public static void exportSummaryNote(){
        System.out.println("Enter the name of the .txt file:");
        Scanner scanner = new Scanner(System.in);
        String nameOfTheFileWihtoutExtension = scanner.nextLine();
        String nameOfTheFile = nameOfTheFileWihtoutExtension+".txt";


        try {
            PrintWriter out = new PrintWriter(nameOfTheFile);




            //eksport tabeli z innej klasy:
            /*for(int i = 0; i < numberOfSeatsToBeDistributed+1; i++) {
                for (int j = 0; j < numberOfElectionCommittees + 1; j++) {
                    out.print(completeWorkingTable[i][j] + "|");
                }
                out.println();
            }*/

            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry, I can't create the file!");
        }
    }

}