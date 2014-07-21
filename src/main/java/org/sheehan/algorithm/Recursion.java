package org.sheehan.algorithm;

import org.sheehan.algorithm.data_structures.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 5/20/14
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Recursion {

    static int factorial (int val){
        if (val == 0)
            return 1;
        return val*factorial(val-1);
    }

    static int fibonocci(int index) {
        if (index < 0)
            throw new RuntimeException("no negative indexes allowed");
        if (index == 0)
            return 0;
        if (index == 1)
            return 1;
        return fibonocci(index-1) + fibonocci(index-2);
    }

    // basic
    static void hanoi(int n, char source, char dest, char between)
    {
        if (n == 0)
            return;
        hanoi(n-1, source, between, dest);
        System.out.println("Move " + n + " from " + source + " to " + dest) ;
        hanoi(n-1, between, dest, source);
    }

    static <T> void hanoi2(int n, Stack<T> source, Stack<T> dest, Stack<T> spare)
    {
        if (n == 0)
            return;

        hanoi2(n-1, source, spare, dest);
        T disk = source.pop();
        dest.push(disk);
        source.print();
        spare.print();
        dest.print();
        System.out.println();
        hanoi2(n-1, spare, dest, source);
    }
}
