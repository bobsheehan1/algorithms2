package org.sheehan.algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 5/19/14
 * Time: 12:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearch {

    //iterative
    static int binarySearch(Integer array[], int key) {

        int l = 0;
        int u = array.length-1;

        while (l <= u) {
            int m = l + (u-l)/2;
            if (array[m] > key) {
                u = m-1;
            }  else if (array[m] < key) {
                l = m+1;
            }  else
                return m;
        }
        return -1;
    }
}