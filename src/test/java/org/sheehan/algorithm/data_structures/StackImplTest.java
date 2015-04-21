package org.sheehan.algorithm.data_structures;

import junit.framework.TestCase;
import org.sheehan.algorithm.data_structures.Stack;
import org.sheehan.algorithm.data_structures.StackImpl;

public class StackImplTest extends TestCase {

    public void testPushPop() throws Exception {
        int size = 10;
        Stack<Integer> stack = new StackImpl<>(size);
        for (int i = 0; i < size; ++i){
            stack.push(i);
            stack.print();
        }

        for (int i = 0; i  < size; ++i){
            stack.pop();
            stack.print();
        }
    }

    public void testPop() throws Exception {

    }
}