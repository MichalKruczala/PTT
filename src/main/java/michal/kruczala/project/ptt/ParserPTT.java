package michal.kruczala.project.ptt;

import michal.kruczala.project.ptt.readers.WebReader;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ParserPTT {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParserPTT.class);
    private static final WebReader webReader = new WebReader();
    static final CompetitionNumberParser competitionNumberParser = new CompetitionNumberParser();
    private static final ArchivalCompetitionParser lookForArchivalYearComps = new ArchivalCompetitionParser();
    private static final CompetitionSitesParser competitionSitesParser = new CompetitionSitesParser();
    private static final String PTTWebSite = "https://baza.taniec.pl/?v=turnieje&p=arch";

    public static void main(String[] args) throws IOException {

        String pageContent = webReader.downloadWebPage(PTTWebSite);
        LOGGER.debug(pageContent);

        Set<String> competitionNumbers = competitionNumberParser.parse(pageContent);
        LOGGER.debug(String.valueOf(competitionNumbers));


        String chosenArchivalPttWebSite = webReader.downloadWebPage(PTTWebSite + lookForArchivalYearComps.yearChosenByUser());
        LOGGER.debug(chosenArchivalPttWebSite);


        List<String> ListOfAllCompetitionsLinks2022 = competitionSitesParser.getListOfCompetitionSites(pageContent);
        LOGGER.debug(String.valueOf(ListOfAllCompetitionsLinks2022));


        contentFromAllCompetitionSites2022(ListOfAllCompetitionsLinks2022);

    }


    private static void contentFromAllCompetitionSites2022(List<String> ListOfAllCompetitionsLinks2022) {
        ListOfAllCompetitionsLinks2022.forEach(link -> {
            try {
                webReader.downloadWebPage(link);
                LOGGER.debug(webReader.downloadWebPage(link));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}



