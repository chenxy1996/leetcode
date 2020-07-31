package 面试金典._08_递归问题._04_幂集;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020/7/31 这道题，我记得以前有个很好的解法，但是忘记了，就只能用递归做了
 */
public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        inject(nums, 0, new ArrayList<>());
        ans.add(new ArrayList<>());
        return ans;
    }

    private void inject(int[] nums, int i, List<Integer> list) {
        if (i >= nums.length) {
            return;
        }
        while (i < nums.length) {
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            inject(nums, i + 1, list);
            list.remove(list.size() - 1);
            i++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution.subsets(nums));
    }

}
