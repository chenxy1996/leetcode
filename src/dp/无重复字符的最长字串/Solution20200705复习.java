package dp.无重复字符的最长字串;

public class Solution20200705复习 {
    public static int lengthOfLongestSubstring(String s) {
        // dp[i] 代表以第 i 个字符为结尾字符的最大不重复字符串长度
        int[] dp = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int index;
            String c = s.substring(i, i + 1);
            if ((index = sb.indexOf(c)) != - 1) {
                sb = sb.delete(0, index + 1);
                dp[i] = sb.length() + 1;
            } else {
                dp[i] = i > 0 ? dp[i - 1] + 1 : 1;
            }
            sb.append(c);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcaefgabtde";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
