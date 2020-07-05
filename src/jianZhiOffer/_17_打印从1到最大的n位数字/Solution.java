package jianZhiOffer._17_打印从1到最大的n位数字;

import java.awt.datatransfer.FlavorEvent;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
//    public int[] printNumbers(int n) {
//        IntStream.Builder builder = IntStream.builder();
//        int i = 1;
//        while (i < Math.pow(10, n)) {
//            builder.add(i);
//            i++;
//        }
//
//        return builder.build().toArray();
//    }

    /**
     * 考虑大数
     */

    public static void printNumbers(int level) {
        Stream.Builder<String> sb = Stream.builder();
        recur(sb, "", level);
        System.out.println(sb.build().collect(Collectors.joining(",")));
    }

    private static void recur( Stream.Builder<String> stream, String s, int level) {
        if  (level == 0) {
            while (s.startsWith("0")) {
                s = s.substring(1);
            }
            if (s.length() != 0)
                stream.add(s);
        } else {
            for (int i = 0; i <= 9; i++) {
                recur(stream, s + i, level - 1);
            }
        }
    }

    public static void main(String[] args) {
        printNumbers(7);
    }
}
