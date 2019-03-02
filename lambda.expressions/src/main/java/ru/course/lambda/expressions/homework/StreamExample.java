package ru.course.lambda.expressions.homework;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
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
        Optional<String> longerString = Stream.of(strings).max((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return 0;
            }
        });
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
    }
}
