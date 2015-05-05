package org.sheehan.algorithm.data_structures;

import java.util.Iterator;

/**
 * Created by bob on 7/6/14.
 *
 * REVIEW: ArrayList or LinkedList: http://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist
 *
 */
public interface List<T extends Comparable<T>> extends Iterable<T>{


    class Node <T> {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
    void appendBack(T value);

    //brute force
    void reverseBrute();

    void reverse();
    void reverseRecurse();

    T get(int index);

    void print();

    int size();

    void introduceCycleForTest();

    boolean hasCycle();

    public boolean delete(T value);

    // This solution is "Floyd's Cycle-Finding Algorithm"
    // as published in "Non-deterministic Algorithms" by Robert W. Floyd in 1967.
    // It is also called "The Tortoise and the Hare Algorithm".
    ListImpl.Node hasCycle2();

    int countCycle(ListImpl.Node cycleStart);

    T set(int j, T t);

    void toArray(T[] array);

    Node<T> deleteFront();

    Node<T> deleteBack();

    void appendFront(T t);
}
