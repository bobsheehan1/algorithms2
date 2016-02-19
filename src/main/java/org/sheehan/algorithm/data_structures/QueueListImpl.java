package org.sheehan.algorithm.data_structures;

/**
 * Created by bob on 5/26/14.
 *
 * Uses List
 */
public class QueueListImpl<T extends Comparable<T>> implements Queue<T> {

    List<T> list = new ListImpl<>();

    @Override
    public void enqueue(T value) {
        list.appendBack(value);
    }

    @Override
    public T dequeue() {
        List.Node<T> node = list.deleteFront();
        if (node != null)
            return node.data;
        return null;    }

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
