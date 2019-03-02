package ru.course.lambda.expressions.homework;

import java.util.Optional;
import java.util.function.Function;
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
        Stream.of(ints).flatMap(new Function<int[], Stream<?>>() {
            @Override
            public Stream<?> apply(int[] ints) {

                return null;
            }
        });
    }

}
