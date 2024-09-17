package dev.luan.quicksort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuicksortArray<T extends Comparable<T>> {
    private List<T> list;
    private Comparator<T> comparator;

    public QuicksortArray() {
        this.comparator = Comparator.naturalOrder();
    }

    public QuicksortArray(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public List<T> quickSort(List<T> inputList) {
        this.list = new ArrayList<>(inputList);
        internalQuickSort(0, inputList.size() - 1);
        return list;
    }

    private void internalQuickSort(int pBeginIndex, int pEndIndex) {
        if (pBeginIndex < pEndIndex) {
            int pivot = partition(pBeginIndex, pEndIndex);
            internalQuickSort(pBeginIndex, pivot-1);
            internalQuickSort(pivot+1, pEndIndex);
        }
    }

    int partition(int pBeginIndex, int pEndIndex) {
        T x = list.get(pEndIndex);
        int i = pBeginIndex - 1;

        for(int j = pBeginIndex; j < pEndIndex; j++){
            if(comparator.compare(list.get(j), x) <= 0){
                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i+1, pEndIndex);
        return i+1;
    }
}