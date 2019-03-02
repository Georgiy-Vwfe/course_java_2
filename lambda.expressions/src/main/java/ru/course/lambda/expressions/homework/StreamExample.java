package ru.course.lambda.expressions.homework;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        String[] strings = {
                "a",
                "aa",
                "123"
        };

        //comparator
        Optional<String> longerString = Stream.of(strings).max((o1, o2) -> Integer.compare(o1.length(), o2.length()));
        //output max length
        System.out.println(longerString.get());

        int[][] ints = {
                {2, 5, 1}, {6, 7, 3}, {9, 8, 4}
        };

        //output sorted array
        Stream.of(ints)
                .flatMap((Function<int[], Stream<?>>) ints1 -> {
                    List<Integer> sortedValues = Arrays.stream(ints1).boxed().sorted().collect(Collectors.toList());
                    return sortedValues.stream();
                })
                .sorted()
                .forEach(System.out::print);

        System.out.println();

        //output line-by-line sorting
        int[][] array = Stream.of(ints)
                .peek(Arrays::sort).toArray(value -> new int[3][3]);

        System.out.println(Arrays.deepToString(array));

        //factorial
        Integer num = 10;
        System.out.println(fact(num));
        System.out.println(factorial(num));
        System.out.println(Stream.of(num)
                .reduce((n, i) -> {
                    int ret = 1;
                    for (i = 1; i <= n; ++i) {
                        ret *= i;
                    }
                    return ret;
                }).orElse(0));
    }

    public static BigInteger fact(Integer of) {
        if (BigInteger.valueOf(of).equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(of).multiply(fact(of - 1));
        }
    }

//    public static BigInteger factorial(int n)
//    {
//        BigInteger ret = BigInteger.ONE;
//        for (int i = 1; i <= n; ++i) {
//            ret = ret.multiply(BigInteger.valueOf(i));
//        }
//        return ret;
//    }

    private static int factorial(int n) {
        int ret = 1;
        for (int i = 1; i <= n; ++i) {
            ret *= i;
        }
        return ret;
    }

}
