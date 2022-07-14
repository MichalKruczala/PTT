package michal.kruczala.project.ptt;

import java.util.ArrayList;

public class LookForCompNumbers {

    public ArrayList lookForCompNumbers(String result) {

        ArrayList<String> compNumbers = new ArrayList<>();

        int actualValue = result.indexOf("turniej.php?nr=");
        String firstCompNumber = result.substring(actualValue);
        compNumbers.add(firstCompNumber);
        int lastValue = result.lastIndexOf("turniej.php?nr=");

        while (actualValue <= lastValue) {

            int nextValue = result.indexOf("turniej.php?nr=", actualValue);
            actualValue = nextValue + 20;
            String nextCompNumber = result.substring(nextValue + 15, nextValue + 19);
            compNumbers.add(nextCompNumber);

        }
        Object[] st = compNumbers.toArray();
        for (Object s : st) {
            if (compNumbers.indexOf(s) != compNumbers.lastIndexOf(s)) {
                compNumbers.remove(compNumbers.lastIndexOf(s));
            }
        }
        return compNumbers;
    }
}
