package 题目._526_优美的排列;

import java.util.ArrayList;
import java.util.List;

/**
 * 初见，使用回溯的算法
 */
public class Solution {
    public int countArrangement(int N) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            nums.add(i);
        }
        return dfs(nums, 1);
    }
    private int dfs(List<Integer> nums, int p) {
        if (nums.isEmpty()) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);
            if (val % p == 0 || p % val == 0) {
                nums.remove(i);
                ans += dfs(nums, p + 1);
                nums.add(i, val);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countArrangement(3));
    }
}
