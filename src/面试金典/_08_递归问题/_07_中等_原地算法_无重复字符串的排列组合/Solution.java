package 面试金典._08_递归问题._07_中等_原地算法_无重复字符串的排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String[] permutation(String S) {
        if (S == null) {
            return new String[0];
        }
        List<String> ans = new ArrayList<>();
        int[] map = new int[9];
        permutation(map, S, new StringBuilder(), ans);
        return ans.toArray(String[]::new);
    }

    private void permutation(int[] map, String s, StringBuilder sb, List<String> ans) {
        if (sb.length() == s.length()) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[i] == 0) {
                sb.append(s.charAt(i));
                map[i] = 1;
                permutation(map, s, sb, ans);
                map[i] = 0;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(Arrays.toString(new Solution().permutation(s)));
    }
}
