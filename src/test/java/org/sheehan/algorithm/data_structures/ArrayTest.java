package org.sheehan.algorithm.data_structures;

import org.junit.Test;
import org.sheehan.algorithm.data_structures.Array;

import java.util.*;
import java.util.List;

public class ArrayTest {

    @Test
    public void testFindLongestRun() throws Exception {

        Integer array[] = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 7, 8, 9, 10, 10};

        Array.findLongestRun(array);

        Integer array2[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 7, 8, 9, 10, 10};

        Array.findLongestRun(array2);

        Integer array3[] = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        Array.findLongestRun(array3);

        Double array4[] = {3.3, 1.1, 3.3, 4.4, 5.5, 7.7, 7.7, 7.7, 8.8};

        Array.findLongestRun(array4);
    }

    @Test
    public void testRotateArray() {
        Integer array[] = Array.createArray(20, 100, true);

        Array.print(array);
        Array.rotateArray(array, 5);

        Array.print(array);
    }

    @Test
    public void testMergeSortedArrays() {
        Integer array1[] = Array.createArray(20, 100, true);
        Integer array2[] = Array.createArray(20, 100, true);
        Array.print(array1);
        Array.print(array2);
        Comparable merged[] = Array.mergeSortedArrays(array1, array2);

        Array.print(merged);
    }

    @Test
    public void testPermutationOfIntegers2() {
        java.util.List<Integer> prefix = new ArrayList<Integer>();

        java.util.List<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);

        Set<java.util.List<Integer>> cache = new HashSet<java.util.List<Integer>>();
        Array.getPermutations2(array, 0);
    }

    @Test
    public void testPermutationOfIntegers() {
        java.util.List<Integer> prefix = new ArrayList<Integer>();

        java.util.List<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);

        Set<java.util.List<Integer>> cache = new HashSet<java.util.List<Integer>>();
        Array.getPermutations(prefix, array, cache);

        for (List<Integer> a : cache) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testSubArraysOfIntegers() {
        Integer array[] = {1, 2, 3};
        Set<java.util.List<Integer>> cache = new HashSet<java.util.List<Integer>>();

        Array.getSubArrays(array, cache);

        for (List<Integer> a : cache) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testMaxSubArrayOfIntegers() {
        int array[] = {1, -2, -6, 3, 5};

        System.out.println(Array.getMaxSubArray(array));

    }

    @Test
    public void testMaxSubArrayOfIntegers2() {
        Integer array[] = {1, -2, -6, 3, 5};

        System.out.println(Array.getMaxSubArray2(array));

    }
}