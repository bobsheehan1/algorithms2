package org.sheehan.algorithm;

import org.junit.Test;
import org.sheehan.algorithm.sort.Sort;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ArrayTest {

    @Test
    public void testFindLongestRun() throws Exception {

       Integer array[] = {1,2,2,3,3,3,4,4,4,4,4,4,5,5,5,5,6,7,8,9,10,10};

       Array.findLongestRun(array);

        Integer array2[] = {1,1,1,1,1,1,1,1,1,1,1,2,2,3,3,3,4,4,4,4,4,4,5,5,5,5,6,7,8,9,10,10};

        Array.findLongestRun(array2);

        Integer array3[] = {1,2,2,3,3,3,4,4,4,4,4,4,5,5,5,5,6,7,8,9,10,10,10,10,10,10,10,10,10,10};

        Array.findLongestRun(array3);

        Double array4[] = {3.3, 1.1, 3.3, 4.4, 5.5, 7.7, 7.7, 7.7, 8.8};

        Array.findLongestRun(array4);
    }

    @Test
    public void testRotateArray(){
        Integer array[] = Array.createSortedArray(20,100);

        Array.print(array);
        Array.rotateArray(array, 5);

        Array.print(array);
    }
}