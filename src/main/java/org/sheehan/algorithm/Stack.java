package org.sheehan.algorithm;

/**
 * Created by bob on 5/26/14.
 */
public interface Stack <T>{
    T pop();

    T peek();

    void push(T value);

    void print();

}
