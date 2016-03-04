package org.sheehan.algorithm.data_structures;

import org.junit.Assert;
import org.junit.Test;
import org.sheehan.algorithm.Array;
import org.sheehan.algorithm.sort.SortList;

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

        Assert.assertArrayEquals(array1, array2);
    }

    @Test
    public void testReverse() throws Exception {

        List<Integer> list = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list.appendBack(i);
        list.print();

        list.reverse();
        list.print();
        list.reverse();
        list.print();

        list.reverseBrute();
        list.print();
        list.reverseBrute();
        list.print();

        list.reverseStack();
        list.print();
        list.reverseStack();
        list.print();

    }

    @Test
    public void testInsertInOrder() throws Exception {

        Integer array1[] = Array.createArray(20, 100, false);

        List<Integer> list = new ListImpl<Integer>();

        for (int arr_i: array1)
            list.insertInOrder(arr_i);


        list.print();

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

        Assert.assertArrayEquals(array1, array2);
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

        for (int i = 9; i >= 0; i--)
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
        System.out.println(deleted.data);
        list.print();
        deleted = list.deleteBack();
        System.out.println(deleted.data);
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

    @Test
    public void testOrderedSubList() {
        List<Integer> list1 = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list1.appendBack(i);

        List<Integer> list2 = new ListImpl<Integer>();
        for (int i = 0; i < 2; i++)
            list2.appendBack(i);

        assertTrue(list1.orderedElementsFound(list2));

        List<Integer> list3 = new ListImpl<Integer>();
        for (int i = 0; i < 10; i++)
            list3.appendBack(i);

        assertTrue(list1.orderedElementsFound(list3));

        List<Integer> list4 = new ListImpl<Integer>();

        list4.appendBack(10);

        assertFalse(list1.orderedElementsFound(list4));

    }

    @Test
    public void testInsertionSortList() throws Exception {
        Integer array[] = Array.createArray(10,10, true);
        ListImpl<Integer> list = new ListImpl<>();
        list.appendBack(5);
        list.appendBack(10);
        list.appendBack(3);
        list.appendBack(7);
        list.appendBack(1);

        list.print();


        ListImpl.insertionSort(list);
        list.print();


        System.out.println();

    }

    @Test
    public void testSelectionSortList() throws Exception {

        ListImpl<Integer> list = new ListImpl<>();
        list.appendBack(5);
        list.appendBack(10);
        list.appendBack(3);
        list.appendBack(7);
        list.appendBack(1);

        list.print();

        ListImpl.selectionSort(list);
        list.print();

        System.out.println();
    }

    @Test
    public void testSwapPairs() throws Exception {

        ListImpl<Integer> list = new ListImpl<>();
        list.appendBack(5);
        list.appendBack(10);
        list.appendBack(3);
        list.appendBack(7);
        list.appendBack(1);

        list.print();

        ListImpl.swapPairs(list);
        list.print();

        System.out.println();
    }
}
