package michal.kruczala.project.ptt;

import java.util.ArrayList;
import java.util.List;

import static michal.kruczala.project.ptt.ParserPTT.extractCompNumbersFromPTTWebsite;

public class AllCompetitionSitesThisYearParser {
    static List getListOfAllCompetitionSitesThisYear(String result) {

        List<String> listOfAllCompetitionSitesThisYear = new ArrayList<>();
        String url = "turniej.php?nr=";
        System.out.println("----------List of all Competitions this Year-----------");

        for (Object competitionNumber: extractCompNumbersFromPTTWebsite(result)
        ) {
            StringBuilder sb = new StringBuilder(url);
            listOfAllCompetitionSitesThisYear.add(sb.append(competitionNumber).toString());
        }
        return listOfAllCompetitionSitesThisYear;
    }
}
