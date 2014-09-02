package org.sheehan.algorithm;

import org.junit.Test;
import org.sheehan.algorithm.Bits;

public class BitsTest {

    @Test
    public void testPrintInt() throws Exception {
        Bits.printInt(12);
        System.out.println("cnt 1's: " + Bits.countOnes(12));
    }
}