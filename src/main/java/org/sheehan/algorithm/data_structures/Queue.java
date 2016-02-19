package org.sheehan.algorithm.data_structures;

/**
 * Created by bob on 5/26/14.
 */
public interface Queue<T extends Comparable<T>> extends Comparable<Queue<T>> {
    void enqueue(T value);
    T dequeue();
    T peek();
    void print();
    void printArray();


}
