package 题目._6_Z字形变换;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String convert(String s, int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
        }

        // TODO
        return null;
    }

    public static String draw(String s, int numRows) {
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
        String s = "LEETCODEISHIRING;LEETCODEISHIRING;LEETCODEISHIRING";
        int rowNums = 5;
        System.out.println(draw(s, rowNums));
    }
}
