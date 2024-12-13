package com.yuzukiku;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * コマンドライン引数に指定された1つの整数Nをもとに、
 * 1からNまでの整数をランダムな並び順で標準出力へ出力するアプリである。
 */
public class Main {
    public static void main(String[] args) {
        // 引数が1つではない場合はエラーで終了するである
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
            return; // 一応returnを入れるが、ここには到達しない
        }

        if (n < 1) {
            System.err.println("1以上の整数を指定する必要があるである");
            System.exit(1);
        }

        // 1～nまでの整数を生成してリスト化するである
        List<Integer> numbers = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toList());

        // リストをランダムシャッフルするである
        Collections.shuffle(numbers);

        // 結果を出力するである
        numbers.forEach(System.out::println);
    }
}
