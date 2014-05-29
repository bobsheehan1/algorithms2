package org.sheehan.algorithm;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 5/20/14
 * Time: 1:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecursionTest {
    @Test
    public void testFactorial() throws Exception {
        Assert.assertEquals(24, Recursion.factorial(4));
    }

    @Test
    public void testFibonocci() throws Exception {
        Assert.assertEquals(5, Recursion.fibonocci(5));
    }
}
