package org.sheehan.algorithm.sort;

import org.sheehan.algorithm.data_structures.*;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 5/20/14
 * Time: 7:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class Sort {

    /////////////////////////////////////////////////////////////////////////////////
    // BUBBLE SORT
    /////////////////////////////////////////////////////////////////////////////////
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

    /////////////////////////////////////////////////////////////////////////////////
    // INSERTION SORT
    /////////////////////////////////////////////////////////////////////////////////
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

    /////////////////////////////////////////////////////////////////////////////////
    // HEAP SORT
    /////////////////////////////////////////////////////////////////////////////////
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

    /////////////////////////////////////////////////////////////////////////////////
    // SELECTION SORT
    /////////////////////////////////////////////////////////////////////////////////
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

    /////////////////////////////////////////////////////////////////////////////////
    // MERGE SORT
    /////////////////////////////////////////////////////////////////////////////////
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

    private static <T> void swap(T[] array, int i, int j) {
        T tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // QUICKSORT
    /////////////////////////////////////////////////////////////////////////////////
    private static <T extends Comparable<T>> void quicksort(T[] array, int left, int right){
        if (left < right) {
            int partitionIndex = partition(array, left, right);
            quicksort(array, left, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        // left is the index of the leftmost element of the subarray
        // right is the index of the rightmost element of the subarray (inclusive)
        // number of elements in subarray = right-left+1
        int pivotIndex = choosePivot(array, left, right);
        T pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right);

        int storeIndex = left;
        for( int i = left; i < right - 1; i++){
            if (array[i].compareTo(pivotValue) < 0) {
                swap(array, i, storeIndex);
                storeIndex = storeIndex + 1;
            }
        }
        swap(array, storeIndex, right);// Move pivot to its final place
        return storeIndex;
    }

    private static <T> int choosePivot(T[] array, int left, int right) {
        return left; //TODO optimize
    }

    /////////////////////////////////////////////////////////////////////////////////
    // COUNTING SORT
    /////////////////////////////////////////////////////////////////////////////////
    private static final int MAX_RANGE = 1000000;
    public static void countingSort(Integer array[]) {

        if (array.length == 0)
            return;

        /** find max and min values **/
        int max = array[0], min = array[0];

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] > max)
                max = array[i];

            if (array[i] < min)
                min = array[i];
        }

        final int range = max - min + 1;

        /** check if range is small enough for count array **/
        /** else it might give out of memory exception while allocating memory for array **/
        if (range > MAX_RANGE)
        {
            System.out.println("\nError : Range too large for sort");
            return;

        }
        Integer b[] = (Integer[]) Array.newInstance(Integer.class, range);
        Integer output[] = (Integer[]) Array.newInstance(Integer.class, array.length);

        for (int i = 0; i < range; ++i) {
            b[i] = 0;
        }

        // histogram
        for (int i = 0; i < array.length; ++i) {
            b[array[i]-min] += 1;
        }

        // b[i] contains # of values <= b[i]
        for (int i = 1; i < range; ++i) {
            b[i] += b[i - 1];
        }

        // create sorted output
        for (int i = 0 ; i < array.length; i++) {
            b[array[i] - min] -= 1;
            int countOfElementI = b[array[i] - min];
            System.out.println("# items <= " + array[i] + " is " + countOfElementI);
            System.out.println("setting output index " + countOfElementI + " to " + array[i]);
            output[countOfElementI] = array[i];

        }

        // copy output back to array
        System.arraycopy( output, 0, array, 0, array.length );
    }

    /////////////////////////////////////////////////////////////////////////////////
    // RADIX SORT
    // LSD on integer keys
    /////////////////////////////////////////////////////////////////////////////////
    public static void radixSort(Integer array[]) {
        List<Queue<Integer>> buckets = new ListImpl<Queue<Integer>>();
        for (int i = 0; i < 10; i++){
            buckets.append(new QueueImpl<Integer>(array.length));
        }

        Integer max = Integer.MIN_VALUE;
        for (Integer value: array)
            max = (max < value) ? value:max;

        final int BASE = 10;

        // while there is a max element larger positional value, iterate another bucket sorting pass
        // moving the position from left to right by one
        for (int positionMultiplier=1; max >= positionMultiplier; positionMultiplier *= BASE) {
            // each pass checks a left to right position and buckets based on that digit
            for (Integer value : array){
                int valueDiv = value/positionMultiplier;
                int valueMod = valueDiv%BASE;
                buckets.get(valueMod).add(value);
            }

            // reset array to new order after sorting this pass
            // the new order is obtained by removing elements from the bucket queues in FIFO order
            // starting from least valued bucket
            int index = 0;
            for (int i = 0; i < BASE; ++i){
                Queue<Integer> bucket = buckets.get(i);
                Integer value;
                while ((value = bucket.remove()) != null){
                    array[index++] = value;
                }
            }
        }
    }
}
