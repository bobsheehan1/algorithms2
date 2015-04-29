package org.sheehan.algorithm.data_structures;

/**
 * Created by bob on 5/26/14.
 *
 * Uses List
 */
public class QueueImpl2<T extends Comparable<T>> implements Queue<T> {

    List<T> list = new ListImpl<>();

    @Override
    public void add(T value) {
        list.appendBack(value);
    }

    @Override
    public T remove() {
        return list.deleteFront().value;
    }

    @Override
    public T peek() {
        return list.get(list.size()-1);
    }

    @Override
    public void print() {
        list.print();
    }

    @Override
    public void printArray() {

    }

    @Override
    public int compareTo(Queue<T> o) {
        return 0;
    }
}
