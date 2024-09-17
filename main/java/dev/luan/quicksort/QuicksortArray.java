package dev.luan.quicksort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuicksortArray<T extends Comparable<T>> {
    private List<T> list;
    private Comparator<T> comparator;
    private int swapCount;

    public QuicksortArray() {
        this.comparator = Comparator.naturalOrder();
    }

    public QuicksortArray(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public List<T> quickSort(List<T> inputList) {
        this.list = new ArrayList<>(inputList);
        swapCount = 0;
        internalQuickSort(0, inputList.size() - 1);
        return list;
    }

    public List<T> quickSortDescending(List<T> inputList) {
        Comparator<T> reversed = comparator.reversed();
        QuicksortArray<T> quicksort = new QuicksortArray<>(reversed);
        return quicksort.quickSort(inputList);
    }

    public boolean isSorted(List<T> list, boolean ascending) {
        List<T> copyList = new ArrayList<>(list);
        List<T> sortedList = quickSort(copyList);
        if (ascending) {
            return list.equals(sortedList);
        } else {
            Collections.reverse(sortedList);
            return list.equals(sortedList);
        }
    }

    public T kthSmallest(List<T> list, int k) {
        QuicksortArray<T> quicksort = new QuicksortArray<>(comparator);
        List<T> sorted = quicksort.quickSort(list);
        return sorted.get(k - 1);  // 0-indexed, adjust if necessary
    }

    public List<T> shuffle(List<T> inputList) {
        List<T> shuffleList = new ArrayList<>(inputList);
        Collections.shuffle(shuffleList);
        return shuffleList;
    }

    public long measureSortTime(List<T> inputList) {
        long startTime = System.currentTimeMillis();
        quickSort(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public int getSwapCount() {
        return swapCount;
    }

    public List<T> sortedCopy(List<T> inputList) {
        List<T> copyList = new ArrayList<>(inputList);
        return quickSort(copyList);
    }

    public T findMax(List<T> inputList) {
        return Collections.max(inputList, comparator);
    }

    public T findMin(List<T> inputList) {
        return Collections.min(inputList, comparator);
    }

    public long count(List<T> inputList, T element) {
        return inputList.stream().filter(x -> x.equals(element)).count();
    }

    public List<T> commonElements(List<T> list1, List<T> list2) {
        List<T> common = new ArrayList<>(list1);
        common.retainAll(list2);
        return common;
    }

    public boolean allEqual(List<T> inputList) {
        return inputList.stream().allMatch(inputList.get(0)::equals);
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
                swapCount++;
            }
        }

        Collections.swap(list, i+1, pEndIndex);
        swapCount++;

        return i+1;
    }
}