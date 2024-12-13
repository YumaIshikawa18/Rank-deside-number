package com.yuzukiku;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("引数に1つの整数Nを指定する必要があるである");
            System.exit(1);
        }

        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("整数として解釈できる引数を指定する必要があるである");
            System.exit(1);
            return;
        }

        if (n < 1) {
            System.err.println("1以上の整数を指定する必要があるである");
            System.exit(1);
        }

        List<Integer> numbers = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        numbers.forEach(System.out::println);
    }
}
