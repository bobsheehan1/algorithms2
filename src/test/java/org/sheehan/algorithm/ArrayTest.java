package org.sheehan.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class ArrayTest {

    @Test
    public void testFindLongestRun() throws Exception {

       Integer array[] = {1,2,2,3,3,3,4,4,4,4,4,4,5,5,5,5,6,7,8,9,10,10};

       Array.findLongestRun(array);

        Integer array2[] = {1,1,1,1,1,1,1,1,1,1,1,2,2,3,3,3,4,4,4,4,4,4,5,5,5,5,6,7,8,9,10,10};

        Array.findLongestRun(array2);

        Integer array3[] = {1,2,2,3,3,3,4,4,4,4,4,4,5,5,5,5,6,7,8,9,10,10,10,10,10,10,10,10,10,10};

        Array.findLongestRun(array3);



    }
}