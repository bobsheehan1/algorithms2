package org.sheehan.algorithm;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;


/**
 * Created by bob on 5/25/14.
 */
public class StackImpl<T> implements Stack<T> {
    private int top;
    private int size;
    private T array[];

    public StackImpl(int size) {
        this.top = -1;
        this.size = size;
        array = (T[])Array.newInstance(Object.class, size);
    }

    @Override
    public void push (T value) {
        if (top == this.size)
            throw new NoSuchElementException();
        array[++top] = value;
    }

    @Override
    public T pop () {
        if (top == -1)
            throw new NoSuchElementException();
        T value =  array[top--];

        return value;
    }

    @Override
    public T peek() {
        return array[top];
    }

    @Override
    public void print() {
        for (int i = 0; i <= this.top; ++i){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
