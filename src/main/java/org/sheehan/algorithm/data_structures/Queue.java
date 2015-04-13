package org.sheehan.algorithm.data_structures;

/**
 * Created by bob on 5/26/14.
 */
public interface Queue<T extends Comparable<T>> extends Comparable<Queue<T>> {
    void add(T value);
    T remove();
    T peek();
    void print();
    void printArray();


}
