package michal.kruczala.project.ptt;

import java.util.*;
import java.util.stream.Stream;

public class CompetitionNumberParser {

    public Set<String> parse(String pttWebSIteArch) {

        String fraze = "nr=";
        String parallelFraze = "turnieje_pary&w=";

        Set<String> competitionNumbers = new HashSet<>();
        String[] pttWebSiteSplitted = pttWebSIteArch.split(fraze);
        Stream<String> st =

        for (int i = 1; i < pttWebSiteSplitted.length ; i++) {

            String row = pttWebSiteSplitted[i];
            String competitionNumber = row.substring(0, 4);
            competitionNumbers.add(competitionNumber);

        }
        return competitionNumbers;
    }

}