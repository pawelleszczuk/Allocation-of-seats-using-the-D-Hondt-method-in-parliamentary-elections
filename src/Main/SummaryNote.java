package Main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static Main.Global.*;
import static Main.PrintAndExportTableToFile.exportTableToFile;

public class SummaryNote {
    public static void summaryNote(){

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("SUMMARY OF ELECTION RESULTS IN THE ELECTION DISTRICT");
        System.out.println();
        System.out.println(totalNumberOfCandidates + " candidates took part in the elections from " + numberOfElectionCommittees + " election committees.");
        System.out.println("There were " + numberOfMandatesToBeDistributed + " of mandates to be distributed between these Election Committees.");
        System.out.println(howManyElectionCommitteesReceivedASeat + " Election Committees received mandates.");
        System.out.println();
        System.out.println("The mandates are divided between Election Committees as below:");

        for(int i = 0; i < howManyElectionCommitteesReceivedASeat; i++){
            System.out.println((i+1) + ". " + tableOfCommitteesWithNumberOfReceivedSeats[i][0] + " - " + tableOfCommitteesWithNumberOfReceivedSeats[i][1]);
        }
        System.out.println();

        System.out.println("The following candidates received electoral mandates:");

        for(int i = 0; i < numberOfMandatesToBeDistributed; i++){
            System.out.print((i+1) + ". " + listOfCandidatesWhoReceivedASeat.get(i).getSurname() + " ");
            System.out.print(listOfCandidatesWhoReceivedASeat.get(i).getName() + " from ");
            System.out.println(listOfCandidatesWhoReceivedASeat.get(i).getElectionCommittee());
        }

        System.out.println();

        System.out.println("Do you want to export summary note to external file? Y / N");
        Scanner scanner = new Scanner(System.in);
        String userDecision = scanner.nextLine();

        if(userDecision.equalsIgnoreCase("Y")){
            exportSummaryNote();
        }


        System.out.println("Do you want to export table with candidates who received a mandate to external file? Y / N");
        userDecision = scanner.nextLine();

        if(userDecision.equalsIgnoreCase("Y")){
            exportTableToFile(tableCandidatesWithMandates());
        }

    }



    public static String[][] tableCandidatesWithMandates(){

        String[][] tableCandidatesWithMandates = new String[numberOfMandatesToBeDistributed+1][6];

        String[] firstRow = {"Candidate's index", "Election Committee", "Number on the Committee List", "Surname", "Name", "Number of votes"};

        for(int i = 0; i < numberOfGlobalColumns; i++){
            tableCandidatesWithMandates[0][i] = firstRow[i];
        }

        for(int i = 0; i < (numberOfMandatesToBeDistributed); i++){
                tableCandidatesWithMandates[i+1][0] = String.valueOf(listOfCandidatesWhoReceivedASeat.get(i).getCandidateIndividualIndexInElections());
                tableCandidatesWithMandates[i+1][1] = (listOfCandidatesWhoReceivedASeat.get(i).getElectionCommittee());
                tableCandidatesWithMandates[i+1][2] = String.valueOf(listOfCandidatesWhoReceivedASeat.get(i).getNumberOnTheCommitteeList());
                tableCandidatesWithMandates[i+1][3] = (listOfCandidatesWhoReceivedASeat.get(i).getSurname());
                tableCandidatesWithMandates[i+1][4] = (listOfCandidatesWhoReceivedASeat.get(i).getName());
                tableCandidatesWithMandates[i+1][5] = String.valueOf(listOfCandidatesWhoReceivedASeat.get(i).getNumberOfVotes());
        }

        return tableCandidatesWithMandates;
    }



    public static void exportSummaryNote(){
        System.out.println("Enter the name of the .txt file:");
        Scanner scanner = new Scanner(System.in);
        String nameOfTheFile = scanner.nextLine()+".txt";
        System.out.println();

        try {
            PrintWriter out = new PrintWriter(nameOfTheFile);

            out.println("SUMMARY OF ELECTION RESULTS IN THE ELECTION DISTRICT");
            out.println();
            out.println(totalNumberOfCandidates + " candidates took part in the elections from " + numberOfElectionCommittees + " election committees.");
            out.println("There were " + numberOfMandatesToBeDistributed + " of mandates to be distributed between these Election Committees.");
            out.println(howManyElectionCommitteesReceivedASeat + " Election Committees received mandates.");
            out.println();
            out.println("The mandates are divided between Election Committees as below:");

            for(int i = 0; i < howManyElectionCommitteesReceivedASeat; i++){
                out.println((i+1) + ". " + tableOfCommitteesWithNumberOfReceivedSeats[i][0] + " - " + tableOfCommitteesWithNumberOfReceivedSeats[i][1]);
            }
            out.println();

            out.println("The following candidates received electoral mandates:");

            for(int i = 0; i < numberOfMandatesToBeDistributed; i++){
                out.print((i+1) + ". " + listOfCandidatesWhoReceivedASeat.get(i).getSurname() + " ");
                out.print(listOfCandidatesWhoReceivedASeat.get(i).getName() + " from ");
                out.println(listOfCandidatesWhoReceivedASeat.get(i).getElectionCommittee());
            }
            out.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Sorry, I can't create the file!");
        }

    }

}