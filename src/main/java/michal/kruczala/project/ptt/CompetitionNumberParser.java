package michal.kruczala.project.ptt;

import java.util.*;
import java.util.stream.Stream;

public class CompetitionNumberParser {
    String fraze = "nr=";
    String parallelFraze = "turnieje_pary&w=";
    public Set<String> parse(String pttWebSIteArch) {
        Set<String> first = parse(pttWebSIteArch, fraze);
        Set<String> second = parse(pttWebSIteArch, parallelFraze);
        first.addAll(second);
        return first;
    }
    private Set<String> parse(String pttWebSIteArch, String fraze) {

        Set<String> competitionNumbers = new HashSet<>();
        String[] pttWebSiteSplitted = pttWebSIteArch.split(fraze);

        for (int i = 1; i < pttWebSiteSplitted.length; i++) {
            String row = pttWebSiteSplitted[i];
            String competitionNumber = row.substring(0, 4);
            if ( competitionNumber.endsWith("\"")){
                competitionNumber = row.substring(0, 3);
            }
            competitionNumbers.add(competitionNumber);
        }
        return competitionNumbers;
    }

}