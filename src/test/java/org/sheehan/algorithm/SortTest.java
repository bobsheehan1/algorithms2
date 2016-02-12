package org.sheehan.algorithm;

import org.junit.Test;


import org.sheehan.algorithm.data_structures.Array;
import org.sheehan.algorithm.data_structures.List;
import org.sheehan.algorithm.data_structures.ListImpl;
import org.sheehan.algorithm.sort.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SortTest {

    @Test
    public void testBubbleSort() throws Exception {
        Integer array[] = Array.createArray(20, 100, false);

        System.out.println("bubble");
        System.out.println(Arrays.toString(array));

        Sort.bubbleSort(array);
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

        Sort.bubbleSortPolarity(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println();

        array = Array.createArray(30, 30, false);
        for (Integer i : array){
            array2[i] = i.intValue();
        }

        Sort.bubbleSortPolarity(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println();

    }

    @Test
    public void testInsertionSortArray() throws Exception {
        Integer array[] = Array.createArray(10,10, false);

        System.out.println("insertion");
        System.out.println(Arrays.toString(array));

        Sort.insertionSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();

    }

    @Test
    public void testInsertionSortList() throws Exception {
        Integer array[] = Array.createArray(10,10, false);
        List<Integer> list = new ListImpl<>();
        for (Integer i : array){
            list.appendBack(i);
        }

        System.out.println("insertion");
        list.print();


        Sort.insertionSort(list);
        list.print();


        System.out.println();

    }

    @Test
    public void testHeapSort() throws Exception {
        Integer array[] = Array.createArray(10,10, false);

        System.out.println("heap");
        System.out.println(Arrays.toString(array));

        Sort.heapSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }


    @Test
    public void testSelectionSort() throws Exception {
        Integer array[] = Array.createArray(10,10, false);

        System.out.println("selection");
        System.out.println(Arrays.toString(array));

        Sort.selectionSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    @Test
    public void testSelectionSortRecursive() throws Exception {
        Integer array[] = Array.createArray(10,10, false);

        System.out.println("selection recurse");
        System.out.println(Arrays.toString(array));

        Sort.selectionSortRecursive(array, 1);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }


    @Test
    public void testMergeSort() throws Exception {
        Integer array[] = Array.createArray(10,10, false);

        System.out.println("merge");
        System.out.println(Arrays.toString(array));

        Sort.mergeSort(array);
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

        Sort.mergeSort2(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println();
    }

    @Test
    public void testQuickSortSelect() throws Exception {
        Integer array[] = Array.createArray(10,20,false);

        System.out.println("quick-select");

        int index = Sort.quicksortSelectKSmallest(array, 0, array.length - 1, 4);
        System.out.println(Arrays.toString(array));
        System.out.println(array[index]);
        System.out.println();
    }

    @Test
    public void testQuickSort() throws Exception {
        Integer array[] = Array.createArray(10,100,false);

        System.out.println("quick");
        System.out.println(Arrays.toString(array));

        Sort.quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println();

    }

    @Test
    public void testCountingSort() throws Exception {
        Integer array[] = Array.createArray(10,20,false);

        System.out.println("counting");
        System.out.println(Arrays.toString(array));

        Sort.countingSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    @Test
    public void testCountingSort2() throws Exception {
        Integer array[] = Array.createArray(10,20,false);

        System.out.println("counting");
        System.out.println(Arrays.toString(array));

        Sort.countingSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    @Test
    public void testRadixSortLsd() throws Exception {
        Integer array[] = Array.createArray(10,20,false);

        System.out.println("radix lsd");
        System.out.println(Arrays.toString(array));

        Sort.radixSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    @Test
    public void testRadixSortBinaryLsd() throws Exception {
        Integer array[] = Array.createArray(10,20,false);

        System.out.println("radix lsd");
        System.out.println(Arrays.toString(array));

        Sort.radixSortBinaryLsd(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    @Test
    public void testRadixSortLsdLexical() throws Exception {
        String array[] = {"zxc", "ldf", "ior", "oiw", "pwo", "aaa"};

        System.out.println("radix lsd lexical");
        System.out.println(Arrays.toString(array));

        Sort.radixSortLexicalFixedLsd(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    @Test
    public void testRadixSortMsdLexical() throws Exception {
        java.util.List<String> lst = new ArrayList<>( );
        Random r = new Random( );

        //final int LEN = 7;

        for( int i = 0; i < 20; i++ )
        {
            String str = "";
            int len =  1 + r.nextInt( 5 ); // between 3 and 9 characters

            for( int j = 0; j < len; j++ )
                str += (char) ( 'a' + r.nextInt( 26 ) );

            lst.add( str );
        }

        String []arr1 = new String[ lst.size( ) ];

        lst.toArray( arr1 );

        System.out.println("radix lsd lexical");
        System.out.println(Arrays.toString(arr1));

        Sort.radixSortVarLengthMsd(arr1, 9);
        System.out.println(Arrays.toString(arr1));
        System.out.println();
    }
}