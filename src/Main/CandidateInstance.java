package Main;

import static Main.Main.*;

public class CandidateInstance {

    final int candidateIndividualIndexInElections;
    final String electionCommittee;
    final int numberOnTheCommitteeList;
    final String surname;
    final String name;
    final int numberOfVotes;

    public CandidateInstance(int candidateIndividualIndexInElections, String electionCommittee,
                             int numberOnTheCommitteeList, String surname, String name, int numberOfVotes) {

        this.candidateIndividualIndexInElections = candidateIndividualIndexInElections;
        this.electionCommittee = electionCommittee;
        this.numberOnTheCommitteeList = numberOnTheCommitteeList;
        this.surname = surname;
        this.name = name;
        this.numberOfVotes = numberOfVotes;

        if(!listOfCommittees.containsValue(electionCommittee)){
            listOfCommittees.put(indexToPut,electionCommittee);
            indexToPut++;
            Main.numberOfVotes.put(electionCommittee,0);
        }

        Main.numberOfVotes.put(electionCommittee,Main.numberOfVotes.get(electionCommittee)+numberOfVotes);
        totalNumberOfVotes+=numberOfVotes;
    }

    public static void printCommittees(){
        for(int i = 1; i < indexToPut; i++){
            System.out.println(i + " | " + listOfCommittees.get(i));
        }
        System.out.println();
    }

    public static void printNumberOfVotesForEveryCommittee(){
        for(int i = 1; i < indexToPut; i++){
            System.out.println(listOfCommittees.get(i) + " | " + Main.numberOfVotes.get(listOfCommittees.get(i)));
        }
        System.out.println();
    }

}