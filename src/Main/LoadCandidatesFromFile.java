package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Main.Main.listOfAllCandidates;
import static Main.Main.totalNumberOfCandidates;

public class LoadCandidatesFromFile {

        public static void loadCandidates() throws FileNotFoundException {

            System.out.println("Enter the file name with its extension to load candidates:");
            Scanner scanner = new Scanner(System.in);
            String nameOfTheFile = scanner.nextLine();
            System.out.println();

            File file = new File(nameOfTheFile);
            scanner = new Scanner(file);

            while (scanner.hasNext()){
                totalNumberOfCandidates++;

                String fileLine = scanner.nextLine();
                String auxiliaryTable[] = fileLine.split(",");

                CandidateInstance candidate = new CandidateInstance((Integer.parseInt(auxiliaryTable[0])),
                        (auxiliaryTable[1]), (Integer.parseInt(auxiliaryTable[2])), (auxiliaryTable[3]),
                        (auxiliaryTable[4]), (Integer.parseInt(auxiliaryTable[5])));

                listOfAllCandidates.add(candidate);
            }

        }

}