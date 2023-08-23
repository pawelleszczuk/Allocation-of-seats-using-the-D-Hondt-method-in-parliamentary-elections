package Main;

import java.util.Scanner;
import static Main.Main.numberOfElectionCommittees;

public class StaticAmountOfElectionCommittee {
    public static int amountOfElectionCommittee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many election committees participated in the elections?");
        numberOfElectionCommittees = scanner.nextInt();
        return numberOfElectionCommittees;
    }
}
