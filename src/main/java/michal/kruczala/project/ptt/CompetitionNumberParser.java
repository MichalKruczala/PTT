package michal.kruczala.project.ptt;

import java.util.*;

public class CompetitionNumberParser {

    private int actualValue;
    private static final String url = "turniej.php?nr=";
    private List<String> competitionNumbers = new ArrayList<>();
    private int lastValue;
    private String firstCompetitionNumber;

    public List lookForCompetitionNumbers(String result) {

        actualValue = result.indexOf(url);
        lastValue = result.lastIndexOf(url);
        firstCompetitionNumber = result.substring(actualValue + 15, actualValue + 19);
        competitionNumbers.add(firstCompetitionNumber);

        AddingCompetitionNumbersToList(result, lastValue);
        cleanDuplicatesOnList();
        return competitionNumbers;
    }

    private void AddingCompetitionNumbersToList(String result, int lastValue) {
        while (actualValue <= lastValue) {

            int nextValue = result.indexOf(url, actualValue);
            actualValue = nextValue + 20;
            String nextCompetitionNumber = result.substring(nextValue + 15, nextValue + 19);
            competitionNumbers.add(nextCompetitionNumber);
        }
    }

    private void cleanDuplicatesOnList() {
        Object[] st = competitionNumbers.toArray();
        for (Object s : st) {
            if (competitionNumbers.indexOf(s) != competitionNumbers.lastIndexOf(s)) {
                competitionNumbers.remove(competitionNumbers.lastIndexOf(s));
            }
        }
    }
}