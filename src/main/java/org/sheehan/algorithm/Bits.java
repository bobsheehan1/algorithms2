package org.sheehan.algorithm;

/**
 * Created by bob on 8/30/14.
 */
public class Bits {

    static int MASK_32_BIT = 0x80000000;

    static void printBinary(int number){
        long number2 = number  & 0x00000000FFFFFFFFL;
        printBinary(number2);

    }
    public static void printBinary(long number){

        // The unsigned right shift operator ">>>" shifts a zero into the leftmost position, while the leftmost position after ">>" depends on sign extension.
        long cnt = 0;
        for (int MASK = MASK_32_BIT; MASK != 0; MASK >>>= 1)
        {
            int bit = (int)(number & MASK);
            bit >>>= (31-cnt);
            if (cnt > 0 && cnt%8 == 0)
                System.out.print(" ");
            System.out.print(bit & 0x00000000FFFFFFFFL);
            cnt++;
        }
        System.out.println();

    }

    static void printBinary2(long number){

        // The unsigned right shift operator ">>>" shifts a zero into the leftmost position, while the leftmost position after ">>" depends on sign extension.

        for (int i = 0; i < 32; i++)
        {
            if (i > 0 && i%8 == 0)
                System.out.print(" ");

            int mask = 1 << (31-i);
            if (((int)(number&mask)& 0x00000000FFFFFFFFL) > 0)
                System.out.print(1);
            else
                System.out.print(0);




        }
        System.out.println();

    }

    static int countOnes(int number){

        //System.out.println(Integer.toBinaryString(number));

        // Integer.SIZE = 32 bit -------- -------- -------- -------- 80 00 00 00


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

    public static long flipBits(long number) {
        // The unsigned right shift operator ">>>" shifts a zero into the leftmost position, while the leftmost position after ">>" depends on sign extension.


        for (int MASK = MASK_32_BIT; MASK != 0; MASK >>>= 1)
        {
            number ^= MASK; //XOR with 1 ==> 0^1=1   1^1=0   where the rt. lhs 1 is the mask
         }

        return number & 0x00000000FFFFFFFFL;
    }

    public static long flipBits2(long number) {
        // The unsigned right shift operator ">>>" shifts a zero into the leftmost position, while the leftmost position after ">>" depends on sign extension.


        for (int i = 0; i < 32; i++)
        {
            int mask = 1 << (31-i);
            number ^= mask; //XOR with 1 ==> 0^1=1   1^1=0   where the rt. lhs 1 is the mask
        }

        return number & 0x00000000FFFFFFFFL;
    }
}
