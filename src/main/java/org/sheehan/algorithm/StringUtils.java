package org.sheehan.algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 6/27/14
 * Time: 11:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringUtils {

    static String reverse(String str) {
        char[] buffer = str.toCharArray();
        for (int i = 0; i < buffer.length/2; ++i){
            char c = buffer[i];
            buffer[i] = buffer[buffer.length-1-i];
            buffer[buffer.length-1-i] = c;
        }
        return new String(buffer);
    }

    public static void permutation(String str) {
        permutation("", str, 0);
    }

    private static void permutation(String prefix, String str, int level) {
        System.out.println("\tpermutation pre:" + prefix + " str:" + str + " level:" + level);
        int n = str.length();
        if (n == 0) {
             System.out.println("\tEND permutation pre:" + prefix + " str:" + str + " level:" + level);
            System.out.println();
            System.out.println(prefix);
        }
        else {
            for (int i = 0; i < n; i++) {
                System.out.println("\t\tloop in  i:" + i + " pre:" + prefix + " str:" + str + " level:" + level);
                String prefix2 = prefix + str.charAt(i);
                String str2 = str.substring(0, i) + str.substring(i + 1, n);
                System.out.println("\t\tloop out i:" + i + " pre:" + prefix2 + " str:" + str2 + " level:" + level);

                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), level+1);
            }
        }
    }
}
