package org.sheehan.algorithm;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bsheehan on 2/16/16.
 */
public class StreamsTest extends TestCase {
    @Test
    public void testKnapsack() {


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Streams.evenSquares(numbers);

    }
}