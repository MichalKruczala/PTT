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
    SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy");
    private Date chosenYear;

    public int yearChosenByUser() throws ParseException {

        do {
            LOGGER.debug("Insert Year of Comps ,you are interested in (possible years 2004-2022): ");
            chosenYear = convertGivenYearToDataType(takeYearFromUser());
            LOGGER.debug(chosenYear + " - chosen year");

            if (validateDate()) {
                LOGGER.debug("Wrong year");
            }
        } while (validateDate());
        ;
        return chosenYear.getYear() + 1900;
    }

    private boolean validateDate() throws ParseException {
        Date firstArchivalCompetitionYear = dataFormat.parse("2004");
        Date nowDate = new Date();

        return chosenYear.before(firstArchivalCompetitionYear) || chosenYear.after(nowDate);
    }

    private String takeYearFromUser() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private Date convertGivenYearToDataType(String year) throws ParseException {
        return dataFormat.parse(year);
    }

}