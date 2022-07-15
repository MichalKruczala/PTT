package michal.kruczala.project.ptt;

import java.util.*;

public class CompetitionNumberParser {
    private int actualValue;
    private String firstCompetitionNumber;
    private static final String url = "turniej.php?nr=";
    private List<String> competitionNumbers = ListInterface();
    private int lastValue;
    public List lookForCompetitionNumbers(String result) {

        actualValue = result.indexOf(url);
        lastValue = result.lastIndexOf(url);
        firstCompetitionNumber = result.substring(actualValue);
        competitionNumbers.add(firstCompetitionNumber);

        AddingCompetitionNumbersToList(result, lastValue);
        cleanDuplicatesInList();
        return competitionNumbers;
    }

    private void AddingCompetitionNumbersToList(String result, int lastValue) {
        while (actualValue <= lastValue) {

            int nextValue = result.indexOf(url, actualValue);
            actualValue = nextValue + 20;
            String nextCompNumber = result.substring(nextValue + 15, nextValue + 19);
            competitionNumbers.add(nextCompNumber);

        }
    }

    private void cleanDuplicatesInList() {
        Object[] st = competitionNumbers.toArray();
        for (Object s : st) {
            if (competitionNumbers.indexOf(s) != competitionNumbers.lastIndexOf(s)) {
                competitionNumbers.remove(competitionNumbers.lastIndexOf(s));
            }
        }
    }

    private List<String> ListInterface() {
        List<String> compNumbers = new List<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public String get(int index) {
                return null;
            }

            @Override
            public String set(int index, String element) {
                return null;
            }

            @Override
            public void add(int index, String element) {

            }

            @Override
            public String remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<String> listIterator() {
                return null;
            }

            @Override
            public ListIterator<String> listIterator(int index) {
                return null;
            }

            @Override
            public List<String> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        return compNumbers;
    }
}
