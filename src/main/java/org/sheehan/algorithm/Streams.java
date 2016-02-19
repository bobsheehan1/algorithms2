package org.sheehan.algorithm;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bsheehan on 2/16/16.
 */
public class Streams {

    public static void evenSquares(List<Integer> numbers) {


        List<Integer> twoEvenSquares =
                numbers.stream()
                        .filter(n -> {
                            System.out.println("filtering " + n);
                            return n % 2 == 0;
                        })
                        .map(n -> {
                            System.out.println("mapping " + n);
                            return n * n;
                        })
                        .limit(2)
                        .collect(Collectors.toList());
    }

}
