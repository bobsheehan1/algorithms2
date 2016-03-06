package org.sheehan.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bsheehan on 2/12/16.
 */
public class IntegerAlgs {

    public static int reverseInt(int n) {

        long reverse = 0;

        while(n != 0){
            long digit = n%10;
            reverse = reverse*10 + digit;
            n /= 10;
        }

        if (reverse < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (reverse > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int)reverse;
    }

    public static String int2Str(int n) {
        StringBuilder builder = new StringBuilder();

        // Handle negative
        int startPos = 0;
        if (n < 0) {
             n*=-1;
            builder.insert(0, "-");
            startPos = 1;
        }

        while(n != 0){
            long digit = n%10;

            builder.insert(startPos, (char)(digit +'0'));
            n /= 10;
        }

        return builder.toString();
    }

    public static int str2int(String str) {

        str = str.trim();

        int limit = 0;
        boolean negative = false;
        if (str.charAt(0) == '-') {
            negative = true;
            limit = 1;
        }

        long sum = 0;
        long mult = 1;

        for (int pos = str.length() - 1; pos >= limit; pos--) {
            sum += (str.charAt(pos) - '0') * mult;
            mult *= 10;
        }

        if (negative)
            sum *= -1;

        if (sum < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (sum > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int)sum;
    }

    // cool !
    //2^n ===> use each integer 0 to n as mask to build subset
    static public List<List<Integer>> getAllSubsets(int[] array) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int integerUpperLimit = 1 << array.length; // max size of int to generate all ints up to

        //each loop iter adds a subset
        for (int integerCurr = 0; integerCurr < integerUpperLimit; ++integerCurr) {
            List<Integer> subset = new ArrayList<Integer>();

            int i = 0; // reset to index from beginning or array
            int curr = integerCurr; //temp shift variable

            // build the subset
            // got each integer shift through 1's and only add array index if a 1 is found
            while (curr > 0) { // keep shifting the current integer
                if ((curr & 1) > 0) // is current lsb a 1 or 0 ?
                    subset.add(array[i]); // cool if a 1 then that index is added to subset

                // shift int to next 0 or 1 and increment index into array
                curr >>= 1;
                i++;
            }
            result.add(subset); //one subset added
        }
        return result;
    }



//    // 2^n subsets
//    static public ArrayList<ArrayList<Integer>> subsets(int[] array) {
//        if (array == null)
//            return null;
//
//        Arrays.sort(array);
//
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//
//        for (int i = 0; i < array.length; i++) {
//            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
//
//            //get sets that are already in result
//            for (ArrayList<Integer> a : result) {
//                temp.add(new ArrayList<Integer>(a));
//            }
//
//            //add S[i] to existing sets
//            for (ArrayList<Integer> a : temp) {
//                a.add(array[i]);
//            }
//
//            //add S[i] only as a set
//            ArrayList<Integer> single = new ArrayList<Integer>();
//            single.add(array[i]);
//            temp.add(single);
//
//            result.addAll(temp);
//        }
//
//        //add empty set
//        result.add(new ArrayList<Integer>());
//
//        return result;
//    }

}