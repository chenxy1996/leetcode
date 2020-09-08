package 题目._0014_最长公共前缀;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean find = false;
        while (i < strs[0].length() && !find) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                sb.append(c);
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"a"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
