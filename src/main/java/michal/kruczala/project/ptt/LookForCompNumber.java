package michal.kruczala.project.ptt;

public class LookForCompNumber {

    public String lookForCompNumber(String result) {

       int actualValue = result.indexOf("turniej.php?nr=");
        String compNumber = result.substring(actualValue+15,actualValue+16);
        String compNumber1 = result.substring(actualValue+17,actualValue+18);
      //  String compNumber2 = result.substring(actualValue+17,actualValue+18);
      //  String compNumber3 = result.substring(actualValue+19,actualValue+20);
String compNumberAll =compNumber+  compNumber1;// + compNumber2 + compNumber3;
      return compNumberAll;
    }
}
//        result;
//        $tekst = "19/11/1982 01:43:12";
//
//        $dataiczas = explode(" ", $tekst);
//        $data = explode("/", $dataiczas[0]);
//        $czas = explode(":", $dataiczas[1]);
//
//        echo "dzień: $data[0], miesiąc: $data[1], rok: $data[2]
//        ";
//        echo "godzina: $czas[0], minuta: $czas[1], sekunda: $czas[2]";
//
//
//        Metoda substring zwraca wybrany fragment ciągu znaków o podanym zakresie indeksów.
//
//                String str = "Java";
//        String actualValue = str.substring(1, 3);
//        String expectedValue = "av";
//
//
//        Metoda indexOf wyszukuje podanego ciągu znaków i zwraca indeks pierwszego znalezionego wystąpienia. Opcjonalnie można podać indeks, od którego ma rozpocząć się przeszukiwanie lub skorzystać z metody: lastIndexOf w celu znalezienia ostatniego wystąpienia.
//
//        String str = "Java 8";
//        int actualValue = str.indexOf("a");
//        int expectedValue = 1;
//        assertEquals(expectedValue, actualValue);
//        str = "Java 8";
//        actualValue = str.lastIndexOf("a");
//        expectedValue = 3;
//        assertEquals(expectedValue, actualValue);
//
