package org.sheehan.algorithm;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sheehan.algorithm.data_structures.Array;
import org.sheehan.algorithm.sort.Sort;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 5/19/14
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testBinarySearch() throws Exception {
        final int limit = 20;
        Random random = new Random();
        List<Integer> dataList = new ArrayList<Integer>();
        for (int i = 0; i < limit; i++) {
            dataList.add(random.nextInt());
        }
        Collections.sort(dataList);
        Integer[] array = dataList.toArray(new Integer[0]);

        for (int i = 0; i < limit; i++) {
            System.out.print(dataList.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < limit; i++)
            Assert.assertEquals(i,BinarySearch.binarySearch(array, array[i]));
    }

    @Test
    public void testBinarySearchBubbleSort() throws Exception {
        final int limit = 20;
        Random random = new Random();
        List<Integer> dataList = new ArrayList<Integer>();
        for (int i = 0; i < limit; i++) {
            dataList.add(random.nextInt());
        }
        Integer[] array = dataList.toArray(new Integer[0]);
        //Collections.sort(dataList);
        Sort.bubbleSort(array);

        for (int i = 0; i < limit; i++) {
            System.out.print(dataList.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < limit; i++)
            Assert.assertEquals(i,BinarySearch.binarySearch(array, array[i]));
    }

    @Test
    public void testBinarySearchInsertionSort() throws Exception {
        final int limit = 20;
        Random random = new Random();
        List<Integer> dataList = new ArrayList<Integer>();
        for (int i = 0; i < limit; i++) {
            dataList.add(random.nextInt());
        }
        Integer[] array = dataList.toArray(new Integer[0]);
        //Collections.sort(dataList);
        Sort.insertionSort(array);

        for (int i = 0; i < limit; i++) {
            System.out.print(dataList.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < limit; i++)
            assertEquals(i,BinarySearch.binarySearch(array, array[i]));
    }

    @Test
    public void testBinarySearchRecursiveInsertionSort() throws Exception {
        final int limit = 20;
        Random random = new Random();
        Set<Integer> dataSet = new HashSet<Integer>();
        for (int i = 0; i < limit; i++) {
            dataSet.add(random.nextInt() % 100);
        }
        Integer[] array = dataSet.toArray(new Integer[0]);
        Sort.insertionSort(array);

        System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < limit; i++)
            assertEquals(i,BinarySearch.binarySearch(array, array[i], 0, array.length-1));
    }

    @Test
    public void testRotatedBinarySearchRecursive() throws Exception {
        Integer[] sortedArray = Array.createSortedArray(20, 100);
        Array.print(sortedArray);
        Array.rotateArray(sortedArray, 5);
        Array.print(sortedArray);
        //System.out.println(sortedArray.length);

        for (int i = 0; i < 20; i++) {
            //System.out.println(i +" " + sortedArray[i]);
            assertEquals(i, BinarySearch.rotatedBinarySearch(sortedArray, sortedArray[i], 0, sortedArray.length - 1));
        }
    }


    @Test
    public void testRotatedBinarySearchRecursive2() throws Exception {
        Integer[] sortedArray = Array.createSortedArray(20, 100);
        Array.print(sortedArray);
        Array.rotateArray(sortedArray, 10);
        Array.print(sortedArray);
        //System.out.println(sortedArray.length);

        for (int i = 0; i < 20; i++) {
            //System.out.println(i +" " + sortedArray[i]);
            assertEquals(i, BinarySearch.rotatedBinarySearch(sortedArray, sortedArray[i], 0, sortedArray.length - 1));
        }
    }
}
