package Main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static String[][] parliamentarySeatDistributionTable;
    static String[][] mainReportTable;
    static String[][] completeMainReportTable;
    static ArrayList<CandidateInstance> listOfCandidatesWhoReceivedASeat = new ArrayList<CandidateInstance>();
    static ArrayList<CandidateInstance> auxiliaryListOfCandidatesInOneCommittee = new ArrayList<CandidateInstance>();
    static String[][] tableOfCommitteesWithAmountOfReceivedSeats;
    static int howManyElectionCommitteesReceivedASeat;
    static int totalNumberOfCandidates;
    static ArrayList<CandidateInstance> listOfAllCandidates = new ArrayList<CandidateInstance>();
    static int numberOfElectionCommittees;
    static int numberOfMandatesToBeDistributed;
    static Map<Integer, String> listOfCommittees = new HashMap<>();
    static Map<String, Integer> numberOfVotes = new HashMap<>();
    static String[][] completeWorkingTable;
    static int totalNumberOfVotes;


    public static void main(String[] args) throws FileNotFoundException {

        LoadCandidatesFromFile.loadCandidates();

        AmountOfMandatesToDivide.amountOfMandatesInRegion();

        WorkingTable.proportionalityTable();

        MandateAllocationReport.allocationReport();

        WhoReceivedASeat.whoReceivedASeat();

        SummaryNote.summaryNote();
    }

}