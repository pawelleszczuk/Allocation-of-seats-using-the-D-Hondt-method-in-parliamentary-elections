package Main;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int numberOfCandidates = 0;
    static int numberOfElectionCommittees;
    static int numberOfSeatsToBeDistributed;
    static Map<Integer, String> listOfCommittees = new HashMap<>();
    static int indexToPut = 1;
    static Map<String, Integer> numberOfVotes = new HashMap<>();
    static String[][] completeWorkingTable;
    static int totalNumberOfVotes;
    static String[][] parliamentarySeatDistributionTable;
    static String[][] mainReportTable;
    static String[][] completeMainReportTable;

    public static void main(String[] args) throws FileNotFoundException {
        LoadingCandidatesFromFile.loadCandidates();
        AmountOfSeatsToDivide.amountOfSeatsInRegion();

        WorkingTable.workingTable();

        SeatAllocationReport.allocationReport();

        //CandidateInstance.printCommittees(); // pomocnicze wyświetlanie - działa, wyświetla wszystkie nr i nazwy komitetów
        //CandidateInstance.printNumberOfVotesForEveryCommittee(); // pomocnicze wyświetlanie - działa, wyświetla wszystkie nazwy komitetów i ilość głosów na nie
    }

}