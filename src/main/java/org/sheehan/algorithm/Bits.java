package org.sheehan.algorithm;

/**
 * Created by bob on 8/30/14.
 */
public class Bits {

    static int MASK_32_BIT = 0x80000000;


    public static int str2Int(String s) {
        s = s.trim();

        int value = 0;
        for (int i=0; i < s.length(); ++i){

            //convert to int (0 or 1)
            int bit = (int)( s.charAt(s.length()-i-1)-'0');

            // multiply by power of 2
            value += bit * (1 << i);
        }

        return value;
    }

    static void print(int n){

         for (int i = 0; i < 32; i++){
            if ( (n >> (31-i) & 1) == 0 )
                System.out.print("0");
            else
                System.out.print("1");
        }

        System.out.println();
    }

    static int countOnes(int n){

        int cnt = 0;
        for (int i = 0; i < 32; i++){
            if ( (n >> (31-i) & 1) == 1 )
               cnt++;
        }

        return cnt;
    }

    static int flipBits(int n){

        int cnt = 0;
        for (int i = 0; i < 32; i++){
            n ^= 1<<i;
        }

        return n;
    }

    public static void replaceSubstr(int num1, int num2, int i, int j){

        // create a custom mask for i to j and 0 out that range in num1
        int mask = ~0;
        for (int index = i; index <=j; ++index){
            mask ^= (1<<index);
        }
        num1 &= mask;

        // shift the substr to correct position
        num2 <<=i;

        // simply or them together now !
        print(num1|num2);

    }
}
