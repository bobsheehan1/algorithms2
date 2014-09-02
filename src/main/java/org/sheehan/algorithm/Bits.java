package org.sheehan.algorithm;

/**
 * Created by bob on 8/30/14.
 */
public class Bits {

    static void printInt(int number){

        System.out.println(Integer.toBinaryString(number));

        // Integer.SIZE = 32 bit -------- -------- -------- -------- 80 00 00 00

        int MASK2 = 0x80000000;
        // == -1 no unsigned int type !!
        // so need != 0 and NOT < 0 !!
        for (int MASK = 0x80000000; MASK != 0; MASK >>>= 1)
        {
            int bit = (int)(number & MASK);
            if (bit == 0)
                System.out.print(0);
            else
                System.out.print(1);
        }
        System.out.println();

    }

    static int countOnes(int number){

        //System.out.println(Integer.toBinaryString(number));

        // Integer.SIZE = 32 bit -------- -------- -------- -------- 80 00 00 00

        int MASK2 = 0x80000000;
        // == -1 no unsigned int type !!
        // so need != 0 and NOT < 0 !!
        int cnt = 0;
        for (int MASK = 0x80000000; MASK != 0; MASK >>>= 1)
        {
            int bit = (int)(number & MASK);
            if (bit != 0)
                cnt++;
        }
        return cnt;

    }
}
