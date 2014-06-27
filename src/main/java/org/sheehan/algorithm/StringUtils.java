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
}
