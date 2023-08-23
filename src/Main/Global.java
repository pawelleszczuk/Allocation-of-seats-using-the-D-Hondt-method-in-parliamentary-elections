package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Global {
    static int totalNumberOfCandidates;
    static ArrayList<CandidateInstance> listOfAllCandidates = new ArrayList<CandidateInstance>();
    static int numberOfElectionCommittees;
    static int numberOfMandatesToBeDistributed;
    static Map<Integer, String> listOfCommittees = new HashMap<>();
    static Map<String, Integer> numberOfVotesForTheCommittees = new HashMap<>();
    static String[][] completeWorkingTable;
    static int totalNumberOfVotes;
    static String[][] completeMainReportTable;
    static ArrayList<CandidateInstance> listOfCandidatesWhoReceivedASeat = new ArrayList<CandidateInstance>();
    static String[][] tableOfCommitteesWithNumberOfReceivedSeats;
    static int howManyElectionCommitteesReceivedASeat;
}
