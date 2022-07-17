package michal.kruczala.project.ptt;

import java.util.*;

public class CompetitionNumberParser {


    public Set<String> parse(String pttWebSIteArch) {
        String fraze = "nr=";
        Set<String> competitionNumbers =  new HashSet<>();
        String[] pttWebSiteSplitted = pttWebSIteArch.split(fraze);

        for (int i = 1; i < pttWebSiteSplitted.length; i++) {
            String row = pttWebSiteSplitted[i];
            String competitionNumber = row.substring(0, 4);
            competitionNumbers.add(competitionNumber);
        }

        return competitionNumbers;
    }

}