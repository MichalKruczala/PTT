package michal.kruczala.project.ptt;

import java.util.ArrayList;
import java.util.List;

import static michal.kruczala.project.ptt.ParserPTT.competitionNumberParser;


public class CompetitionSitesParser {

    public List<String> getListOfCompetitionSites(String pttWebSite,int year) {

        List<String> listOfAllCompetitionSitesThisYear = new ArrayList<>();
        String link = getCompetitionCorrectLink(year);


        for (String competitionNumber : competitionNumberParser.parse(pttWebSite)
        ) {
            StringBuilder sb = new StringBuilder(link);
            listOfAllCompetitionSitesThisYear.add(sb.append(competitionNumber).toString());
        }
        return listOfAllCompetitionSitesThisYear;
    }
    private String getCompetitionCorrectLink(int rok) {
        if(rok < 2014){
            return "https://baza.taniec.pl/?v=turnieje_pary&w=";
        }
        return "https://baza.taniec.pl/turniej.php?nr=";

    }
}

