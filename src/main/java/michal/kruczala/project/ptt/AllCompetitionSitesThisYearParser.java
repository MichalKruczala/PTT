package michal.kruczala.project.ptt;

import java.util.ArrayList;
import java.util.List;

import static michal.kruczala.project.ptt.ParserPTT.competitionNumberParser;


public class AllCompetitionSitesThisYearParser {
    static List<String> getListOfAllCompetitionSitesThisYear(String pttWebSite) {

        List<String> listOfAllCompetitionSitesThisYear = new ArrayList<>();
        String fraze = "turniej.php?nr=";

        for (Object competitionNumber : competitionNumberParser.parse(pttWebSite)
        ) {
            StringBuilder sb = new StringBuilder(fraze);
            listOfAllCompetitionSitesThisYear.add(sb.append(competitionNumber).toString());
        }
        return listOfAllCompetitionSitesThisYear;
    }
}
