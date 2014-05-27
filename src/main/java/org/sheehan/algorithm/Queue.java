package org.sheehan.algorithm;

/**
 * Created by bob on 5/26/14.
 */
public interface Queue<T> {
    void add(T value);
    T remove();
    T peek();
    void print();

}
