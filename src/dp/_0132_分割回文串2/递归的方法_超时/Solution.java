package dp._0132_分割回文串2.递归的方法_超时;

public class Solution {
    private int ans = Integer.MAX_VALUE;

    public int minCut(String s) {
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
        dfs(s, 0, dp, 0);
        return ans - 1;
    }

    private void dfs(String s, int p, boolean[][] dp, int cnt) {
        if (p == s.length()) {
            ans = Math.min(ans, cnt);
        }
        for(int i = p; i < s.length(); i++) {
            if(dp[p][i]) {
                dfs(s, i + 1, dp, cnt + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";

        System.out.println(solution.minCut(s));
    }
}
