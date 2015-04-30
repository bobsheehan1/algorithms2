package org.sheehan.algorithm;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 6/27/14
 * Time: 11:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class Strings {

    public static String reverse(String str) {
        char[] buffer = str.toCharArray();
        return reverse(buffer, 0, buffer.length-1);
    }

    public static String reverse(char[] buffer, int start, int end) {

        final int length = end-start+1;
        final int pivot = start + length/2;

        for (int i = start, cnt = 0; i < pivot; ++i, ++cnt){
            char c = buffer[i];
            buffer[i] = buffer[end - cnt];
            buffer[end - cnt] = c;
        }
        return new String(buffer);
    }

    static String reverseWords(String str){
        int start = 0;
        int end = 0;
        char[] buffer = str.toCharArray();
        for (int i = 0; i < str.length(); i++){
            if (str.toCharArray()[i] == ' ') {
                end = i-1;
                reverse(buffer, start, end);
                start = end+2;
            } else if (i == str.length()-1) {
                end = i;
                reverse(buffer, start, end);
            }
        }
        return new String(buffer);
    }


    public static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() <= 1) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);
    }



    public static void getPermutations(String prefix, String str, Set<String> cache) {
        //System.out.println("\tpermutation pre:" + prefix + " str:" + str + " level:" + level);
        int n = str.length();
        if (n == 0) {
            //System.out.println("\tEND permutation pre:" + prefix + " str:" + str + " level:" + level);
            //System.out.println();
            //System.out.println(prefix);
            cache.add(prefix);
        }
        else {
            for (int i = 0; i < n; i++) {
                //System.out.println("\t\tloop in  i:" + i + " pre:" + prefix + " str:" + str + " level:" + level);
                //String prefix2 = prefix + str.charAt(i);
                //String str2 = str.substring(0, i) + str.substring(i + 1, n);
                //System.out.println("\t\tloop out i:" + i + " pre:" + prefix2 + " str:" + str2 + " level:" + level);

                getPermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), cache);
            }
        }
    }


    // start with k = 0
    //  swap i and k
    // inorder recursion k+1
    // swap k with i
    public static void getPermutations2(java.util.List<Character> arr, int k, Set<String> cache) {

        //loop of recursions !
        for (int i = k; i < arr.size(); i++) {
            java.util.Collections.swap(arr, i, k);
            getPermutations2(arr, k + 1, cache);
            java.util.Collections.swap(arr, k, i);
        }

        // when we iterate to the end for a given recursion we have a permutation !
        if (k == arr.size() - 1) {
            Character[] cArr = (Character[])arr.toArray(new Character[0]);
            char str[] = new char[cArr.length];
            int i = 0;
            for (Character c : cArr)
                str[i++] = c;
            cache.add(new String(str));
            //System.out.println(java.util.Arrays.toString(arr.toArray()));
        }
    }

    public static boolean isRotation(String str1, String str2){
        if (str1.length() != str2.length())
            return false;

        if ((str1+str1).contains(str2))
            return true;

        return false;
    }

    public static int decStr2Int(String str){
        return -1;
    }



    public static int binStr2Int(String str)
    {
        boolean negative = false;
        if (str.charAt(0) == '-')
            negative = true;

        int sum = 0;
        int multiplier = 1;
        if (!negative) {
            for (int pos = str.length() - 1; pos >= 0; pos--) {
                sum += (str.charAt(pos) - '0') * multiplier;
                multiplier *= 10;
            }
        } else{
            for (int pos = str.length() - 1; pos > 0; pos--) {
                //char to digit
                sum += (str.charAt(pos) - '0') * multiplier;
                multiplier *= 10;
            }
            sum*=-1;
        }
        return sum;
    }

    public static String decInt2Str(int number)
    {
        StringBuffer buffer = new StringBuffer();
        if (number < 0)
            buffer.append("-");

        // figure out the length of the number
        int length = 0;
        int temp = number;
        while (temp/10 != 0){
            temp = temp/10;
            length++;
        }
        System.out.println(length);

        // starting at LEFT MSB end (using calculated length)
        // break off each digit and add to string buffer
        for (int i = length; i >= 0; --i){

            // create sub integer up to ith position from left
            // 1234 -> 1 (1000)
            // 1234 -> 12 (100)
            // 1234 -> 123 (10)
            // 1234 -> 1234 (1)
            int left_prefix = number/(int)Math.pow(10, i);

            // shave off the 10's position off leftish sub int
            int digit = left_prefix%10;
            buffer.append((char)(digit +'0')); //digit to char
        }

        return buffer.toString();
    }

    public static Character getFirstNonRepeatingChar(String str) {
        char[] chars = str.toCharArray();

        Map<Character,Integer> map = new HashMap<>();
        for (char c:chars) {
            if (map.get(c) == null)
                map.put(c, 1);
            else {
                 map.replace(c,map.get(c) + 1);
            }
        }

        for (char c:chars){
            if (map.get(c)==1)
                return c;
        }

        return null;
    }

    // brute force
    public static Set<Character> findDuplicatesBrute(String str) {

        char[] chars = str.toCharArray();

        Set<Character> duplicates = new HashSet<Character>();

        for (int i=0; i < str.length(); ++i) {
            for (int j=0; j < str.length(); ++j) {
                if (i != j && chars[i] == chars[j]) {
                    duplicates.add(chars[i]);
                }
            }
        }

        return duplicates;
    }

    //ASCII
    public static Set<Character> findDuplicates(String str) {

        char[] chars = str.toCharArray();

        int checker = 0; //init or use array of 256 for ASCII

        Set<Character> duplicates = new HashSet<Character>();

        for (char s:chars){
            int mask = 1 << (s-'a');
            if ((checker & mask) > 0) {
                duplicates.add(s);
            }else{
                checker |= mask;
            }
        }
        return duplicates;
    }

    //ASCII
    public static Set<Character> findDuplicatesSet(String str) {
        char[] chars = str.toCharArray();

        //List inputList = Arrays.asList(str);
        //Set inputSet = new HashSet(inputList);

        Set<Character> duplicates = new HashSet<Character>();
        Set<Character> set1 = new HashSet<>();
        for (char c : chars){
            if (!set1.add(c))
                duplicates.add(c);
        }


        return duplicates;


    }

    // removes duplicates
    // reset array skipping dupes
    public static String removeDuplicates(String str) {
        char[] chars = str.toCharArray();

        int checker = 0; //init

        int dst = 0;
        for (int i = 0; i < chars.length; ++i) {
            int mask = 1 << (chars[i]-'a');
            // not a duplicate so remove from array and increment
            if ((checker & mask) == 0) {
                chars[dst++] = chars[i];
            }
            checker |= mask;
        }
        chars[dst] = 0;

        return new String(chars, 0, dst);

    }
    
}
