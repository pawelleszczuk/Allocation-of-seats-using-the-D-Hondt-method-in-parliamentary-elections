package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Main.Main.*;

public class LoadingCandidatesFromFile {

        public static void loadCandidates() throws FileNotFoundException {

            System.out.println("Enter the name of the file to load candidates:");
            Scanner scanner = new Scanner(System.in);
            String nameOfTheFile = scanner.nextLine();
            System.out.println();

            File file = new File(nameOfTheFile);
            Scanner sc = new Scanner(file);


            while (sc.hasNext()){
                String line = sc.nextLine();
                totalNumberOfCandidates++;

                String table[] = line.split("\\|");

                int candidateIndividualIndexInElections = Integer.parseInt(table[0]);
                String electionCommittee = table[1];
                int numberOnTheCommitteeList = Integer.parseInt(table[2]);
                String surname = table[3];
                String name = table[4];
                int numberOfVotesForCandidate = Integer.parseInt(table[5]);

                CandidateInstance candidate = new CandidateInstance(candidateIndividualIndexInElections, electionCommittee,
                        numberOnTheCommitteeList, surname, name, numberOfVotesForCandidate);

                listOfAllCandidates.add(candidate);
            }

        }


        /// TO TYLKO POMOCNICZE - wyświetla całość dobrze, wszystkie 201 kandydatów jak w pliku
        /*public static void printListOfCandidates(){
            for(int i = 0; i < listOfCandidates.size(); i++){
                System.out.print(listOfCandidates.get(i).getCandidateIndividualIndexInElections() + " | ");
                System.out.print(listOfCandidates.get(i).getElectionCommittee() + " | ");
                System.out.print(listOfCandidates.get(i).getNumberOnTheCommitteeList() + " | ");
                System.out.print(listOfCandidates.get(i).getSurname() + " | ");
                System.out.print(listOfCandidates.get(i).getName() + " | ");
                System.out.print(listOfCandidates.get(i).getNumberOfVotes() + " |TOTO ");
                System.out.println();
            }
            System.out.println();
        }*/

}