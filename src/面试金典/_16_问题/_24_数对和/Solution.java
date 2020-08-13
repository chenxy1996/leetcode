package 面试金典._16_问题._24_数对和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                ans.add(List.of(nums[l], nums[r]));
                l++;
                r--;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,6,5};
        System.out.println(solution.pairSums(nums, 11));
    }
}
