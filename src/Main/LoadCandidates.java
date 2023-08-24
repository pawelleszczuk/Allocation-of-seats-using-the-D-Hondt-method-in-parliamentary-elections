package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Main.Global.listOfAllCandidates;
import static Main.Global.totalNumberOfCandidates;

public class LoadCandidates {

        public static void loadCandidatesFromFile() throws FileNotFoundException {

            System.out.println("Enter the file name with its extension to load candidates:");
            Scanner scanner = new Scanner(System.in);

            String nameOfTheFile = scanner.nextLine();
            File file = new File(nameOfTheFile);

            while(!file.exists()){
                System.out.println("File not found! Please enter a valid file name:");
                nameOfTheFile = scanner.nextLine();
                file = new File(nameOfTheFile);
            }
            System.out.println("File loaded successfully!");
            System.out.println();

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