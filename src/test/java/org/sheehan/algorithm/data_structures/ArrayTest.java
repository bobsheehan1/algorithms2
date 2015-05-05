package org.sheehan.algorithm.data_structures;

import org.junit.Assert;
import org.junit.Test;
import org.sheehan.algorithm.data_structures.Array;

import java.util.*;
import java.util.List;

public class ArrayTest {

    @Test
    public void testFindLongestRun() throws Exception {

        Integer array[] = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 7, 8, 9, 10, 10};

        Assert.assertEquals(4, Array.findLongestRun(array).intValue());


        Integer array2[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 7, 8, 9, 10, 10};

        Assert.assertEquals(1, Array.findLongestRun(array2).intValue());

        Integer array3[] = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        Assert.assertEquals(10, Array.findLongestRun(array3).intValue());

        Double array4[] = {3.3, 1.1, 3.3, 4.4, 5.5, 7.7, 7.7, 7.7, 8.8};

        Assert.assertEquals(7.7f, Array.findLongestRun(array4).floatValue(), 0.0);
    }

    @Test
    public void testFindLongestRisingRun() throws Exception {

        Integer array[] = {1, 2, 3, 4, 5, 4, 3, 2, 1};

        Array.print(array);
        Array.findLongestIncreasingRun(array);

        Array.rotateArray(array, 3);
        Array.print(array);
        Array.findLongestIncreasingRun(array);
    }


    @Test
    public void testFindDuplicates() throws Exception {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 4, 5, 5, 5, 6, 6, 7, 8, 9);

        Set<Integer> duplicates = Array.findDuplicates(integers.toArray(new Integer[0]));

        duplicates.forEach((Integer i) -> System.out.print(i + " "));
    }

    @Test
    public void testRemoveDuplicates() throws Exception {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 4, 4, 4, 4,4,4,4, 5, 5, 5, 6, 6, 7, 8, 9);

        Integer[] integers1 = integers.toArray(new Integer[0]);

        Array.removeDuplicates(integers1);

        for (int i: integers1)
            System.out.print(i + " ");
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
    public void testTwoSum() {

        boolean test = false;
        while(!test){
            Integer array1[] = Array.createArray(20, 100, true);


            test = Array.isTwoSum(array1, 80);
            if (test){
                Array.print(array1);
            }
        }


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

    @Test
    public void testReverseInteger() {

        System.out.println(Array.reverseDecInt(1234));
        System.out.println(Array.reverseDecInt(-1234));
    }

}