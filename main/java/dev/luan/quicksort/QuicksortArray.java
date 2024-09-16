package dev.luan.quicksort;

public class QuicksortArray {

    private int[] aInternalIntegerArray;

    public int[] quickSort(int[] pIntergerArray) {
        this.aInternalIntegerArray = pIntergerArray;
        return this.internalQuickSort(0, pIntergerArray.length - 1);
    }

    private int[] internalQuickSort(int pBeginIndex, int pEndIndex) {
        int lPivot;
        if (pBeginIndex < pEndIndex) {
            lPivot = this.partition(pBeginIndex, pEndIndex);
            this.internalQuickSort(pBeginIndex, lPivot);
            this.internalQuickSort(lPivot + 1, pEndIndex);
        }
        return aInternalIntegerArray;
    }


    int partition(int pBeginIndex, int pEndIndex) {
        int i;
        int j;
        int x = aInternalIntegerArray[(pBeginIndex + pEndIndex) / 2];
        i = pBeginIndex - 1;
        j = pEndIndex + 1;

        boolean returned = false;

        while (true) {
            do {
                i++;
            } while (aInternalIntegerArray[i] < x);

            do {
                j--;
            } while (aInternalIntegerArray[j] > x);

            if (i < j) {
                int k = aInternalIntegerArray[i];
                aInternalIntegerArray[i] = aInternalIntegerArray[j];
                aInternalIntegerArray[j] = k;
            } else {
                return j;
            }
        }
    }
}
