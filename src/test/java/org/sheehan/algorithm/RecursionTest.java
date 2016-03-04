package org.sheehan.algorithm;

import junit.framework.Assert;
import org.junit.Test;
import org.sheehan.algorithm.data_structures.Stack;
import org.sheehan.algorithm.data_structures.StackArrayImpl;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 5/20/14
 * Time: 1:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecursionTest {
    @Test
    public void testFactorial() throws Exception {
        Assert.assertEquals(24, Recursion.factorial(4));
    }

    @Test
    public void testFibonocci() throws Exception {
        Assert.assertEquals(5, Recursion.fibonocci(5));
        Assert.assertEquals(5, Recursion.fibonocciIter(5));
        Assert.assertEquals(8, Recursion.fibonocci(6));
        Assert.assertEquals(8, Recursion.fibonocciIter(6));


    }

    @Test
    public void testHanoi() {
        Recursion.hanoi(3, 'A', 'C', 'B');
    }

    @Test
    public void testHanoi2() {
        int size = 3;
        Stack<Integer> source = new StackArrayImpl<>(size, "A");
        Stack<Integer> dest = new StackArrayImpl<>(size, "C");
        Stack<Integer> spare = new StackArrayImpl<>(size, "B");

        for (int i = 0; i < size; ++i)
            source.push(size-i-1);

        source.print();
        spare.print();
        dest.print();

        Recursion.hanoi2(size, source, dest, spare);
    }
}
