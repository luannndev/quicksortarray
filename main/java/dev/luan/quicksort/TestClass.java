package dev.luan.quicksort;

import java.util.Arrays;

public class TestClass {

    public static void main(String[] args) {
        QuicksortArray quicksortArray = new QuicksortArray();

        int[] intergerArray = {16, 3465, 9, 1, 7, 6, 7423424, 4434, 138, 100, 99, 757 };

        quicksortArray.quickSort(intergerArray);

        System.out.println(Arrays.toString(intergerArray));
    }

}
