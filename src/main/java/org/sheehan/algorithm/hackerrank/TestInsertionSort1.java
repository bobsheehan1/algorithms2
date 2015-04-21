package org.sheehan.algorithm.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestInsertionSort1 {



    public static void insertIntoSorted(int[] ar) {

        int v = ar[ar.length-1];
        ar[ar.length-1]= Integer.MAX_VALUE;

        int i=ar.length-1;
        for (i=ar.length-1; i > 0; --i){
            if (v < ar[i-1]) {
                ar[i] = ar[i - 1];
                printArray(ar);
            } else {
                ar[i] = v;
                printArray(ar);
                break;
            }
        }

        if (i == 0){
            ar[i] = v;
            printArray(ar);
        }
    }


    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

}