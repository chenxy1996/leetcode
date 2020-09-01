package 题目._22_中等_括号生成;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        fill(n, 0, "");
        return res;
    }
    private void fill(int n, int m, String s) {
        if (n == 0 && m == 0) {
            res.add(s);
        }

        if (n > 0) { // 添加一个 '('
            fill(n - 1, m + 1, s + '(');
        }
        // 添加一个 ')'
        if (m > 0) {
            fill(n, m - 1, s + ')');
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}
