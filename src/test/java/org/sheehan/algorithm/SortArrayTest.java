package org.sheehan.algorithm;

import org.junit.Test;


import org.sheehan.algorithm.sort.SortArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SortArrayTest {

    @Test
    public void testBubbleSort() throws Exception {
        Integer array[] = Array.createArray(20, 100, false);

        System.out.println("bubble");
        System.out.println(Arrays.toString(array));

        SortArray.bubbleSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();

    }

    @Test
    public void testBubbleSortPolarity() throws Exception {
        Integer array[] = Array.createArray(30, 30, false);
        int array2[] = new int[array.length];
        for (Integer i : array){
            array2[i] = i.intValue();
        }

        SortArray.bubbleSortPolarity(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println();

        array = Array.createArray(30, 30, false);
        for (Integer i : array){
            array2[i] = i.intValue();
        }

        SortArray.bubbleSortPolarity(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println();

    }

    @Test
    public void testInsertionSortArray() throws Exception {
        Integer array[] = {6,5,3,1,8,7};

        System.out.println("insertion");
        System.out.println(Arrays.toString(array));

        SortArray.insertionSort2(array);
        System.out.println(Arrays.toString(array));
        System.out.println();

    }

    @Test
    public void testHeapSort() throws Exception {
        Integer array[] = Array.createArray(10,10, false);

        System.out.println("heap");
        System.out.println(Arrays.toString(array));

        SortArray.heapSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }


    @Test
    public void testSelectionSort() throws Exception {
        Integer array[] = Array.createArray(10,10, false);

        System.out.println("selection");
        System.out.println(Arrays.toString(array));

        SortArray.selectionSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    @Test
    public void testSelectionSortRecursive() throws Exception {
        Integer array[] = Array.createArray(10,10, false);

        System.out.println("selection recurse");
        System.out.println(Arrays.toString(array));

        SortArray.selectionSortRecursive(array, 1);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }


    @Test
    public void testMergeSort() throws Exception {
        Integer array[] = Array.createArray(10,10, false);

        System.out.println("merge");
        System.out.println(Arrays.toString(array));

        SortArray.mergeSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    // simple merge of ints
    @Test
    public void testMergeSort2() throws Exception {
        Integer array[] = Array.createArray(10,10, false);
        int array2[] = new int[array.length];
        for (int i = 0; i < array.length; i++)
            array2[i]=array[i];

        System.out.println("merge");
        System.out.println(Arrays.toString(array2));

        SortArray.mergeSort2(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println();
    }

    @Test
    public void testQuickSortSelect() throws Exception {
        Integer array[] = Array.createArray(10,20,false);

        System.out.println("quick-select");

        int index = SortArray.quicksortSelectKSmallest(array, 0, array.length - 1, 4);
        System.out.println(Arrays.toString(array));
        System.out.println(array[index]);
        System.out.println();
    }

    @Test
    public void testQuickSort() throws Exception {
        Integer array[] = Array.createArray(10,100,false);

        System.out.println("quick");
        System.out.println(Arrays.toString(array));

        SortArray.quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println();

    }

    @Test
    public void testCountingSort() throws Exception {
        Integer array[] = Array.createArray(10,20,false);

        System.out.println("counting");
        System.out.println(Arrays.toString(array));

        SortArray.countingSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    @Test
    public void testCountingSort2() throws Exception {
        Integer array[] = Array.createArray(10,20,false);

        System.out.println("counting");
        System.out.println(Arrays.toString(array));

        SortArray.countingSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    @Test
    public void testRadixSortLsd() throws Exception {
        Integer array[] = Array.createArray(10,20,false);

        System.out.println("radix lsd");
        System.out.println(Arrays.toString(array));

        SortArray.radixSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    @Test
    public void testRadixSortBinaryLsd() throws Exception {
        Integer array[] = Array.createArray(10,20,false);

        System.out.println("radix lsd");
        System.out.println(Arrays.toString(array));

        SortArray.radixSortBinaryLsd(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }
}