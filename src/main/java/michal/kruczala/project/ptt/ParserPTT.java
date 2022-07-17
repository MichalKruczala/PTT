package michal.kruczala.project.ptt;

import michal.kruczala.project.ptt.readers.WebReader;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

import static michal.kruczala.project.ptt.AllCompetitionSitesThisYearParser.getListOfAllCompetitionSitesThisYear;

@Slf4j
public class ParserPTT {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParserPTT.class);
    private static final WebReader webReader = new WebReader();
    private static final CompetitionNumberParser competitionNumberParser = new CompetitionNumberParser();
    private static final ArchivalCompetitionParser lookForArchivalYearComps = new ArchivalCompetitionParser();
    private static final String PTTWebSite = "https://baza.taniec.pl/?v=turnieje&p=arch";

    public static void main(String[] args) throws IOException {

        String pageContent = webReader.downloadWebPage(PTTWebSite);
        LOGGER.debug(pageContent);

        List<String> competitionNumbers = competitionNumberParser.parse(pageContent);
        LOGGER.debug(String.valueOf(competitionNumbers));


        String archivalPttWebSite = webReader.downloadWebPage(PTTWebSite + lookForArchivalYearComps.lookForArchivalYearCompsENDURL());
        LOGGER.debug(archivalPttWebSite);


        List<String> ListOfAllCompetitionSitesThisYear = getListOfAllCompetitionSitesThisYear(pageContent);
        LOGGER.debug(String.valueOf(ListOfAllCompetitionSitesThisYear));

    }


}




