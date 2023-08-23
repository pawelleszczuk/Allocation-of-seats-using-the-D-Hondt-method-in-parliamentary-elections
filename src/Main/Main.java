package Main;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        LoadCandidates.loadCandidatesFromFile();

        AmountOfMandatesToDivide.amountOfMandatesInRegion();

        WorkingTable.proportionalityTable();

        MandateAllocationReport.mandateAllocationToCommitteesReport();

        WhoReceivedASeat.whoReceivedASeat();

        SummaryNote.summaryNote();

    }

}