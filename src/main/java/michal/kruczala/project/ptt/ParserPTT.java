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


      //  List<String> listOFContents = getChosenYearsCompetitionSitesContentList();
      //  logger.debug(String.valueOf(listOFContents));
        //List<String> listOfCompetitionNames = getChosenYearsCompetitionNames();
      //  String nazwaTurnieju =


        String doObróbki = "n class=\"white\"> <h2>CeA Challenge Cup Letni Pod Honorowym Patronatem Wojewody Małopolskiego Łukasza Kmity oraz Stefana Kolawińskiego Burmistrza Miasta Bochni i Starosty Bocheńskiego Adama Korty</h2>       <p>2022-07-03 Bochnia, Pactum</p></span></di";
        String do2Obróbki = "<title> Puchar Klas F, E i D - Baza PTT </title>\n";
        String linkDoTurnieju = "https://baza.taniec.pl/?v=turnieje_pary&w=5267";
        String nazwaTurnieju;

        //String CompetitionContent = webReader.downloadWebPage(linkDoTurnieju);
        int przedNazwą = doObróbki.indexOf("white\"> <h2>");
        int poNazwie = doObróbki.indexOf("</p></span><");
        nazwaTurnieju = doObróbki.substring(przedNazwą+12,poNazwie);
       String jolo =  nazwaTurnieju.replace("</h2>       <p>"," ");

        System.out.println(jolo);

        //  getChosenYearsCompetitionNames();
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

    private static String getChosenYearsCompetitionNames() throws ParseException, IOException {
        //List<String> competitionNames = new ArrayList<>();
        //List<String> chosenSitesContent = getChosenYearsCompetitionSitesContentList();

        String doObróbki = "n class=\"white\"> <h2>CeA Challenge Cup Letni Pod Honorowym Patronatem Wojewody Małopolskiego Łukasza Kmity oraz Stefana Kolawińskiego Burmistrza Miasta Bochni i Starosty Bocheńskiego Adama Korty</h2>       <p>2022-07-03 Bochnia, Pactum</p></span></di";
        String linkDoTurnieju = "https://baza.taniec.pl/?v=turnieje_pary&w=5267";
        String nazwaTurnieju;

        //String CompetitionContent = webReader.downloadWebPage(linkDoTurnieju);
        int przedNazwą = doObróbki.indexOf("<h2>");
        int poNazwie = doObróbki.indexOf("</p></span><");
        nazwaTurnieju = doObróbki.substring(doObróbki.indexOf(przedNazwą,poNazwie));


       return nazwaTurnieju;
    }
}