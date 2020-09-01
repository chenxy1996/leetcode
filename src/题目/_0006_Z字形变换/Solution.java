package 题目._06_Z字形变换;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        boolean goDown = false;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            rows.get(row).append(c);
            if (row == 0 || row == numRows - 1) {
                goDown = ! goDown;
            }
            row = goDown ? row + 1 : row - 1;
        }
        return rows.stream().collect(Collectors.joining());
    }

    public static String draw(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char cr = ' ';

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int p = 0;
        int row = 0;
        int maxCapacity = numRows - 1;
        int capacity = maxCapacity;
        boolean goDown = false;

        while (p < s.length()) {
            if (row == 0 || row == numRows - 1) {
                capacity = maxCapacity;
                goDown = !goDown;
            }
            char c = s.charAt(p);
            StringBuilder sb = rows.get(row);
            for (int i = 0; i < capacity; i++) {
                if (i == 0) {
                    sb.append(c);
                } else {
                    sb.append(cr);
                }
            }
            row = goDown ? row + 1 : row - 1;
            p++;
            capacity--;
        }

        String res = "";
        for (int i = 0; i < numRows; i++) {
            StringBuilder line = rows.get(i);
            int end = line.length();
            while ((line.charAt(end - 1)) == cr) {
                end--;
            }
            res += line.substring(0, end);

            if (i < numRows - 1) {
                 res += System.lineSeparator();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "AB";
        int rowNums = 1;
        System.out.println(convert(s, rowNums));
    }
}
