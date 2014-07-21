package org.sheehan.algorithm.data_structures;

import java.util.Iterator;

/**
 * Created by bob on 7/6/14.
 */
public interface List<T> extends Iterable<T> {
    void append (T value);

    //brute force
    void reverse1();

    void reverse2();

    void print();

    int size();

    void introduceCycleForTest();

    boolean hasCycle();

    // This solution is "Floyd's Cycle-Finding Algorithm"
    // as published in "Non-deterministic Algorithms" by Robert W. Floyd in 1967.
    // It is also called "The Tortoise and the Hare Algorithm".
    ListImpl.Node hasCycle2();

    int countCycle(ListImpl.Node cycleStart);
}
