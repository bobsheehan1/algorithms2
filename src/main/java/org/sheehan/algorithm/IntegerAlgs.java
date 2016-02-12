package org.sheehan.algorithm;

/**
 * Created by bsheehan on 2/12/16.
 */
public class IntegerAlgs {
    public static int reverseDecInt(int n){

        int length = 0;

        int mult = 1;
        while (n/mult != 0)
        {
            length++;
            mult *= 10;
        }

        mult = 1;
        int reverse = 0;
        for (int i = length-1; i >= 0; --i){
            mult = (int)(Math.pow(10, i));
            int val = n/mult;
            val %= 10;

            mult = (int)(Math.pow(10, length-1-i));
            reverse += val*mult;
        }

        return reverse;
    }

    public static int reverseDecInt2(int n){

        int length = 0;

        int mult = 1;
        while(n/mult != 0) {
            length++;
            mult *=10;
        }

        int n_reverse=0;
        for (int i = 0; i < length; ++i){
            int digit = n/(int)Math.pow(10,length-1-i);
            digit %=10;

            int mult2 = (int)Math.pow(10,i);
            n_reverse += digit*mult2;
        }

        return n_reverse;
    }

}
