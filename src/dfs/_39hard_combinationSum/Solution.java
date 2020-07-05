package dfs._39hard_combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 排序
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        if (candidates != null && candidates.length != 0) {
            find(candidates, 0, 0, target, new ArrayList<>(), res);
        }
        return res;
    }

    private void find(int[] candidates, int start, int nowSum, int target, List<Integer> temp, List<List<Integer>> res) {
        if (nowSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (nowSum + candidates[i] > target) {
                break;
            } else {
                temp.add(candidates[i]);
                find(candidates, i, nowSum + candidates[i], target, temp, res);

                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;

        Solution solution = new Solution();
        System.out.println(solution.combinationSum(candidates, target));
    }
}
