package jianZhiOffer._39_组合总和_用dp就是难;

import java.util.ArrayList;
import java.util.List;

// 可以用 dfs
// 可以用双指针

/**
 * 这次用 dp 尝试
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] dp = new List[target + 1];

        // 初始化 dp
        for (int i = 1; i < dp.length; i++) {
            if (i % candidates[0] == 0) {
                List<List<Integer>> out = new ArrayList<>();
                List<Integer> in = new ArrayList<>();
                for (int k = 0; k < (i / candidates[0]); k++)
                    in.add(candidates[0]);
                out.add(in);
                dp[i] = out;
            }
        }

        for (int j = 1; j < candidates.length; j++) {
            List<List<Integer>>[] temp = new List[target + 1];
            for (int i = 1; i < dp.length; i++) {
                List<List<Integer>> out = temp[i];
                // 不选择当前 candidate
                // 判断是否
                if (dp[i] != null) {
                    out = new ArrayList<>();
                    for (List<Integer> integers : dp[i]) {
                        List<Integer> in = new ArrayList<>();
                        in.addAll(integers);
                        out.add(in);
                    }
                }

                // 选择当前candidate
                // 刚好相等
                if (i % candidates[j] == 0) {
                    if (out == null) {
                        out = new ArrayList<>();
                    }
                    List<Integer> in = new ArrayList<>();
                    for (int k = 0; k < (i / candidates[j]); k++)
                        in.add(candidates[j]);
                    out.add(in);
                }

                // 选择当前candidate
                for (int t = 1; t <= i / candidates[j]; t++) {
                    if ((i - candidates[j] * t > 0) && (dp[i - candidates[j] * t] != null)) {
                        if (out == null) {
                            out = new ArrayList<>();
                        }
                        for (List<Integer> integers : dp[i - candidates[j] * t]) {
                            List<Integer> in = new ArrayList<>();
                            in.addAll(integers);
                            for (int k = 0; k < t; k++)
                                in.add(candidates[j]);
                            out.add(in);
                        }
                    }
                }

                temp[i] = out;
            }

            dp = temp;
        }

        return dp[dp.length - 1] != null ? dp[dp.length - 1] : new ArrayList<>();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
