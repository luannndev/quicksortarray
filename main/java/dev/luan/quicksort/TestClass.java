package dev.luan.quicksort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        QuicksortArray<Integer> quicksort = new QuicksortArray<>();
        List<Integer> integerList = Arrays.asList(16, 3465, 9, 1, 7, 6, 7423424, 4434, 138, 100, 99, 757);
        System.out.println(quicksort.quickSort(integerList));

        System.out.println("Sortierte Liste desscending: " + quicksort.quickSortDescending(integerList));

        System.out.println("Ist Liste sortiert (erwarte false): " + quicksort.isSorted(integerList, true));
        System.out.println("Ist sortierte Liste sortiert (erwarte true): " + quicksort.isSorted(quicksort.quickSort(integerList), true));

        System.out.println("Das dritte kleinste Element: " + quicksort.kthSmallest(integerList, 3));

        System.out.println("Randomisiert Liste: " + quicksort.shuffle(integerList));

        System.out.println("Zeit für das Sortieren (in ms): " + quicksort.measureSortTime(integerList));

        System.out.println("Anzahl der Swap-Operationen: " + quicksort.getSwapCount());

        System.out.println("Maximales Element: " + quicksort.findMax(integerList));

        System.out.println("Minimales Element: " + quicksort.findMin(integerList));

        System.out.println("Anzahl von " + 100 + ": " + quicksort.count(integerList, 100));

        System.out.println("Prüfen ob Alle gleich: " + quicksort.allEqual(integerList));

        QuicksortArray<String> quicksortString = new QuicksortArray<String>(Comparator.comparing(String::toString, String.CASE_INSENSITIVE_ORDER));
        List<String> stringList = Arrays.asList("Apfel", "Bananen", "Kirsche", "Datteln", "Erdbeere");

        System.out.println("Sortierte String Liste: " + quicksortString.quickSort(stringList));

        List<String> anotherStringList = Arrays.asList("Bananen", "Erdbeere", "Feigen");

        System.out.println("Gemeinsame Elemente: " + quicksortString.commonElements(stringList, anotherStringList));
    }
}