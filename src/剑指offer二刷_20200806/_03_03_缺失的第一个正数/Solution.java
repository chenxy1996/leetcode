package 剑指offer二刷_20200806._03_03_缺失的第一个正数;

/**
 * 41 题
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] >= len + 1) {
                nums[i] = len + 2;
            }
        }
        for(int i = 0; i < len; i++) {
            int val = Math.abs(nums[i]);
            if (val - 1 < len && nums[val - 1] > 0) {
                nums[val - 1] = -nums[val - 1];
            }
        }
        int i;
        for(i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(new Solution().firstMissingPositive(nums));
    }
}
