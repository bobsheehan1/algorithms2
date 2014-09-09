package org.sheehan.algorithm;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        Assert.assertEquals("olleh", reverseStr);

    }

    @Test
    public void testPermutations() throws Exception {
        String testStr = "ABC";

        StringUtils.permutation(testStr);
    }

    @Test
    public void testIsRotation() throws Exception {
        String testStr1 = "ABC";
        String testStr2 = "BCA";
        assertEquals(true, StringUtils.isRotation(testStr1, testStr2));

        testStr1 = "ABC";
        testStr2 = "CBA";
        assertEquals(false, StringUtils.isRotation(testStr1, testStr2));

    }
}
