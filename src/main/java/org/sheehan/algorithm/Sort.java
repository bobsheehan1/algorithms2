package org.sheehan.algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 5/20/14
 * Time: 7:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class Sort {

    static void bubbleSort(Integer []array) {
        int n = array.length-1;

        boolean swapped = true;
        // repeat until no more swaps
        while (swapped) {
            swapped = false;

            for (int j = 0; j < n; ++j){
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    swapped = true;
                }
            }
            n = n-1;
        }
    }

    private static void swap(Integer[] array, int i, int j) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    static void insertionSort(Integer []array){
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
}
