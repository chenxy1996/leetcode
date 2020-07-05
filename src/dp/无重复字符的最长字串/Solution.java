package dp.无重复字符的最长字串;

import java.util.*;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int max = 1;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int p;
            if ((p = sb.indexOf(String.valueOf(c))) != -1) {
                dp[i] = sb.length() - p - 1 + 1;
                sb = sb.delete(0, p + 1);
            } else {
                dp[i] = dp[i - 1] + 1;
            }

            sb.append(c);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }
}
