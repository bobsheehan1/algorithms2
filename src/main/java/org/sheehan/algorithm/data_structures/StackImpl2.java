package org.sheehan.algorithm.data_structures;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;


/**
 * Created by bob on 5/25/14.
 */
public class StackImpl2<T extends Comparable<T>>  implements Stack<T> {

    List<T> list = new ListImpl<>();

    @Override
    public T pop() {
        List.Node<T> node = list.deleteBack();
        if (node != null)
            return node.value;
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public void push(T value) {
        list.appendBack(value);

    }

    @Override
    public void print() {
        list.print();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public T[] toArray() {
        return null;
    }
}
