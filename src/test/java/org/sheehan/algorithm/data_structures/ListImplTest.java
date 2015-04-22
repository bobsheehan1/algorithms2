package org.sheehan.algorithm.data_structures;

import org.junit.Assert;
import org.junit.Test;
import org.sheehan.algorithm.data_structures.List;
import org.sheehan.algorithm.data_structures.ListImpl;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListImplTest {

    @Test
    public void testAppend() throws Exception {
        List<Integer> list = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list.append(i);
        Integer array1[] = new Integer[list.size()];
        list.toArray(array1);

        list.print();

        list.reverse2();
        list.reverse2();

        Integer array2[] = new Integer[list.size()];
        list.toArray(array2);

        Assert.assertArrayEquals(array1,array2);
    }

    @Test
    public void testDelete() throws Exception {
        List<Integer> list = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list.append(i);

        for (int i = 0; i < 10; i++)
            list.delete(i);

        Assert.assertTrue(list.size() == 0);
        for (int i = 0; i < 10; i++)
            list.append(i);

        for (int i = 9; i >=0; i--)
            list.delete(i);

        Assert.assertTrue(list.size() == 0);
    }


    @Test
    public void testCycle() {
        List<Integer> list = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list.append(i);

        assertFalse(list.hasCycle());
        ListImpl.Node cycleStart = list.hasCycle2();
        assertFalse(cycleStart != null);

        list.print();

        list.introduceCycleForTest();

        assertTrue(list.hasCycle());
        cycleStart = list.hasCycle2();
        assertTrue(cycleStart != null);
        int cycleSize = list.countCycle(cycleStart);
        System.out.println("Cycle Size: " + cycleSize);
    }
}