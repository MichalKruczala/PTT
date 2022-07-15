package michal.kruczala.project.ptt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class ArchivalCompetitionParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParserPTT.class);
    Scanner sc = new Scanner(System.in);

    public String lookForArchivalYearCompsENDURL() {
        System.out.print("LOOKING FOR ARCHIVAL COMPETITION? ");
        int year;
        do {
            System.out.print("Insert Year of Comps ,you are interested in (possible years 2004-2022): ");
            year = sc.nextInt();

            LOGGER.debug(year + " - chosen year");
            if (year < 2004 || year > 2022) {
                System.out.println("Wrong year");
            }

        } while (year < 2004 || year > 2022);
        return "&sz_rok=" + year;
    }
}