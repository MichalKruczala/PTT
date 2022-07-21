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
    private SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy");
    private final Scanner sc = new Scanner(System.in);
    private final Date nowDate = new Date();
    String year;

    public String yearChosenByUser() throws ParseException {

        LOGGER.debug("Insert Year of Comps ,you are interested in (possible years 2004-2022): ");


        Date firstArchivalYear = dataFormat.parse("2004");
        Date chosenYear = dataFormat.parse(year);
        Date actualYear = nowDate;

        do {
            year =  sc.nextLine();
             //   tu pracaaaa by wydobyć tylko rok w typie Date!!!
            LOGGER.debug(year + " - chosen year");

            if (actualYear.after(firstArchivalYear) || chosenYear.before(actualYear)) {
                LOGGER.debug("Wrong year");
            }
        } while (chosenYear.before(firstArchivalYear) || chosenYear.after(nowDate));

        return "&sz_rok=" + year;
    }

}