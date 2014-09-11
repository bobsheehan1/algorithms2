package org.sheehan.algorithm;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 6/27/14
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringUtilsTest {

    @Test
    public void testReverse() throws Exception {
        String testStr = "hello";

        String reverseStr = StringUtils.reverse(testStr);
        System.out.println(reverseStr);
        Assert.assertEquals("olleh", reverseStr);
    }

    @Test
    public void testReverse2() throws Exception {
        String testStr = "hello there";

        String reverseStr = StringUtils.reverse(testStr.toCharArray(), 6, testStr.length()-1);
        System.out.println(reverseStr);
        Assert.assertEquals("hello ereht", reverseStr);
    }

    @Test
    public void testReverse3() throws Exception {
        String testStr = "hello there";

        String reverseStr = StringUtils.reverseWords(testStr);
        System.out.println(reverseStr);
        Assert.assertEquals("olleh ereht", reverseStr);
    }

    @Test
    public void testPermutations() throws Exception {
        String testStr = "ABC";

        StringUtils.permutation(testStr);
    }

    @Test
    public void testStrToInt() throws Exception {
        System.out.println(StringUtils.strToInt("1234"));
        System.out.println(StringUtils.strToInt("-1234"));
    }
}
