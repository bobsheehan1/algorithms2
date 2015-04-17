package org.sheehan.algorithm;

import org.junit.Test;
import org.sheehan.algorithm.Bits;

public class BitsTest {

    @Test
    public void testPrintInt() throws Exception {
        int number = 12;
        Bits.printInt(number);
        System.out.println("cnt 1's: " + Bits.countOnes(number));
        int flipped = Bits.flipBits(number);
        Bits.printInt(flipped);
    }
}