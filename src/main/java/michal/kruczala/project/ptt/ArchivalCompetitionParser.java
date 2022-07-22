package michal.kruczala.project.ptt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Slf4j
public class ArchivalCompetitionParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParserPTT.class);
    private final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy");
    private final Scanner sc = new Scanner(System.in);
    private final Date nowDate = new Date();
    Date chosenYear;


    public String yearChosenByUser() throws ParseException {


        Date firstArchivalCompetitionYear = dataFormat.parse("2004");


        do {
            LOGGER.debug("Insert Year of Comps ,you are interested in (possible years 2004-2022): ");
            chosenYear = convertGivenYearToDataType(takeYearFromUser());
            LOGGER.debug(chosenYear + " - chosen year");

            if (chosenYear.before(firstArchivalCompetitionYear) || chosenYear.after(nowDate)) {
                LOGGER.debug("Wrong year");
            }
        } while (chosenYear.before(firstArchivalCompetitionYear) || chosenYear.after(nowDate));

        return "&sz_rok=" + chosenYear.getYear();
    }

    private String takeYearFromUser() {
        return sc.next();
    }

    private Date convertGivenYearToDataType(String year) throws ParseException {
        return dataFormat.parse(year);
    }


}