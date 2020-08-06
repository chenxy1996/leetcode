package 剑指offer._48_最长不含重复字符的子字符串;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            String ss = s.substring(i, i + 1);
            int p;
            if ((p = sb.indexOf(ss)) != -1) {
                sb = sb.delete(0, p + 1);
            }
            sb.append(ss);
            max = Math.max(max, sb.length());
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
