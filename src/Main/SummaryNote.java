package Main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static Main.Main.*;

public class SummaryNote {
    public static void summaryNote(){

        System.out.println(totalNumberOfCandidates + " candidates took part in the elections from " + numberOfElectionCommittees + " election committees.");
        System.out.println("There were " + numberOfMandatesToBeDistributed + " of mandates to be distributed between these Election Committees.");
        System.out.println(howManyElectionCommitteesReceivedASeat + " Election Committees received mandates.");
        System.out.println();
        System.out.println("The mandates are divided between Election Committees as below:");

        for(int i = 0; i < howManyElectionCommitteesReceivedASeat; i++){
            System.out.println(tableOfCommitteesWithAmountOfReceivedSeats[i][0] + " - " + tableOfCommitteesWithAmountOfReceivedSeats[i][1]);
        }
        System.out.println();

        System.out.println("The following candidates received electoral mandates:");
        for(int i = 0; i < numberOfMandatesToBeDistributed; i++){
            System.out.print(listOfCandidatesWhoReceivedASeat.get(i).getCandidateIndividualIndexInElections() + " | ");
            System.out.print(listOfCandidatesWhoReceivedASeat.get(i).getElectionCommittee() + " | ");
            System.out.print(listOfCandidatesWhoReceivedASeat.get(i).getNumberOnTheCommitteeList() + " | ");
            System.out.print(listOfCandidatesWhoReceivedASeat.get(i).getSurname() + " | ");
            System.out.print(listOfCandidatesWhoReceivedASeat.get(i).getName() + " | ");
            System.out.println(listOfCandidatesWhoReceivedASeat.get(i).getNumberOfVotes());
        }
        System.out.println();

        System.out.println("Do you want to export summary note to external file? Y / N");
        Scanner scanner = new Scanner(System.in);
        String userDecision = scanner.nextLine();

        if(userDecision.equalsIgnoreCase("Y")){
            exportSummaryNote();
        }
    }

    public static void exportSummaryNote(){
        System.out.println("Enter the name of the .txt file:");
        Scanner scanner = new Scanner(System.in);
        String nameOfTheFile = scanner.nextLine()+".txt";

        try {
            PrintWriter out = new PrintWriter(nameOfTheFile);

            out.println(totalNumberOfCandidates + " candidates took part in the elections from " + numberOfElectionCommittees + " election committees.");
            out.println("There were " + numberOfMandatesToBeDistributed + " of mandates to be distributed between these Election Committees.");
            out.println(howManyElectionCommitteesReceivedASeat + " Election Committees received mandates.");
            out.println();
            out.println("The mandates are divided between Election Committees as below:");

            for(int i = 0; i < howManyElectionCommitteesReceivedASeat; i++){
                out.println(tableOfCommitteesWithAmountOfReceivedSeats[i][0] + " - " + tableOfCommitteesWithAmountOfReceivedSeats[i][1]);
            }
            out.println();

            out.println("The following candidates received electoral mandates:");
            for(int i = 0; i < numberOfMandatesToBeDistributed; i++){
                out.print(listOfCandidatesWhoReceivedASeat.get(i).getCandidateIndividualIndexInElections() + " | ");
                out.print(listOfCandidatesWhoReceivedASeat.get(i).getElectionCommittee() + " | ");
                out.print(listOfCandidatesWhoReceivedASeat.get(i).getNumberOnTheCommitteeList() + " | ");
                out.print(listOfCandidatesWhoReceivedASeat.get(i).getSurname() + " | ");
                out.print(listOfCandidatesWhoReceivedASeat.get(i).getName() + " | ");
                out.println(listOfCandidatesWhoReceivedASeat.get(i).getNumberOfVotes());
            }
            out.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Sorry, I can't create the file!");
        }

    }

}