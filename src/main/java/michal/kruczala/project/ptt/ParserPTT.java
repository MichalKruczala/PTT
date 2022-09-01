package michal.kruczala.project.ptt;

import michal.kruczala.project.ptt.readers.WebReader;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Stream;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParserPTT {
    private static final Logger logger = LoggerFactory.getLogger(ParserPTT.class);
    private static final WebReader webReader = new WebReader();
    private static final CompetitionSitesParser competitionSitesParser = new CompetitionSitesParser();
    private static final String pTTWebSite = "https://baza.taniec.pl/?v=turnieje&p=arch&sz_rok=";


    public static void main(String[] args) throws IOException, ParseException {
        List<String> listOFContents = getChosenYearsCompetitionSitesContentList();
        //  logger.debug(String.valueOf(listOFContents));

        List<String> chosenYearsCompetitionNamesList = getChosenYearsCompetitionNames(listOFContents);
        logger.debug(String.valueOf(chosenYearsCompetitionNamesList));
    }


    public static List<String> getChosenYearsCompetitionSitesContentList() throws ParseException, IOException {

        DataFromUser dataFromUser = new DataFromUser();
        LocalDate nowDate = LocalDate.now();
        int chosenYear = dataFromUser.takeYear();
        List<String> listOfChosenPeriodContent = new ArrayList<>();

        while (chosenYear <= nowDate.getYear()) {
            String archivalCompetitionsWebSIteURL = pTTWebSite + chosenYear;
            String yearPageContent = webReader.downloadWebPage(archivalCompetitionsWebSIteURL);
            List<String> listOfAllCompetitionsLinksOfYear = competitionSitesParser.getListOfCompetitionSites(yearPageContent, chosenYear);
            List<String> ListOfOneYearCompetitionsContent = webReader.downloadWebPages(listOfAllCompetitionsLinksOfYear);
            Stream<String> st = ListOfOneYearCompetitionsContent.stream();
            st.forEach(listOfChosenPeriodContent::add);
            chosenYear++;
        }
        return listOfChosenPeriodContent;
    }

    private static List<String> getChosenYearsCompetitionNames(List<String> listOfContent) {

        List<String> competitionNamesList = new ArrayList<>();
        for (String content : listOfContent) {

            if (content.contains("<title> Baza PTT </title>")) {
                int prefixIndex = content.indexOf("white\"> <h2>");
                int suffixIndex = content.indexOf("</p></span><");
                String competitionName = content.substring(prefixIndex + 12, suffixIndex).replace("</h2>       <p>", " ");
                competitionNamesList.add(competitionName);
            }
            if (content.contains("<title> Baza PTT - Brak turnieju </title>")) {
                String noCompetitionFound = "Competition exist on PTT website but no competition found";
                competitionNamesList.add(noCompetitionFound);
            } else {
                int prefixIndex = content.indexOf("<title> ");
                int suffixIndex = content.indexOf(" - Baza PTT </title>");
                String competitionName = content.substring(prefixIndex + 8, suffixIndex);
                competitionNamesList.add(competitionName);
            }
        }
        return competitionNamesList;
    }
}