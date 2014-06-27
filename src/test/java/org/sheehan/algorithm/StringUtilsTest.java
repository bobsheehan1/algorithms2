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
        Assert.assertEquals("olleh", reverseStr);

    }
}
