package org.sheehan.algorithm;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * Created by bob on 5/26/14.
 */
public class QueueImpl<T> implements Queue<T> {

    private int firstIndex = 0;
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
            throw new RuntimeException("Full Queue");
        array[(firstIndex + count)%size] = value;
        count++;
    }

    @Override
    public T remove() {
        if (count == 0)
            throw new RuntimeException("Empty Queue");
        T value = array[(firstIndex + --count)%size];

        firstIndex++;
        firstIndex %=size;
        return value;
    }

    @Override
    public T peek() {
        if (firstIndex == -1)
            throw new NoSuchElementException();
        return array[firstIndex];
    }

    @Override
    public void print() {
        for (int i = firstIndex; i < firstIndex + count; ++i){
            int index = i%size;
            System.out.print(array[index] + " ");
        }
        System.out.println();
    }

    public void printArray() {
        System.out.print("raw array ");
        for (int i = 0; i < size; ++i){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
