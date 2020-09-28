package 题目._0041_缺失的最小正整数;

/**
 * 41 题
 */
public class Solution {
    public static int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (val - 1 < nums.length && nums[val - 1] > 0) {
                nums[val - 1] = -nums[val - 1];
            }
        }

        int i;
        for(i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
    }
}
