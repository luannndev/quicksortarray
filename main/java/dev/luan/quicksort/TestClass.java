package dev.luan.quicksort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        QuicksortArray<Integer> quicksort = new QuicksortArray<>();
        List<Integer> integerList = Arrays.asList(16, 3465, 9, 1, 7, 6, 7423424, 4434, 138, 100, 99, 757);
        System.out.println(quicksort.quickSort(integerList));

        QuicksortArray<String> quicksortString = new QuicksortArray<String>(Comparator.comparing(String::valueOf, String.CASE_INSENSITIVE_ORDER));
        List<String> stringList = Arrays.asList("Apfel", "Bananen", "Kirsche", "Datteln", "Erdbeere");
        System.out.println(quicksortString.quickSort(stringList));
    }

}
