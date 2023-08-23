package Main;

import java.util.Collections;
import java.util.Comparator;

import static Main.Main.*;

public class WhoReceivedASeat {
    public static void whoReceivedASeat(){

        for(int i = 0; i < numberOfElectionCommittees; i++){
            if(!((completeMainReportTable[i+1][4]).equals("0"))){
                howManyElectionCommitteesReceivedASeat++;
            }
        }


        tableOfCommitteesWithAmountOfReceivedSeats = new String[howManyElectionCommitteesReceivedASeat][2];
        for (int i = 0; i < howManyElectionCommitteesReceivedASeat; i++){
            for(int j = 0; j < numberOfElectionCommittees; j++){
                if(!((completeMainReportTable[j+1][4]).equals("0"))){
                    tableOfCommitteesWithAmountOfReceivedSeats[j][0] = completeMainReportTable[j+1][1];
                    tableOfCommitteesWithAmountOfReceivedSeats[j][1] = completeMainReportTable[j+1][4];
                }
            }
        }


        for(int i = 0; i < howManyElectionCommitteesReceivedASeat; i++){
            for(int j = 0; j < totalNumberOfCandidates; j++){
                if ((tableOfCommitteesWithAmountOfReceivedSeats[i][0]).equals(listOfAllCandidates.get(j).getElectionCommittee())){
                    auxiliaryListOfCandidatesInOneCommittee.add(listOfAllCandidates.get(j)); // prawidłowo dodaje - 28 / 56 / 84 / 112 / 140
                }
            }
            Collections.sort(auxiliaryListOfCandidatesInOneCommittee, new Comparator<CandidateInstance>() {
                @Override
                public int compare(CandidateInstance p1, CandidateInstance p2){
                    return p1.getNumberOfVotes() - p2.getNumberOfVotes();
                }
            });

            for(int j = 0; j < Integer.parseInt(tableOfCommitteesWithAmountOfReceivedSeats[i][1]); j++){
                listOfCandidatesWhoReceivedASeat.add(auxiliaryListOfCandidatesInOneCommittee.get(auxiliaryListOfCandidatesInOneCommittee.size()-1-j));
            }

            auxiliaryListOfCandidatesInOneCommittee.clear(); // wyczyszczenie listy danej partii
        }





        String[][] whoReceivedAMandate = new String[numberOfMandatesToBeDistributed +1][6];

        String[] firstRowOfTableWhoReceivedAMandate = {"Candidate's individual index in elections", "Election Committee",
                "Number on the Commiittee List", "Surname", "Name", "Number of votes"};

        for(int i = 0; i < numberOfMandatesToBeDistributed +1; i++){    // wybor rzedu
            for(int j = 0; j < 6; j++){ // przechodzenie po kolummach
                if(i == 0) {
                    whoReceivedAMandate[i][j] = firstRowOfTableWhoReceivedAMandate[j];
                    //System.out.println(whoReceivedAMandate[i][j] + " TITITUTUUTTI"); // poprawne przypisanie pierwszego rzędu
                }
                if(j == 0) { // PAMIĘTAĆ ŻE LISTA DO ZMIANY I INDEKS i PO PRAWEJ STRONIE
                    //whoReceivedAMandate[i][j] = listOfCandidates.get(i).getCandidateIndividualIndexInElections() + " | ";
                } else if (j == 1) {
                    //whoReceivedAMandate[i][j] = listOfCandidates.get(i).getElectionCommittee() + " | ";
                } else if (j == 2) {
                    //whoReceivedAMandate[i][j] = listOfCandidates.get(i).getNumberOnTheCommitteeList() + " | ";
                } else if (j == 3) {
                    //whoReceivedAMandate[i][j] = listOfCandidates.get(i).getSurname() + " | ";
                } else if (j == 4) {
                    //whoReceivedAMandate[i][j] = listOfCandidates.get(i).getName() + " | ";
                } else {
                    //whoReceivedAMandate[i][j] = listOfCandidates.get(i).getNumberOfVotes() + " |TOTO ";
                }

            }
        }

        //trzeba wykorzystac completeMainReportTable - czyli nazwa ugrupowania i ilosc mandatow
        // oraz trzeba posortowac:
        //      albo wszystkie listy wg glosow na kandydatow
        //      albo tylko te listy, ktore zdobyly jakiekolwiek mandaty
        // i przydzielic odpowiednim osobom mandady

        // w tym raporcie (przynajmniej wg strony internetowej) maja byc: 1) nazwisko, 2) imie, 3) komitet
        //      ale mozna wyswyetlic tak naprawde wszystkie dane z pliku wejsciowego
    }
}
