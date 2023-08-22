package Main;

import static Main.Main.*;

public class CandidateInstance {

    final int candidateIndividualIndexInElections;
    final String electionCommittee;
    final int numberOnTheCommitteeList;
    final String surname;
    final String name;
    final int numberOfVotes;

    public int getCandidateIndividualIndexInElections() {
        return candidateIndividualIndexInElections;
    }

    public String getElectionCommittee() {
        return electionCommittee;
    }

    public int getNumberOnTheCommitteeList() {
        return numberOnTheCommitteeList;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }



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

}