package Main;

import java.util.Scanner;
import static Main.Main.numberOfSeatsToBeDistributed;

public class AmountOfSeatsToDivide {
    public static void amountOfSeatsInRegion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many seats were in this region to be divided?");
        numberOfSeatsToBeDistributed = scanner.nextInt();
    }
}