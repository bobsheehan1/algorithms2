package org.sheehan.algorithm;

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
        return val *factorial(val-1);
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
}
