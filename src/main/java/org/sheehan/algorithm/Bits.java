package org.sheehan.algorithm;

/**
 * Created by bob on 8/30/14.
 */
public class Bits {
    static final int MASK_32_BIT = 0x80000000;
    //static final long MASK_64_BIT = 0x8000000000000000L;


    static void printBinary(long number){
        int index = 0;
        for (int MASK = MASK_32_BIT; MASK != 0; MASK >>>= 1)
        {
            int bit = ((int)number & MASK) >>> (31-index);
            if (index++%8==0 && index!=0)
                System.out.print(" ");
            System.out.print(bit);
        }
        System.out.println();
    }

    static int flipBits(long number){
        for (int MASK = MASK_32_BIT; MASK != 0; MASK >>>= 1) {
            number = number ^ MASK;
        }
        return (int)number;
    }

    static long countOnes(int number){
        int cnt = 0;
        for (int MASK = MASK_32_BIT; MASK != 0; MASK >>>= 1)
        {
            int bit = (int)(number & MASK);
            if (bit != 0)
                cnt++;
        }
        return cnt;

    }
}
