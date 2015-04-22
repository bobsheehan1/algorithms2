package org.sheehan.algorithm.data_structures;

import org.sheehan.algorithm.sort.Sort;

import java.util.*;
import java.util.List;

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
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i].equals(array[i + 1])) {
                length++;
                if (start == -1) //optional locate run
                    start = i;  //optional locate run
            }

            // change or end of array
            if (!array[i].equals(array[i + 1]) || i == array.length - 2) {
                if (length > maxLength) {
                    maxLength = length;
                    maxVal = array[i];
                    maxStart = start; //optional locate run
                }
                length = 1;
                start = -1; //optional locate run
            }
        }

        System.out.println("start: " + maxStart + " length: " + maxLength + " value: " + maxVal);
    }

    private static <T> void reverse(T[] buffer, int start, int end) {

        final int length = end - start;
        final int pivot = start + length / 2;

        for (int i = start, cnt = 0; i <= pivot; ++i, ++cnt) {
            T c = buffer[i];
            buffer[i] = buffer[end - cnt];
            buffer[end - cnt] = c;
        }
    }

    public static <T> void rotateArray(T[] array, int shift) {
        shift %= array.length;

        //Array.print(array);
        reverse(array, 0, array.length - 1);
        //Array.print(array);
        reverse(array, 0, shift - 1);
        //Array.print(array);
        reverse(array, shift, array.length - 1);
        //Array.print(array);
    }

    public static Integer[] createArray(int size, int limit, boolean sorted) {

        Random random = new Random();
        java.util.List<Integer> list = new ArrayList<Integer>();
        do {
            list.add(random.nextInt() % (limit) / 2 + limit / 2);
        } while (list.size() != size);
        Integer[] array = list.toArray(new Integer[0]);


        if (sorted)
            Sort.insertionSort(array);
        return array;
    }

    public static <T> void print(T[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static <T extends Comparable> T[] mergeSortedArrays(T[] array1, T[] array2) {
        int n = array1.length; //both same length assumed

        T[] merged = (T[]) new Comparable[2 * n];

        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while (i1 < n && i2 < n) {
            if (array1[i1].compareTo(array2[i2]) < 0)
                merged[i++] = array1[i1++];
            else
                merged[i++] = array2[i2++];
        }

        // one array will have left overs

        //this
        while (i1 < n)
            merged[i++] = array1[i1++];

        //or this
        while (i2 < n)
            merged[i++] = array2[i2++];

        return merged;
    }

    static void getPermutations2(java.util.List<Integer> arr, int k) {
        for (int i = k; i < arr.size(); i++) {
            java.util.Collections.swap(arr, i, k);
            getPermutations2(arr, k + 1);
            java.util.Collections.swap(arr, k, i);
        }

        // when we iterate to the end for a given recursion we have a permutation !
        if (k == arr.size() - 1) {
            System.out.println(java.util.Arrays.toString(arr.toArray()));
        }
    }

    public static void getPermutations(java.util.List<Integer> prefix, java.util.List<Integer> array, Set<java.util.List<Integer>> cache) {
        int n = array.size();
        if (n == 0) {
            cache.add(prefix); //got one !
        } else {
            for (int i = 0; i < n; i++) {
                java.util.List<Integer> array2 = new ArrayList<Integer>();
                array2.addAll(array.subList(0, i));//exclude i
                array2.addAll(array.subList(i + 1, n));//exclude n

                List<Integer> prefix2 = new ArrayList<Integer>();
                prefix2.addAll(prefix);
                prefix2.add(array.get(i)); //include i
                getPermutations(prefix2, array2, cache); //recursion inside loop for fixed i
            }
        }
    }

    // all contiguous sub arrays
    public static void getSubArrays(Integer[] array, Set<java.util.List<Integer>> cache) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = i + 1; j <= array.length; ++j) {
                cache.add(Arrays.asList(Arrays.copyOfRange(array, i, j)));
            }
        }
    }

    // dynamic programming
    public static int getMaxSubArray(int[] array) {
        int max = array[0];
        int[] sum = new int[array.length];
        sum[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            //new max is current or sum or previous and current
            // A[i] or sum + A[i]
            sum[i] = Math.max(array[i], sum[i - 1] + array[i]);

            // is new sum the new max ?
            max = Math.max(max, sum[i]);
        }

        return max;
    }

    // iterative
    public static int getMaxSubArray2(Integer[] array) {
        Set<java.util.List<Integer>> cache = new HashSet<java.util.List<Integer>>();

        getSubArrays(array, cache);

        int sum = 0, max = 0;
        for (List<Integer> a : cache) {
            sum = 0;
            for (int i : a) {
                sum += i;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}