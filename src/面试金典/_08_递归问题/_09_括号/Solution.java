package 面试金典._08_递归问题._09_括号;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0, n, "", ans);
        return ans;
    }

    // n 是还没有被 ")" 销掉的 "(" 的数量
    private void generate(int n, int left, String s, List<String> ans) {
        if (left == 0 && n == 0) {
            ans.add(s);
            return;
        }
        if (left > 0) {
            generate(n + 1, left - 1, s + "(", ans);
        }
        if (n > 0) {
            generate(n - 1, left, s + ")", ans);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(1));
    }
}
