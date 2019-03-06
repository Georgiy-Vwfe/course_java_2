package ru.course.lambda.expressions.homework;

import java.math.BigInteger;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        String[] strings = {
                "a",
                "aa",
                "123"
        };

        //comparator
        Optional<String> longerString = Stream.of(strings).max(Comparator.comparingInt(String::length));
        //output max length
        System.out.println(longerString.get());

        int[][] ints = {
                {2, 5, 1}, {6, 7, 3}, {9, 8, 4}
        };

        //output sorted array
        Stream.of(ints)
                .flatMap((Function<int[], Stream<?>>) ints1 -> {
                    List<Integer> sortedValues = Arrays.stream(ints1).boxed().collect(Collectors.toList());
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
        int num = 10;
        System.out.println(BigFact(num));
        System.out.println(BigNoRecursiveFact(num));
        System.out.println(NoRecursiveFact(num));
        System.out.println(BigStreamedFact(num));
    }

    public static BigInteger BigFact(int n) {
        if (BigInteger.valueOf(n).equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(n).multiply(BigFact(n - 1));
        }
    }

    public static BigInteger BigNoRecursiveFact(int n) {
        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) {
            ret = ret.multiply(BigInteger.valueOf(i));
        }
        return ret;
    }

    public static int NoRecursiveFact(int n) {
        int ret = 1;
        for (int i = 1; i <= n; ++i) {
            ret *= i;
        }
        return ret;
    }

    public static BigInteger BigStreamedFact(int n) {
        if(n < 2) {
            return BigInteger.valueOf(1);
        }
        return IntStream.rangeClosed(2, n).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }

}
