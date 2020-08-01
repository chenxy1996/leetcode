package 面试金典._08_递归问题._08_中等_有重复字符串的排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public String[] permutation(String S) {
        if (S == null) {
            return new String[0];
        }
        List<String> ans = new ArrayList<>();
        permutation(S.toCharArray(), 0, ans);
        return ans.toArray(String[]::new);
    }

    private void permutation(char[] chars, int k, List<String> ans) {
        if (k >= chars.length) {
            ans.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = k; i < chars.length; i++) {
            char c = chars[i];
            if (!set.contains(c)) {
                set.add(c);
                swap(chars, i, k);
                permutation(chars, k + 1, ans);
                swap(chars, i, k);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "FrxR";
        System.out.println(Arrays.toString(new Solution().permutation(s)));
    }
}
