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
            Scanner skaner = new Scanner(file);


            while (skaner.hasNext()){
                String line = skaner.nextLine();
                numberOfCandidates++;

                String table[] = line.split("\\|");

                int candidateIndividualIndexInElections = Integer.parseInt(table[0]);
                String electionCommittee = table[1];
                int numberOnTheCommitteeList = Integer.parseInt(table[2]);
                String surname = table[3];
                String name = table[4];
                int numberOfVotesForCandidate = Integer.parseInt(table[5]);

                CandidateInstance candidate = new CandidateInstance(candidateIndividualIndexInElections, electionCommittee,
                        numberOnTheCommitteeList, surname, name, numberOfVotesForCandidate);

            }


        }


}