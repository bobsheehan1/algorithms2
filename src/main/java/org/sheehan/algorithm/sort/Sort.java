package org.sheehan.algorithm.sort;

import org.sheehan.algorithm.data_structures.BinaryHeap;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 5/20/14
 * Time: 7:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class Sort {

    // worst 0(n2)
    // avg O(n2)
    // best O(n)
    public static void bubbleSort(Integer []array) {
        int n = array.length - 1;

        boolean swapped = true;
        // repeat until no more swaps
        while (swapped) {
            swapped = false;

            for (int j = 0; j < n; ++j) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            n = n - 1;
        }
    }

    // worst 0(n2)
    // avg O(n2)
    // best O(n)
    public static void insertionSort(Integer []array){
        int n = array.length;

        for (int i = 1; i < n; ++i){
            int j = i;
            // check/swap iterating backwards from i
            while (j > 0){
                if (array[j] < array[j-1]) {
                    swap(array, j, j-1);
                }
                j--;
            }
        }
    }

    // worst 0(nlogn)
    // avg O(nlogn)
    // best O(nlogn)
    public static void heapSort(Integer []array) {
        BinaryHeap<Integer> heap = new BinaryHeap<>(array.length, BinaryHeap.HeapType.MIN_HEAP);
        heap.buildHeap(array);
        Integer sortedArray[] = new Integer[array.length];
        Integer value;
        int cnt = 0;
        while ((value=heap.poll()) != null) {
            sortedArray[cnt++] = value;
        }
        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }

    // loop finding minimum element and move to next position at front
    public static void selectionSort(Integer array[]) {

        for (int i = 1; i < array.length; ++i) {
            int iMin = i;
            for (int j = i+1; j < array.length; ++j) {
                if (array[j] < array[iMin])
                    iMin = j;

            }

            if (i != iMin)
                swap(array, i, iMin);
        }
    }


    private static void swap(Integer[] array, int i, int j) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }
}
