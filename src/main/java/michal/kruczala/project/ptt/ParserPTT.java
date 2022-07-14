package michal.kruczala.project.ptt;

import michal.kruczala.project.ptt.readers.WebReader;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParserPTT {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParserPTT.class);
    private static final WebReader webReader = new WebReader();
    private static final LookForCompNumbers lookForCompNumbersObject = new LookForCompNumbers();

    private static final String PTTWebSite = "https://baza.taniec.pl/?v=turnieje&p=arch";


    public static void main(String[] args) throws IOException {

        String result = webReader.downloadWebPage(PTTWebSite);
        LOGGER.debug(result);

        extractCompNumbersFromPTTWebsite(result);
        LOGGER.debug(extractCompNumbersFromPTTWebsite(result));


    }

    private static String extractCompNumbersFromPTTWebsite(String result) {
        return String.valueOf(lookForCompNumbersObject.lookForCompNumbers(result));
    }

}




