package Main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int totalNumberOfCandidates = 0;
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
    static ArrayList<CandidateInstance> listOfAllCandidates = new ArrayList<CandidateInstance>();
    static ArrayList<CandidateInstance> listOfCandidatesWhoReceivedASeat = new ArrayList<CandidateInstance>();
    static ArrayList<CandidateInstance> auxiliaryListOfCandidatesInOneCommittee = new ArrayList<CandidateInstance>();
    static String[][] tableOfCommitteesWithAmountOfReceivedSeats;
    static int howManyElectionCommitteesReceivedASeat = 0;

    public static void main(String[] args) throws FileNotFoundException {
        LoadingCandidatesFromFile.loadCandidates();
        AmountOfSeatsToDivide.amountOfSeatsInRegion();

        WorkingTable.workingTable();

        SeatAllocationReport.allocationReport();

        WhoReceivedASeat.whoReceivedASeat();

        //LoadingCandidatesFromFile.printListOfCandidates(); // pomocnicze wyswietlanie arraylisty z obiektami kandydatami
        SummaryNote.summaryNote(); // ostateczny raport - musi być
    }

}