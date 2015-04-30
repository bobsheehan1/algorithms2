package org.sheehan.algorithm.data_structures;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListImplTest {

    @Test
    public void testAppendBack() throws Exception {
        List<Integer> list = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list.appendBack(i);
        Integer array1[] = new Integer[list.size()];
        list.toArray(array1);

        list.print();

        list.reverse();
        list.print();
        list.reverse();
        list.print();

        Integer array2[] = new Integer[list.size()];
        list.toArray(array2);

        Assert.assertArrayEquals(array1,array2);
    }

    @Test
    public void testAppendFront() throws Exception {
        List<Integer> list = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list.appendFront(i);
        Integer array1[] = new Integer[list.size()];
        list.toArray(array1);

        list.print();

        list.reverse();
        list.print();
        list.reverse();
        list.print();

        Integer array2[] = new Integer[list.size()];
        list.toArray(array2);

        Assert.assertArrayEquals(array1,array2);
    }


    @Test
    public void testDelete() throws Exception {
        List<Integer> list = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list.appendBack(i);

        for (int i = 0; i < 10; i++)
            list.delete(i);

        Assert.assertTrue(list.size() == 0);
        for (int i = 0; i < 10; i++)
            list.appendBack(i);
        list.print();

        for (int i = 9; i >=0; i--)
            list.delete(i);
        list.print();
        Assert.assertTrue(list.size() == 0);
    }

    @Test
    public void testDeleteFrontBack() throws Exception {
        List<Integer> list = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list.appendBack(i);

        list.print();
        ;
        List.Node<Integer> deleted = list.deleteFront();
        System.out.println(deleted.value);
        list.print();
        deleted = list.deleteBack();
        System.out.println(deleted.value);
        list.print();
    }



    @Test
    public void testCycle() {
        List<Integer> list = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list.appendBack(i);

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