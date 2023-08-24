package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static Main.Global.*;

public class WhoReceivedAMandate {

    public static void whoReceivedASeat(){

        howManyElectionCommitteesReceivedASeat();

        createTableOfCommitteesWithNumberOfReceivedSeats();

        selectionOfCandidatesWhoWonAMandate();

    }


    public static void howManyElectionCommitteesReceivedASeat(){
        for(int i = 0; i < numberOfElectionCommittees; i++){
            if(!((completeMainReportTable[i+1][4]).equals("0"))){
                howManyElectionCommitteesReceivedASeat++;
            }
        }
    }


    public static void createTableOfCommitteesWithNumberOfReceivedSeats(){
        tableOfCommitteesWithNumberOfReceivedSeats = new String[howManyElectionCommitteesReceivedASeat][2];
        for (int i = 0; i < howManyElectionCommitteesReceivedASeat; i++){
            for(int j = 0; j < numberOfElectionCommittees; j++){
                if(!((completeMainReportTable[j+1][4]).equals("0"))){
                    tableOfCommitteesWithNumberOfReceivedSeats[j][0] = completeMainReportTable[j+1][1];
                    tableOfCommitteesWithNumberOfReceivedSeats[j][1] = completeMainReportTable[j+1][4];
                }
            }
        }
    }




    public static void selectionOfCandidatesWhoWonAMandate(){

        for(int i = 0; i < howManyElectionCommitteesReceivedASeat; i++){

            selectionOfCandidatesWhoWonAMandateInASingleCommittee(i, sortTemporaryListByNumberOfVotes(i, createTemporaryListOfCandidatesFromSingleCommittee(i)));

        }
    }



    public static ArrayList<CandidateInstance> createTemporaryListOfCandidatesFromSingleCommittee(int i){

        ArrayList<CandidateInstance> temporaryListOfCandidatesFromSingleCommittee = new ArrayList<CandidateInstance>();

        for(int j = 0; j < totalNumberOfCandidates; j++){
            if ((tableOfCommitteesWithNumberOfReceivedSeats[i][0]).equals(listOfAllCandidates.get(j).getElectionCommittee())){
                temporaryListOfCandidatesFromSingleCommittee.add(listOfAllCandidates.get(j));
            }
        }

        return temporaryListOfCandidatesFromSingleCommittee;
    }



    public static ArrayList<CandidateInstance> sortTemporaryListByNumberOfVotes(int i, ArrayList<CandidateInstance> temporaryListOfCandidatesFromSingleCommittee){

        Collections.sort(temporaryListOfCandidatesFromSingleCommittee, new Comparator<CandidateInstance>() {
            @Override
            public int compare(CandidateInstance p1, CandidateInstance p2){
                return p1.getNumberOfVotes() - p2.getNumberOfVotes();
            }
        });

        return temporaryListOfCandidatesFromSingleCommittee;
    }



    public static void selectionOfCandidatesWhoWonAMandateInASingleCommittee(int i, ArrayList<CandidateInstance> temporaryListOfCandidatesFromSingleCommittee){

        for(int j = 0; j < Integer.parseInt(tableOfCommitteesWithNumberOfReceivedSeats[i][1]); j++){
            listOfCandidatesWhoReceivedASeat.add(temporaryListOfCandidatesFromSingleCommittee.get(temporaryListOfCandidatesFromSingleCommittee.size()-1-j));
        }

        temporaryListOfCandidatesFromSingleCommittee.clear();

    }

}