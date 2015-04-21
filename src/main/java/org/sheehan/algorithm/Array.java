package org.sheehan.algorithm;

import org.sheehan.algorithm.sort.Sort;

import java.util.*;

/**
 * Created by bob on 6/5/14.
 */
public class Array {

    // print start index, length, element value of longest run in array
    public static <T> void findLongestRun(T array[]) {
       int length = 1;
       int maxLength = 0;
       T maxVal = null;

       int start = -1; //optional locate run
       int maxStart = -1;//optional locate run

       // limit is 1 less than length for next compare
       for (int i = 0; i < array.length-1; ++i) {
            if (array[i].equals(array[i+1])){
                length++;
                if(start == -1) //optional locate run
                    start = i;  //optional locate run
            }

            // change or end of array
            if (!array[i].equals(array[i+1]) || i == array.length-2){
                if (length > maxLength) {
                    maxLength = length;
                    maxVal = array[i];
                    maxStart = start; //optional locate run
                }
                length = 1;
                start = -1; //optional locate run
            }
        }

        System.out.println("start: " +maxStart+" length: "+maxLength+" value: "+maxVal);
    }

    private static <T> void reverse(T[] buffer, int start, int end) {

        final int length = end-start;
        final int pivot = start + length/2;

        for (int i = start, cnt = 0; i <= pivot; ++i, ++cnt){
            T c = buffer[i];
            buffer[i] = buffer[end - cnt];
            buffer[end - cnt] = c;
        }
    }

    public static <T> void rotateArray( T[] array, int shift) {
        shift %= array.length;

        //Array.print(array);
        reverse(array, 0, array.length-1);
        //Array.print(array);
        reverse(array, 0, shift-1);
        //Array.print(array);
        reverse(array, shift, array.length-1);
        //Array.print(array);
    }

    public static Integer[] createSortedArray(int size, int limit){

        Random random = new Random();
        List<Integer> list = new ArrayList<Integer>();
        do {
            list.add(random.nextInt() % (limit)/2 + limit/2);
        }while( list.size() != size);
        Integer[] array = list.toArray(new Integer[0]);


        Sort.insertionSort(array);
        return array;
    }

    public static <T>void print(T [] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static <T extends Comparable> T[] mergeSortedArrays(T[]array1, T[]array2){
        int n = array1.length; //both same length assumed

        T[] merged = (T[])new Comparable[2*n];

        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while(i1 < n && i2 < n){
            if (array1[i1].compareTo(array2[i2]) < 0)
                merged[i++] = array1[i1++];
            else
                merged[i++] = array2[i2++];

        }

        // one array will have left overs

        //this
        while(i1 < n)
            merged[i++] = array1[i1++];

        //or this
        while(i2 < n)
            merged[i++] = array2[i2++];

        return merged;
    }

    public static void getPermutations(List<Integer> prefix, List<Integer> array, Set<List<Integer>> cache) {
        //System.out.println("\tpermutation pre:" + prefix + " str:" + str + " level:" + level);
        int n = array.size();
        if (n == 0) {
            //System.out.println("\tEND permutation pre:" + prefix + " str:" + str + " level:" + level);
            //System.out.println();
            //System.out.println(prefix);
            cache.add(prefix);
        }
        else {
            for (int i = 0; i < n; i++) {
                //System.out.println("\t\tloop in  i:" + i + " pre:" + prefix + " str:" + str + " level:" + level);
               // List<Integer> prefix2 = new ArrayList<Integer>();
               // prefix2.addAll(prefix);
               // prefix2.add(array.get(i));

                List<Integer> array2 = new ArrayList<Integer>();
                array2.addAll(array.subList(0, i));
                array2.addAll(array.subList(i + 1, n));
                //System.out.println("\t\tloop out i:" + i + " pre:" + prefix2 + " str:" + str2 + " level:" + level);
                List<Integer> prefix2 = new ArrayList<Integer>();
                prefix2.addAll(prefix);
                prefix2.add(array.get(i));
                getPermutations(prefix2, array2, cache);
            }
        }
    }
}
