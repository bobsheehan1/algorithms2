package org.sheehan.algorithm;

import junit.framework.Assert;
import org.junit.Test;

public class BitsTest {

    @Test
    public void testReplaceStr() throws Exception {
        int num1 = 0x222222;
        int num2 = 0x7;

        Bits.replaceSubstr(num1, num2, 2, 4 );
    }

        @Test
    public void testPrintInt() throws Exception {
        long number = 0x84208420;
        System.out.println(number);
        Bits.printBinary(number);
        Bits.printBinary2(number);
        long flipped = Bits.flipBits2(number);
        Bits.printBinary(flipped);
        Bits.printBinary2(flipped);
        System.out.println(flipped);
        System.out.println();


        number = 0x80000000;
        System.out.println(number);
        Bits.printBinary(number);
        flipped = Bits.flipBits(number);
        Bits.printBinary(flipped);
        System.out.println(flipped);
        System.out.println();

        number = 0x00000001;
        System.out.println(number);
        Bits.printBinary(number);
        flipped = Bits.flipBits(number);
        Bits.printBinary(flipped);
        System.out.println(flipped);
        System.out.println();

        number = 2147483647;
        System.out.println(number);
        Bits.printBinary(number);
        flipped = Bits.flipBits(number);
        Bits.printBinary(flipped);
        System.out.println(flipped);
        System.out.println();

        long expected = 2147483648L;
        Assert.assertEquals(expected, flipped);

        number = 0x00000000;
        System.out.println(number);
        Bits.printBinary(number);
        flipped = Bits.flipBits(number);
        Bits.printBinary(flipped);
        System.out.println(flipped);
        System.out.println();

        number = 0xFFFFFFFF;
        System.out.println(number);
        Bits.printBinary(number);
        flipped = Bits.flipBits(number);
        Bits.printBinary(flipped);
        System.out.println(flipped);
        System.out.println();

        //4294967295
        number = 4294967295L;
        System.out.println(number);
        Bits.printBinary(number);
        flipped = Bits.flipBits(number);
        Bits.printBinary(flipped);
        System.out.println(flipped);
        System.out.println();
    }
}