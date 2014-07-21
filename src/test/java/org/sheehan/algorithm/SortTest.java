package org.sheehan.algorithm;

import org.junit.Test;
import org.sheehan.algorithm.sort.Sort;

import java.util.Arrays;

public class SortTest {

    @Test
    public void testBubbleSort() throws Exception {
        Integer array[] = {1,6,3,8,7,2,5,11,55,33,88};

        System.out.println("bubble");
        System.out.println(Arrays.toString(array));

        Sort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();

    }

    @Test
    public void testInsertionSort() throws Exception {
        Integer array[] = {1,6,3,8,7,2,5,11,55,33,88};

        System.out.println("insertion");
        System.out.println(Arrays.toString(array));

        Sort.insertionSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();

    }

    @Test
    public void testHeapSort() throws Exception {
        Integer array[] = {1,6,3,8,7,2,5,11,55,33,88};

        System.out.println("heap");
        System.out.println(Arrays.toString(array));

        Sort.heapSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }


    @Test
    public void testSelectionSort() throws Exception {
        Integer array[] = {1,6,3,8,7,2,5,11,55,33,88};

        System.out.println("selection");
        System.out.println(Arrays.toString(array));

        Sort.selectionSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }
}