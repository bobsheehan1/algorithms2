package org.sheehan.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryHeapTest {

    @Test
    public void testMaxHeap() throws Exception {
        BinaryHeap<Integer> tree = new BinaryHeap<>(10, BinaryHeap.HeapType.MAX_HEAP);

        for (int i = 0; i < 6; ++i)
            tree.add(i);

        tree.print(0);

        System.out.println();

        tree.add(50);
        tree.add(-50);


        Integer value;
        while ((value = tree.poll()) != null) {
            System.out.println("top priority: " + value);
        }

    }

    @Test
    public void testMinHeap() throws Exception {
        BinaryHeap<Integer> tree = new BinaryHeap<>(10, BinaryHeap.HeapType.MIN_HEAP);

        for (int i = 0; i < 6; ++i)
            tree.add(i);

        tree.print(0);

        System.out.println();

        tree.add(50);
        tree.add(-50);


        Integer value;
        while ((value = tree.poll()) != null) {
            System.out.println("top priority: " + value);
        }

    }

    @Test
    public void testBuildHeap() {

        BinaryHeap<Integer> tree = new BinaryHeap<>(10, BinaryHeap.HeapType.MIN_HEAP);
        Integer array[] = {4,6,2,8,-5,-6,-66, 55};
        tree.buildHeap(array);
        Integer value;
        while ((value = tree.poll()) != null) {
            System.out.println("top priority: " + value);
        }


    }
}