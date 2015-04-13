package org.sheehan.algorithm;

import org.junit.Test;
import org.sheehan.algorithm.data_structures.List;
import org.sheehan.algorithm.data_structures.ListImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListImplTest {

    @Test
    public void testAppend() throws Exception {
        List<Integer> list = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list.append(i);

        list.print();

        //list.reverse1();

        //list.print();

        list.reverse2();

        list.print();

    }

    @Test
    public void testDelete() throws Exception {
        List<Integer> list = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list.append(i);

        list.print();

        list.delete(5);
        list.print();
        list.delete(9);
        list.print();

        list.delete(0);
        list.print();



    }


    @Test
    public void testCycle() {
        List<Integer> list = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list.append(i);

        assertFalse(list.hasCycle() );
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