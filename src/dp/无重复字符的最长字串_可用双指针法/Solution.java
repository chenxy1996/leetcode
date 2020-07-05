<<<<<<< HEAD:src/dp/无重复字符的最长字串/Solution.java
<<<<<<< HEAD
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
=======
package dp.无重复字符的最长字串;

import java.util.*;
=======
package dp.无重复字符的最长字串_可用双指针法;
>>>>>>> 5090e186e073249e4a331b25032675f98ac10c0b:src/dp/无重复字符的最长字串_可用双指针法/Solution.java

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
<<<<<<< HEAD:src/dp/无重复字符的最长字串/Solution.java
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
=======
>>>>>>> 5090e186e073249e4a331b25032675f98ac10c0b:src/dp/无重复字符的最长字串_可用双指针法/Solution.java
