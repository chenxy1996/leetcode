package 题目._0131_分割回文串;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
            }
        }
        dfs(s, 0, dp, new ArrayList<>());
        return ans;
    }

    private void dfs(String s, int p, boolean[][] dp, List<String> bag) {
        if (p == s.length()) {
            ans.add(new ArrayList<>(bag));
        }
        for(int i = p; i < s.length(); i++) {
            if(dp[p][i]) {
                bag.add(s.substring(p, i + 1));
                dfs(s, i + 1, dp, bag);
                bag.remove(bag.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        System.out.println(solution.partition(s));
    }
}
