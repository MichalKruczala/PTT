package michal.kruczala.project.ptt;

import michal.kruczala.project.ptt.readers.WebReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParserPTT {
    static final Logger LOGGER = LoggerFactory.getLogger(ParserPTT.class);
    static final WebReader webReader = new WebReader();
    static final CompetitionNumberParser competitionNumberParser = new CompetitionNumberParser();
    private static final ArchivalCompetitionParser lookForArchivalYearComps = new ArchivalCompetitionParser();
    private static final CompetitionSitesParser competitionSitesParser = new CompetitionSitesParser();
    private static final String PTTWebSite = "https://baza.taniec.pl/?v=turnieje&p=arch&sz_rok=";
    private static final Date nowDate = new Date();

    public static <nowDate> void main(String[] args) throws IOException, ParseException {


       // String pageContent = webReader.downloadWebPage(PTTWebSite);
       // LOGGER.debug(pageContent);

      //  Set<String> competitionNumbers = competitionNumberParser.parse(pageContent);
       // LOGGER.debug(String.valueOf(competitionNumbers));
      //  int year = lookForArchivalYearComps.yearChosenByUser();
      //  String chosenArchivalPttWebSite = webReader.downloadWebPage(PTTWebSite + year);
       // LOGGER.debug(chosenArchivalPttWebSite);

       // List<String> listOfAllCompetitionsLinks2022 = competitionSitesParser.getListOfCompetitionSites(pageContent, year);
      //  LOGGER.debug(String.valueOf(listOfAllCompetitionsLinks2022));

      //  List<String> sitesContent = webReader.downloadWebPages(listOfAllCompetitionsLinks2022);
       // LOGGER.debug(String.valueOf(sitesContent));

        List<String> listOFContents = getChosenYearsCompetitionSitesContentList();
        LOGGER.debug(String.valueOf(listOFContents));

    }

    public static List<String> getChosenYearsCompetitionSitesContentList() throws ParseException, IOException {

        ArchivalCompetitionParser archivalCompetitionParser = new ArchivalCompetitionParser();

        int i = archivalCompetitionParser.yearChosenByUser();
        List<String> listOfChosenPeriodContent = new ArrayList<>();

        while (i <= nowDate.getYear() + 1900) {
            String url = PTTWebSite + i;
            String yearPageContent = webReader.downloadWebPage(url);
            List<String> listOfAllCompetitionsLinksOfYear = competitionSitesParser.getListOfCompetitionSites(yearPageContent, i);
            List<String> ListOfOneYearCompetitionsContent = webReader.downloadWebPages(listOfAllCompetitionsLinksOfYear);
            Stream<String> st = ListOfOneYearCompetitionsContent.stream();
            st.forEach(listOfChosenPeriodContent::add);
            i++;
        }
        return listOfChosenPeriodContent;
    }
}