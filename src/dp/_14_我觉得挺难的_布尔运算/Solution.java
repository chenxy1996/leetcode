package dp._14_我觉得挺难的_布尔运算;

import java.util.Arrays;

public class Solution {
    private char[] arr;
    private int[][][] dp;
    public int countEval(String s, int result) {
        arr = s.toCharArray();
        int len = arr.length;
        dp = new int[len][len][2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return rec(0, len - 1, result);
    }

    /**
     * 返回从索引start到end值为result的不同括号方案的个数
     */
    private int rec(int start, int end, int result) {
        if (start == end) {
            return arr[start] - '0' == result ? 1 : 0;
        }

        if (dp[start][end][result] != -1) {
            return dp[start][end][result];
        }

        int ansCount = 0;
        for (int k = start; k < end; k+=2) {
            char operator = arr[k + 1];
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    if (getBoolAns(i, j, operator) == result) {
                        ansCount += rec(start, k, i) * rec(k + 2, end, j);
                    }
                }
            }
        }

        dp[start][end][result] = ansCount;
        return ansCount;
    }

    private int getBoolAns(int val1, int val2, char operator) {
        switch (operator) {
            case '&':
                return val1 & val2;
            case '|':
                return val1 | val2;
            case '^':
                return val1 ^ val2;
        }
        return val1 & val2;
    }

    public static void main(String[] args) {
        String s = "0&0&0&1^1|0";
        Solution solution = new Solution();
        System.out.println(solution.countEval(s, 1));
    }
}
