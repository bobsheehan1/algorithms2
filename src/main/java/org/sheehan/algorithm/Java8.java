package org.sheehan.algorithm;

import java.util.List;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

/**
 * Created by bsheehan on 2/16/16.
 */
public class Java8 {

    public static List<Integer> evenSquares(List<Integer> numbers, IntPredicate filterOp, IntFunction<Integer> mapOp) {

        return numbers.stream()
                .filter(n -> {
                    System.out.println("filtering " + n);
                    return filterOp.test(n);
                })
                .map(n -> {
                    System.out.println("mapping " + n);
                    return mapOp.apply(n);
                })
                .limit(2)
                .collect(Collectors.toList());
    }

}
