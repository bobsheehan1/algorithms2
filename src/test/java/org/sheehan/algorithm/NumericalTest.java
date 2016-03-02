package org.sheehan.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by bob on 2/27/16.
 */
public class NumericalTest {

    @Test
    public void testGcd(){
        System.out.println(Numerical.gcd(5,15));
        System.out.println(Numerical.gcd(32,12));
    }

    @Test
    public void testFactors(){
        List<Integer> factors = new ArrayList<Integer>();
        Numerical.getFactors(20, factors);
        System.out.println(factors);
    }

    @Test
    public void testGetPrimes(){
        Numerical.getPrimes(1000);

    }
}