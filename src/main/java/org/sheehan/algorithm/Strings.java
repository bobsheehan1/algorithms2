package org.sheehan.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    public static boolean isRotation(String str1, String str2){
        if (str1.length() != str2.length())
            return false;

        if ((str1+str1).contains(str2))
            return true;

        return false;
    }

    public static int strToInt(String str)
    {
        boolean negative = false;
        if (str.charAt(0) == '-')
            negative = true;

        int accumulator = 0;
        int multiplier = 1;
        if (!negative) {
            for (int pos = str.length() - 1; pos >= 0; pos--) {
                accumulator += (str.charAt(pos) - '0') * multiplier;
                multiplier *= 10;
            }
        } else{
            for (int pos = str.length() - 1; pos > 0; pos--) {
                accumulator += (str.charAt(pos) - '0') * multiplier;
                multiplier *= 10;
            }
            accumulator*=-1;
        }
        return accumulator;
    }

    public static String intToStr(int number)
    {
        StringBuffer buffer = new StringBuffer();
        if (number < 0)
            buffer.append("-");

        int length = 0;
        int temp = number;
        while (temp/10 != 0){
            temp = temp/10;
            length++;
        }
        System.out.println(length);
        for (int i = length; i >= 0; --i){
            int position = (int)Math.pow(10, i);
            int value = number/position;
            value = value%10;
            buffer.append((char)(value +'0'));
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
    
}
