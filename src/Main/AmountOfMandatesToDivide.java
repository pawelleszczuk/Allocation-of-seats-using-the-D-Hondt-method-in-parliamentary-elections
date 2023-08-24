package Main;

import java.util.Scanner;

import static Main.Global.numberOfMandatesToBeDistributed;

public class AmountOfMandatesToDivide {

    public static void amountOfMandatesInRegion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many mandates are to be allocated in this region?");
        numberOfMandatesToBeDistributed = scanner.nextInt();
    }

}