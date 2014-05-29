package org.sheehan.algorithm;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * Created by bob on 5/26/14.
 */
public class QueueImpl<T> implements Queue<T> {

    private int head = 0;
    private int count = 0;
    private int size;
    private T array[];

    public QueueImpl(int size) {
        this.size = size;
        array = (T[]) Array.newInstance(Object.class, size);
    }

    @Override
    public void add(T value) {
        if (count == size)
            throw new NoSuchElementException();
        array[(head + count)%size] = value;
        count++;
    }

    @Override
    public T remove() {
        if (count == 0)
            throw new NoSuchElementException();
        T value = array[(head + count)%size];
        count--;
        head++;
        head %=size;
        return value;
    }

    @Override
    public T peek() {
        if (head == -1)
            throw new NoSuchElementException();
        return array[head];
    }

    @Override
    public void print() {
        for (int i = head; i < head + count; ++i){
            int index = i%size;
            System.out.print(array[index] + " ");
        }
        System.out.println();
    }
}
