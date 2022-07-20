package michal.kruczala.project.ptt;

import java.util.ArrayList;
import java.util.List;

import static michal.kruczala.project.ptt.ParserPTT.competitionNumberParser;


public class CompetitionSitesParser {
    public List<String> getListOfCompetitionSites(String pttWebSite) {

        List<String> listOfAllCompetitionSitesThisYear = new ArrayList<>();
        String fraze = "https://baza.taniec.pl/turniej.php?nr=";

        for (Object competitionNumber : competitionNumberParser.parse(pttWebSite)
        ) {
            StringBuilder sb = new StringBuilder(fraze);
            listOfAllCompetitionSitesThisYear.add(sb.append(competitionNumber).toString());
        }
        return listOfAllCompetitionSitesThisYear;
    }
}
