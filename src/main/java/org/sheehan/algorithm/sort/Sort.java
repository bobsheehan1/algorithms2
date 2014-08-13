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
        while ((value=heap.remove()) != null) {
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

    public static <T extends Comparable<T>> T[] mergeSort(T array[])
    {
        if (array.length <= 1)
            return array;

        int size1 = array.length/2;
        int size2 = array.length - size1;
        T array1[] = (T[]) java.lang.reflect.Array.newInstance(Comparable.class, size1);
        T array2[] = (T[]) java.lang.reflect.Array.newInstance(Comparable.class, size2);

        System.arraycopy(array, 0, array1, 0, size1);
        System.arraycopy(array, size1, array2, 0, size2);

        mergeSort(array1);
        mergeSort(array2);

        //overwrite array with merge
        merge(array1, array2, array);
        return array;
    }

    private static <T extends Comparable<T>> void merge(T[] array1, T[]array2, T[]array){

        int i, index1, index2;
        i = 0;
        index1 = 0;
        index2 = 0;

        // merge common length of 2 arrays
        while(index1 < array1.length && index2 < array2.length){
            if (array1[index1].compareTo(array2[index2]) < 0) {
                array[i++] = array1[index1++];
            } else {
                array[i++] = array2[index2++];
            }
        }

        // merge any left over where array lengths don't match
        while(index1 < array1.length){
            array[i++] = array1[index1++];
        }
        while(index2 < array2.length){
            array[i++] = array2[index2++];
        }
    }

    private static void swap(Integer[] array, int i, int j) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }
}
