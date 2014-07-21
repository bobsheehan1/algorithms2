package org.sheehan.algorithm;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sheehan.algorithm.sort.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
}
