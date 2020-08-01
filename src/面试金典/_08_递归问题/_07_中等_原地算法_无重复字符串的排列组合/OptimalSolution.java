package 面试金典._08_递归问题._07_中等_原地算法_无重复字符串的排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimalSolution {
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
        for (int i = k; i < chars.length; i++) {
            swap(chars, k, i);
            permutation(chars, k + 1, ans);
            swap(chars, k, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "qwer";
        System.out.println(Arrays.toString(new OptimalSolution().permutation(s)));
    }
}
