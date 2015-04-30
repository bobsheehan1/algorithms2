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
        return fibonocci(index-1) + fibonocci(index - 2);
    }

    static int fibonocciIter(int index) {
        if (index < 0)
            throw new RuntimeException("no negative indexes allowed");

        int prev = 0;
        int curr = 1;
        if (index == 0)
            return 0;
        if (index == 1)
            return 1;
        for (int i = 2; i <= index; ++i) {
            int tmp = curr;
            curr = prev + curr;
            prev = tmp;
        }

        return curr;
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

    // using stacks for towers
    static <T extends Comparable<T>> void hanoi2(int n, Stack<T> source, Stack<T> dest, Stack<T> spare)
    {
        if (n == 0)
            return;
        //recursive call 1
        hanoi2(n-1, source, spare, dest);

        // move remaining source to dest
        T disk = source.pop();
        dest.push(disk);
        source.print();
        spare.print();
        dest.print();
        System.out.println();

        //recursive call 2
        hanoi2(n-1, spare, dest, source);
    }
}
