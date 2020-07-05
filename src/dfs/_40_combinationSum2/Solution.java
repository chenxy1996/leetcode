package dfs._40_combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates != null && candidates.length != 0) {
            Arrays.sort(candidates);
            find(candidates, 0, 0, target, new ArrayList<>(), res);
        }
        return res;
    }

    private void find(int[] candidates, int start, int nowSum, int target, List<Integer> temp, List<List<Integer>> res) {
        if (nowSum == target) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                if (candidates[i] + nowSum > target) {
                    break;
                } else {
                    temp.add(candidates[i]);
                    find(candidates, i + 1, nowSum + candidates[i], target, temp, res);

                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;

        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(candidates, target));
    }
}
